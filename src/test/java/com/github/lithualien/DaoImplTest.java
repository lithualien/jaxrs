package com.github.lithualien;

import com.github.lithualien.bike.Bike;
import com.github.lithualien.dao.Dao;
import com.github.lithualien.dao.DaoImpl;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class DaoImplTest {

    private Dao dao;

    @Before
    public void setUp() throws Exception {
        dao = new DaoImpl();
    }

    @After
    public void tearDown() throws Exception {
        dao = null;
    }

    @Test
    public void addBike() {
        Bike bike = new Bike(1, "test", "electric", "yellow", 12.4, 21, 14.4, 749.99f, 1);
        dao.addBike(bike);
    }
}