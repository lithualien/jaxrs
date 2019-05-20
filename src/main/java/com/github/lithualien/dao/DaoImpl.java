package com.github.lithualien.dao;

import com.github.lithualien.bike.Bike;
import com.github.lithualien.shop.Shop;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Class to manage the data and transfer it to the database. Using GlassFish 5.0.0 and MySQL.
 * @author Tomas Dominauskas
 */

public class DaoImpl implements Dao {

    private List<Bike> bikes;
    private List<Shop> shops;
    private Connection connection;
    private ResultSet result;

    /**
     * Class constructor to create a list and add few bike.
     */

    public DaoImpl() {
        connToDB();
        shops = new ArrayList<>();
        bikes = new ArrayList<>();
    }

    /**
     * Method to connect to the database from GlassFish.
     */

    private void connToDB() {
        InitialContext ctx;
        DataSource ds;
        try {
            ctx = new InitialContext();
            ds = (DataSource)ctx.lookup("jdbc/jax-rs");
            connection = ds.getConnection();
        }
        catch (NamingException | SQLException e) {
            e.printStackTrace();
        }

    }

    /**
     * Method to get all bikes from the database.
     * @return Returns the Bike object list.
     */

    public List<Bike> getBikes(int shopID) {
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT bike.id, bike.name, bike_type.type, bike_colour.colour, bike.weight, bike.gears, bike.wheel_size, bike.price, bike.shop_id\n" +
                    "FROM ((shop.bike \n" +
                    "INNER JOIN shop.bike_type ON bike.type_id = bike_type.id) \n" +
                    "INNER JOIN shop.bike_colour ON bike.colour_id = bike_colour.id)" +
                    "WHERE bike.shop_id = ?;");
            statement.setInt(1, shopID);
            result = statement.executeQuery();
            addDataToBikeList();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return bikes;
    }

    /**
     * Method to get all shops from the database.
     * @return Returns the Shop object list.
     */

    public List<Shop> getShops() {
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT shop.id, shop.name, shop.address, shop.number FROM shop.shop;");
            result = statement.executeQuery();
            addDataToShopList();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return shops;
    }

    /**
     * Method to get information about the selected shop.
     * @param id the id of the shop.
     * @return Shop object with information about the shop.
     */

    public List<Bike> getBike(int id) {
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT bike.id, bike.name, bike_type.type, bike_colour.colour, bike.weight, bike.gears, bike.wheel_size, bike.price, bike.shop_id\n" +
                    "FROM ((shop.bike\n" +
                    "INNER JOIN shop.bike_type ON bike.type_id = bike_type.id)\n" +
                    "INNER JOIN shop.bike_colour ON bike.colour_id = bike_colour.id)\n" +
                    "WHERE bike.id = ?;");
            statement.setInt(1, id);
            result = statement.executeQuery();
            addDataToBikeList();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return bikes;
    }

    /**
     * Method to add data to bike list.
     * @throws SQLException
     */

    private void addDataToBikeList() throws SQLException {
        while(result.next()) {
            Bike temp = new Bike(
                    result.getInt("id"),
                    result.getString("name"),
                    result.getString("type"),
                    result.getString("colour"),
                    result.getDouble("weight"),
                    result.getInt("gears"),
                    result.getDouble("wheel_size"),
                    result.getFloat("price"),
                    result.getInt("shop_id")
            );
            bikes.add(temp);
        }
    }

    /**
     * Method to add data to shop list.
     * @throws SQLException
     */

    private void addDataToShopList() throws SQLException {
        while (result.next()) {
            Shop temp = new Shop(
                    result.getInt("id"),
                    result.getString("name"),
                    result.getString("address"),
                    result.getString("number")
            );
            shops.add(temp);
        }
    }

    /**
     * Method to get the index of colour or type id.
     * @return the index of colour or type.
     * @throws SQLException
     */

    private int getIndex() throws SQLException {
        while (result.next()) {
            return result.getInt("id");
        }
        return 0;
    }

    /**
     * Method to get information about the selected shop.
     * @param id the id of the shop.
     * @return Shop object.
     */

    public List<Shop> getShop(int id) {
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT shop.id, shop.name, shop.address, shop.number FROM shop.shop WHERE shop.id = ?;");
            statement.setInt(1, id);
            result = statement.executeQuery();
            addDataToShopList();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return shops;
    }

    /**
     * Method to return Bike object list by selected colour.
     * @param colour the colour of the bike
     * @return Returns the Bike object list.
     */

    public List<Bike> getBikesByColourAndType(String colour, String type){
        List<Bike> temp = new ArrayList<>();
        for (Bike bike : bikes) {
            if (colour.equals(bike.getColour()) && type.equals(bike.getType())) {
                temp.add(bike);
            }
        }
        return temp;
    }

    /**
     * Method to return the Bike object of added bike.
     * @param bike the Bike object.
     * @return the Bike object of added bike.
     */

    public Bike addBike(Bike bike) {
        PreparedStatement statement;
        try {
            statement = connection.prepareStatement("INSERT INTO shop.bike (name, type_id, colour_id, weight, gears, wheel_size, price, shop_id) \n" +
                    "VALUES(?, ?, ?, ?, ?, ?, ?, ?);");
            setBikeStatement(bike, statement);
            statement.executeUpdate();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return bike;
    }

    /**
     * Method to add a new shop.
     * @param shop Shop class object.
     * @return the information about the new shop.
     */

    public Shop addShop(Shop shop) {
        PreparedStatement statement;
        try {
            statement = connection.prepareStatement("INSERT INTO shop.shop (name, address, number) \n" +
                    "VALUES(?, ?, ?);");
            setShopStatement(shop, statement);
            statement.executeUpdate();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }

        return shop;
    }

    /**
     * Method to delete the selected shop.
     * @param id the id of the shop.
     * @return true or false, depending on success of the operation.
     */

    public boolean deleteShop(int id) {
        PreparedStatement statement;
        try {
            statement = connection.prepareStatement("DELETE FROM shop.shop WHERE id = ?;");
            statement.setInt(1, id);
            statement.executeUpdate();
            return true;
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * Method to delete the selected bike.
     * @param id the id of the bike.
     * @return true or false, depending on success of the operation.
     */

    public boolean deleteBike(int id) {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement("DELETE FROM shop.bike WHERE id = ?;");
            statement.setInt(1, id);
            statement.executeUpdate();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * Method to update the selected bike.
     * @param id   the id of the bike.
     * @param bike the updated bike object.
     * @return the bike object of update bike.
     */

    public Bike updateBike(int id, Bike bike) {
        PreparedStatement statement;
        try {
            statement = connection.prepareStatement("UPDATE shop.bike SET name = ?, type_id = ?, colour_id = ?, weight = ?, gears = ?, wheel_size = ?, price = ?, shop_id = ? " +
                    "WHERE bike.id = ?;");
            setBikeStatement(bike, statement);
            statement.setInt(9, id);
            statement.executeUpdate();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return bike;
    }

    /**
     * Method to prepare all data, of bike, to be executed to the database.
     * @param bike the bike object to be updated.
     * @param statement the bike statement to be prepared for execution.
     * @throws SQLException
     */

    private void setBikeStatement(Bike bike, PreparedStatement statement) throws SQLException {
        PreparedStatement temp;
        statement.setString(1, bike.getBrand());
        temp = connection.prepareStatement("SELECT bike_type.id FROM shop.bike_type WHERE bike_type.type = ?;");
        temp.setString(1, bike.getType());
        result = temp.executeQuery();
        statement.setInt(2,  getIndex());
        temp = connection.prepareStatement("SELECT bike_colour.id FROM shop.bike_colour WHERE bike_colour.colour = ?;");
        temp.setString(1, bike.getColour());
        result = temp.executeQuery();
        statement.setInt(3,  getIndex());
        statement.setDouble(4, bike.getWeight());
        statement.setInt(5, bike.getGears());
        statement.setDouble(6, bike.getWheelSize());
        statement.setFloat(7, bike.getPrice());
        statement.setInt(8, bike.getShopID());
    }

    /**
     * Method to update the selected shop.
     * @param id   the id of the shop.
     * @param shop the updated shop object.
     * @return the shop object of update shop.
     */

    public Shop updateShop(int id, Shop shop) {
        PreparedStatement statement;
        try {
            statement = connection.prepareStatement("UPDATE shop.shop SET name = ?, address = ?, number = ?" +
                    "WHERE shop.id = ?");
            setShopStatement(shop, statement);
            statement.setInt(4, id);
            statement.executeUpdate();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return shop;
    }

    /**
     * Method  to prepare all data, of shop, to be executed to the database.
     * @param shop the shop object to be updated.
     * @param statement the shop statement to be prepared for execution.
     * @throws SQLException
     */

    private void setShopStatement(Shop shop, PreparedStatement statement) throws SQLException {
        statement.setString(1, shop.getName());
        statement.setString(2, shop.getAddress());
        statement.setString(3, shop.getNumber());
    }
}
