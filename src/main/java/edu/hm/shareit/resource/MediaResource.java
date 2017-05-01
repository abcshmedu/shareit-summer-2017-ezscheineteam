package edu.hm.shareit.resource;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import edu.hm.shareit.business.MediaService;
import edu.hm.shareit.business.MediaServiceImpl;
import edu.hm.shareit.business.ServiceResult;
import edu.hm.shareit.business.ServiceStatus;
import edu.hm.shareit.model.Book;
import edu.hm.shareit.model.Disc;
import edu.hm.shareit.model.Medium;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.xml.ws.Service;

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
        System.out.println("Suche Buch mit ISBN: " + isbn);
        ServiceResult r = mediaService.getBook(isbn);
        ServiceStatus s = r.getStatus();

        return Response.status(s.getStatus()).entity(toJson(r.getResult())).build();
    }

    /**
     *
     * @return Response
     */
    @GET
    @Path("books")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getBooks() {
        ServiceResult r = mediaService.getBooks();
        return Response.ok()
                .entity(toJson(r.getResult()))
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
        ServiceResult r = mediaService.getDiscs();
        return Response.ok()
                .entity(toJson(r.getResult()))
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
        ServiceResult r = mediaService.getDisc(barcode);
        ServiceStatus s = r.getStatus();
        return Response.status(s.getStatus())
                .entity(toJson(r.getResult()))
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
        ServiceStatus result = mediaService.addBook(b);
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
        ServiceStatus result = mediaService.addDisc(d);
        return Response.status(result.getStatus()).entity(toJson(result)).build();
    }

    /**
     *
     * @param book
     * @return
     */
    @PUT
    @Path("books/{isbn}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateBook(Book book, @PathParam("isbn") String isbn) {
        System.out.println(book.getIsbn());
        System.out.println(isbn);
        ServiceStatus s = mediaService.updateBook(book, isbn);
        return Response.status(s.getStatus()).entity(toJson(s)).build();
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
