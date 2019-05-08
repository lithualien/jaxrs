package com.github.lithualien.ws;

import com.github.lithualien.dao.Dao;
import com.github.lithualien.dao.DaoImpl;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/shops")
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
    public Response getBike(@PathParam("id") int id) {
        return Response.ok()
                .entity(dao.getShop(id))
                .build();
    }
}
