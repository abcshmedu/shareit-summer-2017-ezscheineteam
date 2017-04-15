package edu.hm.shareit.resources;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import edu.hm.shareit.model.Book;
import edu.hm.shareit.model.Disc;
import edu.hm.shareit.repository.MediaRepository;
import edu.hm.shareit.repository.MediaRepositoryStub;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

/**
 *
 */
@Path("media")
public class MediaResource {
    private MediaRepository mediaRepository = new MediaRepositoryStub();

    /**
     * Gibt das Buch zur passenden ISBN zurück.
     * @param isbn Die ISBN des Buches.
     * @return Response mit Buchinformationen.
     */
    @GET
    @Path("books/{isbn}") // http:localhost:8080/shareit/shareit/media/books/{isbn}
    @Produces(MediaType.APPLICATION_JSON)
    public Response getBook(@PathParam("isbn") String isbn) {
        Book b = mediaRepository.findBook(isbn);
        if (b != null) {
                return Response.status(Response.Status.OK).entity(toJson(b)).build();
        }
        return null;
    }

    /**
     *
     * @return Response
     */
    @GET
    @Path("books")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getBooks() {
        List<Book> allBooks = mediaRepository.findAllBooks();
        return Response.status(Response.Status.OK)
                .entity(toJson(allBooks))
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
        List<Disc> allDiscs = mediaRepository.findAllDiscs();
        return Response.status(Response.Status.OK)
                .entity(toJson(allDiscs))
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
        Disc d = mediaRepository.findDisc(barcode);
        if (d != null) {
                return Response.status(Response.Status.OK).entity(toJson(d)).build();
        }
        return null;
    }

    @POST
    @Path("books")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createBook(Book b)
    {
        System.out.println(b.getTitle());
        System.out.println(b.getAuthor());
        System.out.println(b.getIsbn());
        mediaRepository.createBook(b);
        return Response.status(Response.Status.OK).build();
    }

    /**
     *
     * @param obj das Objekt
     * @return Response
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
