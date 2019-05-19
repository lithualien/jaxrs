package com.github.lithualien.ws;

import com.github.lithualien.dao.Dao;
import com.github.lithualien.dao.DaoImpl;
import com.github.lithualien.shop.Shop;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/shop")
public class ShopService {
    private Dao dao = new DaoImpl();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getShops() {
        return Response.ok()
                .entity(dao.getShops())
                .build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public Response getShop(@PathParam("id") int id) {
        return Response.ok()
                .entity(dao.getShop(id))
                .build();
    }


    @GET
    @Path("/bikes")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getBikesByColour(@MatrixParam("colour") String colour,
                                     @MatrixParam("type") String type) {
        return Response.ok()
                .entity(dao.getBikesByColourAndType(colour, type))
                .build();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addShop(Shop shop) {
        return Response.ok()
                .entity(dao.addShop(shop))
                .build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteShop(@PathParam("id") int id) {
        return Response.ok()
                .entity(dao.deleteShop(id))
                .build();
    }

}
