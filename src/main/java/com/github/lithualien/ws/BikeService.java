package com.github.lithualien.ws;

import com.github.lithualien.bike.Bike;

import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

public interface BikeService {
    Response getAll();
    Response countBikes();
    Bike addBike(Bike bike);
    Response updateBike(@PathParam("id") int id, Bike bike);
}
