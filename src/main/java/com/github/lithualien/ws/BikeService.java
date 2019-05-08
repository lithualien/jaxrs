package com.github.lithualien.ws;

import com.github.lithualien.dao.Dao;
import com.github.lithualien.dao.DaoImpl;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/bikes")
public class BikeService {
    private Dao dao = new DaoImpl();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAll() {
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

    @GET
    @Path("/list")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getBikesByColour(@MatrixParam("colour") String colour) {
        return Response.ok()
                .entity(dao.getBikesByColour(colour))
                .build();
    }

    /*@GET
    @Path("/list")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getBikesByType(@MatrixParam("type") String type) {
        return Response.ok()
                .entity(dao.getBikesByType(type))
                .build();
    }*/
/*
    @GET
    @Path("/list")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getBikesByTypeAndColour(@MatrixParam("type") String type,
                                   @MatrixParam("colour") String colour) {
        return Response.ok()
                .entity(dao.getBikesByTypeAndColour(type, colour))
                .build();
    }
*/
}
