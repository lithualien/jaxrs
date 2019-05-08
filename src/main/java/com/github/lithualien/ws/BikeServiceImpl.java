package com.github.lithualien.ws;

import com.github.lithualien.bike.Bike;
import com.github.lithualien.dao.BikeDao;
import com.github.lithualien.dao.BikeDaoImpl;
import com.github.lithualien.shop.Shop;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/bike")
public class BikeServiceImpl implements BikeService {
    private BikeDao bikeDao = new BikeDaoImpl();

    @GET
    @Path("/all")
    public Response getAll() {
        return Response.ok()
                .entity(bikeDao.getAll())
                .build();
    }

    @GET
    @Path("/count")
    public Response countBikes() {
        return Response.ok()
                .entity(bikeDao.countBikes())
                .build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/add")
    public Bike addBike(Bike bike) {
        return bikeDao.addBike(bike);
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/fakultetai/{id}")
    public Response updateBike(@PathParam("id") int id, Bike bike) {
        return Response.ok()
                .entity(bikeDao.updateBike(id, bike))
                .build();
    }

}
