package com.github.lithualien.ws;

import com.github.lithualien.dao.Dao;
import com.github.lithualien.dao.DaoImpl;
import com.github.lithualien.shop.Shop;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * RESTful web service for shops.
 * @author Tomas Dominauskas
 */

@Path("shops")
public class ShopResource {
    private Dao dao = new DaoImpl();

    /**
     * Web service to receive all shops from database.
     * @return Returns the list of shop object with all shops on the database.
     */

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getShops() {
        return Response.ok()
                .entity(dao.getShops())
                .build();
    }

    /**
     * Web service to receive selected shop from the database.
     * @param shopID the shopID of selected shop.
     * @return Returns the shop object of selected shop.
     */

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{shopID}")
    public Response getShop(@PathParam("shopID") int shopID) {
        return Response.ok()
                .entity(dao.getShop(shopID))
                .build();
    }

    /**
     * Nested resource to BikeResource class.
     * @param shopID the id of the shop.
     * @return BikeResource class.
     */

    @Path("{shopID}/bikes")
    public BikeResource getBikeResource(@PathParam("shopID") int shopID) {
        return new BikeResource();
    }

    /**
     * Web service to add a new shop to the database.
     * @param shop the shop object with all information.
     * @return Returns the added shop object.
     */

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addShop(Shop shop) {
        return Response.ok()
                .entity(dao.addShop(shop))
                .build();
    }

    /**
     * Web service to delete an existing shop.
     * @param shopID the shopID of shop to delete.
     * @return Returns true or false, depending on the operation success.
     */

    @DELETE
    @Path("{shopID}")
    public Response deleteShop(@PathParam("shopID") int shopID) {
        return Response.ok()
                .entity(dao.deleteShop(shopID))
                .build();
    }

    /**
     * Web service to update an existing shop.
     * @param shopID the shopID of the shop to update.
     * @param shop the shop object of updated shop.
     * @return Returns the shop object of updated shop.
     */

    @PUT
    @Path("{shopID}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateShop(@PathParam("shopID") int shopID, Shop shop) {
        return Response.ok()
                .entity(dao.updateShop(shopID, shop))
                .build();
    }

}
