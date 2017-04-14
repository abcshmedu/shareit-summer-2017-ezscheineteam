package edu.hm.shareit.resources;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import edu.hm.shareit.model.Book;
import edu.hm.shareit.repository.MediaRepository;
import edu.hm.shareit.repository.MediaRepositoryStub;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("media")
public class MediaResource {
    private MediaRepository mediaRepository = new MediaRepositoryStub();

    /**
     * Gibt das Buch zur passenden ISBN zurück.
     * @return Response mit Buchinformationen.
     */
    @GET
    @Path("books/{isbn}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllMedias(@PathParam("isbn") String isbn) {
        Book b = mediaRepository.findBook(isbn);
        if (b != null)
        {
            ObjectMapper mapper = new ObjectMapper();
            try {
                String result = mapper.writeValueAsString(b);
                return Response.status(Response.Status.OK).entity(result).build();
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
