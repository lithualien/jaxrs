package com.github.lithualien.dao;

import com.github.lithualien.bike.Bike;
import com.github.lithualien.shop.Shop;

import java.util.ArrayList;
import java.util.List;

/**
 * Class to manage the data and transfer it to the
 * @author Tomas Dominauskas
 */

public class BikeDaoImpl implements BikeDao {

    private List<Bike> bikes;
    private int i = 3;

    /**
     * Class constructor to create a list and add few bike.
     */

    public BikeDaoImpl() {
        bikes = new ArrayList<>();
        bikes.add(new Bike(1, "Baltic Wheel", "Electric", "White", 14.25, 21, 8, 989.99f, new Shop("Verkiu g. 45, Vilnius", "37061234567")));
        bikes.add(new Bike(2, "Baltic Wheel", "Electric", "Red", 14.35, 20, 9, 989.99f, new Shop("Verkiu g. 45, Vilnius", "37061234567")));
    }

    /**
     * Method to get all bike.
     * @return the list of all bike.
     */

    public List<Bike> getAll() {
        return bikes;
    }

    /**
     * Method to add a new bike.
     * @return the new bike.
     */

    public Bike addBike(Bike bike) {
        bikes.add(bike);
        i++;
        return bike;
    }

    /**
     * Method to update the existing bike.
     * @param ID the id of the bike.
     * @return the updated bike.
     */

    public Bike updateBike(int ID, Bike bike) {
        int counter = 0;

        for (Bike temp : bikes) {
            if(temp.getID() == ID) {
                bikes.set(counter, bike);
                break;
            }
            counter++;
        }
        return bikes.get(counter);
    }

    /**
     * Method to delete the existing bike.
     * @param ID the id of the bike.
     * @return true or false, depending of success of the operation.
     */

    public boolean deleteBike(int ID) {
        int counter = 0;
        for (Bike temp : bikes) {
            if(temp.getID() == ID) {
                bikes.remove(counter);
                return true;
            }
            counter++;
        }
        return false;
    }

    /**
     * Method to count the amount of the bike.
     * @return number of the bike.
     */

    public int countBikes() {
        return bikes.size();
    }
}
