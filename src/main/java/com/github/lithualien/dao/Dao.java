package com.github.lithualien.dao;
import com.github.lithualien.bike.Bike;
import com.github.lithualien.shop.Shop;

import java.util.List;

/**
 * The Data Access Object to save and transfer data to web service.
 * @author Tomas Dominauskas
 */

public interface Dao {

    /**
     * Method to get all bike.
     * @return the list of all bike.
     */

    List<Bike> getBikes();

    /**
     * Method to get all shops.
     * @return Returns the Shop object list.
     */

    List<Shop> getShops();

    /**
     * Method to get information about the selected shop.
     * @param id the id of the shop.
     * @return Returns the Shop object.
     */

    Bike getBike(int id);

    /**
     * Method to get information about the selected shop.
     * @param id the id of the shop.
     * @return Returns the Shop object.
     */

    Shop getShop(int id);

    /**
     * Method to return Bike object list by selected colour.
     * @param colour the colour of the bike
     * @return Returns the Bike object list.
     */

    List<Bike> getBikesByColour(String colour);

    /**
     * Method to return Bike object list by selected type.
     * @param type the type of the bike
     * @return Returns the Bike object list.
     */

    //List<Bike> getBikesByType(String type);

    /**
     * Method to return Bike object list by selected type and colour.
     * @param type tje type of the bike.
     * @param colour the colour of the bike
     * @return Returns the Bike object list.
     */

    //List<Bike> getBikesByTypeAndColour(String type, String colour);
}
