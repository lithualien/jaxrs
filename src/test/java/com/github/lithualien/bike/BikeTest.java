package com.github.lithualien.bike;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BikeTest {

    private Bike bike1;
    private Bike bike2;

    @Before
    public void setUp() {
        bike1 = new Bike();
    }

    @After
    public void tearDown() {
        bike1 = null;
    }

    @Test
    public void getID() {
        bike1.setID(5);
        assertEquals(5, bike1.getID());
    }

    @Test
    public void getBrand() {
        bike1.setBrand("Baltik Vairas");
        assertEquals("Baltik Vairas", bike1.getBrand());
    }

    @Test
    public void getType() {
        bike1.setType("Plento");
        assertEquals("Plento", bike1.getType());
    }

    @Test
    public void getColour() {
        bike1.setColour("Raudona");
        assertEquals("Raudona", bike1.getColour());
    }

    @Test
    public void getWeight() {
        bike1.setWeight(15.5);
        assertEquals(15.5, bike1.getWeight(), 0.01);
    }

    @Test
    public void getGears() {
        bike1.setGears(21);
        assertEquals(21, bike1.getGears());
    }

    @Test
    public void getWheelSize() {
        bike1.setWheelSize(9);
        assertEquals(9, bike1.getWheelSize(),0.001);
    }

    @Test
    public void getPrice() {
        bike1.setPrice(499.99f);
        assertEquals(499.99f, bike1.getPrice(), 0.01);
    }

    @Test
    public void getShopID() {
        bike1.setShopID(1);
        assertEquals(1, bike1.getShopID());
    }

    @Test
    public void toString1() {
        bike2 = new Bike(1, "Baltik Vairas", "plento", "raudona", 15.5, 21, 9, 499.99f, 1);
        assertEquals("1. Gamintojas: Baltik Vairas | Rūšis: plento | Svoris: 15.5kg | Spalva: raudona | Pavarų kiekis: 21 | Rato dydis: 9.0 inch. | Kaina: 499,99 €\n",
                bike2.toString());
    }
}