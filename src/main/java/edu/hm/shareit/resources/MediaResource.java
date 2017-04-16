package edu.hm.shareit.resources;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import edu.hm.shareit.business.MediaService;
import edu.hm.shareit.business.MediaServiceImpl;
import edu.hm.shareit.business.MediaServiceResult;
import edu.hm.shareit.model.Book;
import edu.hm.shareit.model.Medium;
import edu.hm.shareit.repository.MediaRepository;
import edu.hm.shareit.repository.MediaRepositoryStub;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 */
@Path("media")
public class MediaResource {
    private MediaRepository mediaRepository = new MediaRepositoryStub();
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
        System.out.println(b.getTitle());
        System.out.println(b.getAuthor());
        System.out.println(b.getIsbn());
        MediaServiceResult result = mediaService.addBook(b);
        if (result != MediaServiceResult.OK) {
            return Response.status(result.getStatus()).entity(toJson(result)).build();
        }
        return Response.ok().build();
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
    public Response update(Book book) {
        System.out.println(book.getIsbn());
        mediaService.updateBook(book);
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
