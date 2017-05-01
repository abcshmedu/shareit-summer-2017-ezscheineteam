package edu.hm.shareit.resource;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import edu.hm.shareit.business.CopyService;
import edu.hm.shareit.business.CopyServiceImplStub;
import edu.hm.shareit.business.ServiceResult;
import edu.hm.shareit.business.ServiceStatus;
import edu.hm.shareit.model.Book;
import edu.hm.shareit.model.Copy;
import edu.hm.shareit.model.Disc;

/**
 * REST-Endpoint f�r das Anlegen von Exemplaren.
 */
@Path("copy")
public class CopyResource {

    /**
     * Service zur Handhabung von Exemplaren.
     */
    private final CopyService copyService = new CopyServiceImplStub();

    /**
     * Legt ein neues Exemplar Buch an.
     * @param book Das Exemplar Buch
     * @param user Das Konto welchem das Exemplar angelegt werden soll.
     * @return Response Objekt
     */
    @POST
    @Path("{user}/books")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createBook(Book book, @PathParam("user")String user) {
        Copy copy = new Copy(user, book);
        ServiceStatus result = copyService.addBook(copy);
        return Response.status(result.getStatus()).entity(result).build();
    }

    /**
     * Legt ein neues Exemplar Disc an.
     * @param disc Das Exemplar Disc
     * @param user Das Konto welchem das Exemplar angelegt werden soll.
     * @return Response Objekt 
     */
    @POST
    @Path("{user}/discs")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createDisc(Disc disc, @PathParam("user")String user) {
        Copy copy = new Copy(user, disc);
        ServiceStatus result = copyService.addDisc(copy);
        return Response.status(result.getStatus()).entity(result).build();
    }

    /**
     * Liefert alle Exemplare Buch die dem Konto angelegt wurden.
     * @param user Der Benutzername des Kontos.
     * @return response Objekt
     */
    @GET
    @Path("{user}/books")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getBooks(@PathParam("user")String user) {
        ServiceResult result = copyService.getBooks(user);
        ServiceStatus status = result.getStatus();
        return Response.status(status.getStatus())
                .entity(result.containsResult() ? result.getResult() : status)
                .build();
    }

    /**
     * Liefert alle Exemplare Disc die dem Konto angelegt wurden.
     * @param user Der Benutzername des Kontos.
     * @return response Objekt
     */
    @GET
    @Path("{user}/discs")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getDiscs(@PathParam("user")String user) {
        ServiceResult result = copyService.getDiscs(user);
        ServiceStatus status = result.getStatus();
        return Response.status(status.getStatus())
                .entity(result.containsResult() ? result.getResult() : status)
                .build();
    }


}
