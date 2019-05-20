package com.github.lithualien.shop;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ShopTest {

    private Shop shop1, shop2;

    @Before
    public void setUp() {
        shop1 = new Shop();
    }

    @After
    public void tearDown() {
        shop1 = null;
        shop2 = null;
    }

    @Test
    public void getNumber() {
        shop1.setNumber("+37061234567");
        assertEquals("+37061234567", shop1.getNumber());
    }

    @Test
    public void getAddress() {
        shop1.setAddress("Verkių g. 45, Vilnius");
        assertEquals("Verkių g. 45, Vilnius", shop1.getAddress());
    }

    @Test
    public void getName() {
        shop1.setName("BikeShopas");
        assertEquals("BikeShopas", shop1.getName());
    }

    @Test
    public void getID() {
        shop1.setID(1);
        assertEquals(1, shop1.getID());
    }

    @Test
    public void toString1() {
        shop2 = new Shop( 1, "BikeShopas", "Verkių g. 45, Vilnius", "+37061234567");
        assertEquals("ID: 1\nname : BikeShopas\naddress: Verkių g. 45, Vilnius\nnumber: +37061234567\n", shop2.toString());
    }
}