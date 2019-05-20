package com.github.lithualien.ws;

import com.github.lithualien.bike.Bike;
import com.github.lithualien.dao.Dao;
import com.github.lithualien.dao.DaoImpl;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * RESTful web service for bikes.
 * @author Tomas Dominauskas
 */

public class BikeResource {
    private Dao dao = new DaoImpl();

    /**
     * Web service to receive all bikes from database.
     * @return Returns the list of bike object with all bikes on the database.
     */

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getBikes(@PathParam("shopID") int shopID) {
        return Response.ok()
                .entity(dao.getBikes(shopID))
                .build();
    }

    /**
     * Web service to receive selected bike from the database.
     * @param id the id of selected bike.
     * @return Returns the bike object of selected bike.
     */

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public Response getBike(@PathParam("id") int id) {
        return Response.ok()
                .entity(dao.getBike(id))
                .build();
    }

    /**
     * Web service to add a new bike to the database.
     * @param bike the bike object with all information.
     * @return Returns the added bike object.
     */

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addBike(Bike bike) {
        return Response.ok()
                .entity(dao.addBike(bike))
                .build();
    }

    /**
     * Web service to delete an existing bike.
     * @param id the id of bike to delete.
     * @return Returns true or false, depending on the operation success.
     */

    @DELETE
    @Path("/{id}")
    public Response deleteBike(@PathParam("id") int id) {
        return Response.ok()
                .entity(dao.deleteBike(id))
                .build();
    }

    /**
     * Web service to update an existing bike.
     * @param id the id of the bike to update.
     * @param bike the bike object of updated bike.
     * @return Returns the bike object of updated bike.
     */

    @PUT
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateBike(@PathParam("id") int id, Bike bike) {
        return Response.ok()
                .entity(dao.updateBike(id, bike))
                .build();
    }

}
