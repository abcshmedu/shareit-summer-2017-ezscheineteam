package edu.hm.shareit.resource;

import edu.hm.shareit.business.MediaService;
import edu.hm.shareit.business.MediaServiceImpl;
import edu.hm.shareit.business.ServiceResult;
import edu.hm.shareit.business.ServiceStatus;
import edu.hm.shareit.model.Book;
import edu.hm.shareit.model.Disc;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *  Contains the rest api handlers.
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
        ServiceResult r = mediaService.getBook(isbn);
        ServiceStatus s = r.getStatus();

        if (s != ServiceStatus.OK) {
            return Response.status(s.getStatus()).entity(s).build();
        }

        return Response.ok().entity(r.getResult()).build();
    }

    /**
     * Returns all books.
     * @return Response to the request.
     */
    @GET
    @Path("books")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getBooks() {
        ServiceResult result = mediaService.getBooks();
        ServiceStatus status = result.getStatus();
        return Response.status(status.getStatus())
                .entity(result.containsResult() ? result.getResult() : status)
                .build();
    }

    /**
     * Returns all discs.
     * @return Response to the request.
     */
    @GET
    @Path("discs")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getDiscs() {
        ServiceResult result = mediaService.getDiscs();
        ServiceStatus status = result.getStatus();
        return Response.status(status.getStatus())
                .entity(result.containsResult() ? result.getResult() : status)
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
                .entity(r.getResult())
                .build();
    }

    /**
     * Creates a new book.
     * @param b The new book to be created.
     * @return the response the the request.
     */
    @POST
    @Path("books")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createBook(Book b) {
        ServiceStatus result = mediaService.addBook(b);
        return Response.status(result.getStatus()).entity(result).build();
    }

    /**
     * Creates a new disc.
     * @param d the disc to be created.
     * @return The response to the request.
     */
    @POST
    @Path("discs")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createDisc(Disc d) {
        ServiceStatus result = mediaService.addDisc(d);
        return Response.status(result.getStatus()).entity(result).build();
    }

    /**
     * Updates an existing book with an other book.
     * @param book the book with updated values.
     * @param isbn the isbn of the book to be updated.
     * @return the response to the request.
     */
    @PUT
    @Path("books/{isbn}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateBook(Book book, @PathParam("isbn") String isbn) {
        ServiceStatus s = mediaService.updateBook(book, isbn);
        return Response.status(s.getStatus()).entity(s).build();
    }

    /**
     * Updates an existing disc with another disc.
     * @param disc the disc with updated values.
     * @param barcode the barcode of the book to be updated.
     * @return the response to the request.
     */
    @PUT
    @Path("discs/{barcode}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateDisc(Disc disc, @PathParam("barcode") String barcode) {
        ServiceStatus s = mediaService.updateDisc(disc, barcode);
        return Response.status(s.getStatus()).entity(s).build();
    }
}
