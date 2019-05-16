package com.github.lithualien.ws;

import com.github.lithualien.bike.Bike;
import com.github.lithualien.dao.Dao;
import com.github.lithualien.dao.DaoImpl;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("shop/bikes")
public class BikeService {
    private Dao dao = new DaoImpl();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getBikes() {
        return Response.ok()
                .entity(dao.getBikes())
                .build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public Response getBike(@PathParam("id") int id) {
        return Response.ok()
                .entity(dao.getBike(id))
                .build();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addBike(Bike bike) {
        return Response.ok()
                .entity(dao.addBike(bike))
                .build();
    }

}
