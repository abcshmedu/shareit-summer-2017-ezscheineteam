package edu.hm.shareit.resources;

import edu.hm.shareit.model.Disc;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Routet alle MediaTypen.
 */
public class MediaRouting {

    MediaResource resource = new MediaResource();
    @GET
    @Path("/{param}")
    public Response getMsg(@PathParam("param") String msg) {
        String output = "Jersey say : " + msg;
        return Response.status(200).entity(output).build();
    }


    /**
     * Gibt alle Bücher in einer Liste zurück.
     * @return Reponse mit einer Liste von allen Büchern.
     */
    @GET
    @Path("/books")
    public Response getBooks() {

        return Response.status(Response.Status.OK).build();
    }

    /**
     * Erstellt eine neue CD.
     * @return
     */
    @POST
    @Path("/discs")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createDisc(Disc disc) {
        System.out.println(disc);
        return Response.status(Response.Status.OK).build();
    }

    @GET()
    @Path("/discs/{barcode}")
    public Response getDisc(@PathParam("barcode") String barcode) {
        return Response.status(Response.Status.OK).build();
    }

    @GET
    @Path("/discs")
    public Response getDiscList() {
        return Response.status(Response.Status.OK).build();
    }

    @PUT
    public Response changeDisc() {
        return Response.status(Response.Status.OK).build();
    }
}
