package edu.hm.shareit.resource;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import edu.hm.shareit.business.MediaService;
import edu.hm.shareit.business.MediaServiceImpl;
import edu.hm.shareit.business.MediaServiceResult;
import edu.hm.shareit.model.Book;
import edu.hm.shareit.model.Disc;
import edu.hm.shareit.model.Medium;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 */
@Path("media")
public class MediaResource {
    private MediaService mediaService = new MediaServiceImpl();

    /**
     * Gibt das Buch zur passenden ISBN zurück.
     * @param isbn Die ISBN des Buches.
     * @return Response mit Buchinformationen.
     */
    @GET
    @Path("books/{isbn}") // http:localhost:8080/shareit/media/books/{isbn}
    @Produces(MediaType.APPLICATION_JSON)
    public Response getBook(@PathParam("isbn") String isbn) {
        if (isbn == null || isbn.length() < 4) {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
        Medium m = mediaService.getBook(isbn);
        if (m == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.status(Response.Status.OK).entity(toJson(m)).build();
    }

    /**
     *
     * @return Response
     */
    @GET
    @Path("books")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getBooks() {
        Medium[] medias = mediaService.getBooks();
        return Response.ok()
                .entity(toJson(medias))
                .build();
    }

    /**
     *
     * @return Response
     */
    @GET
    @Path("discs")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getDiscs() {
        Medium[] medias = mediaService.getDiscs();
        return Response.ok()
                .entity(toJson(medias))
                .build();
    }

    /**
     * Gibt das Buch zur passenden ISBN zurück.
     * @param barcode Die ISBN des Buches.
     * @return Response mit Buchinformationen.
     */
    @GET
    @Path("discs/{barcode}") // http:localhost:8080/shareit/shareit/media/books/{isbn}
    @Produces(MediaType.APPLICATION_JSON)
    public Response getDisc(@PathParam("barcode") String barcode) {
        Medium m = mediaService.getDisc(barcode);
        if (m == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok()
                .entity(toJson(m))
                .build();
    }

    /**
     *
     * @param b
     * @return
     */
    @POST
    @Path("books")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createBook(Book b) {
        MediaServiceResult result = mediaService.addBook(b);
        return Response.status(result.getStatus()).entity(toJson(result)).build();
    }

    /**
     *
     * @param d
     * @return
     */
    @POST
    @Path("discs")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createDisc(Disc d) {
        MediaServiceResult result = mediaService.addDisc(d);
        return Response.status(result.getStatus()).entity(toJson(result)).build();
    }

    /**
     *
     * @param book
     * @return
     */
    @PUT
    @Path("books/{mediaId}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateBook(Book book) {
        mediaService.updateBook(book);
        return Response.ok().build();
    }

    /**
     *
     * @param disc
     * @return
     */
    @PUT
    @Path("discs/{mediaId}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateDisc(Disc disc) {
        mediaService.updateDisc(disc);
        return Response.ok().build();
    }

    /**
     * Creates Json from an object.
     * @param obj the object.
     * @return Json-String
     */
    private String toJson(Object obj) {
        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        try {
            return mapper.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return "";
    }
}
