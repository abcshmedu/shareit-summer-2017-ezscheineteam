package edu.hm.shareit.resource;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import javax.inject.Inject;

import edu.hm.shareit.business.CopyService;
import edu.hm.shareit.business.ServiceResult;
import edu.hm.shareit.business.ServiceStatus;
import edu.hm.shareit.model.Copy;

/**
 * REST-Endpoint für das Anlegen von Exemplaren.
 */
@Path("copy")
public class CopyResource {

    /**
     * Service zur Handhabung von Exemplaren.
     */
    private final CopyService copyService;

    /**
     * Erzeugt ein neues CopyResource Objekt.
     * @param copyService Copy Service welcher verwendet werden soll.
     */
    @Inject
    public CopyResource(CopyService copyService) {
        this.copyService = copyService;
    }
    
    /**
     * Legt ein neues Exemplar an.
     * @param copy Das Exemplar.
     * @return Response Objekt.
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createCopy(Copy copy) {
        ServiceStatus result = copyService.addCopy(copy);
        return Response.status(result.getStatus()).entity(result).build();
    }
    
    
    /**
     * Aktualisiert ein vorhandenes Buch Exemplar.
     * @param copy Das Exemplar mit aktualisierten Daten.
     * @param owner Name des Besitzers dessen Buch Exemplar.
     * @param isbn Die ISBN des Buches.
     * @return Response Objekt.
     */
    @PUT
    @Path("{owner}/books/{isbn}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateBookCopy(Copy copy, @PathParam("owner")String owner, @PathParam("isbn")String isbn) {
        ServiceStatus result = copyService.updateBookCopy(copy, owner, isbn);
        return Response.status(result.getStatus()).entity(result).build();
    }

    
    /**
     * Aktualisiert ein vorhandenes Disc Exemplar.
     * @param copy Das Exemplar mit aktualisierten Daten.
     * @param owner Name des Besitzers dessen Disc Exemplar.
     * @param barcode Der Barcode der Disc.
     * @return Response Objekt.
     */
    @PUT
    @Path("{owner}/discs/{barcode}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateDiscCopy(Copy copy, @PathParam("owner")String owner, @PathParam("barcode")String barcode) {
        ServiceStatus result = copyService.updateDiscCopy(copy, owner, barcode);
        return Response.status(result.getStatus()).entity(result).build();
    }
    
    /**
     * Löscht ein vorhandenes Buch Exemplar.
     * @param owner Name des Besitzers dessen Buch Exemplar.
     * @param isbn Die ISBN des Buches.
     * @return Response Objekt.
     */
    @DELETE
    @Path("{owner}/books/{isbn}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteBookCopy(@PathParam("owner")String owner, @PathParam("isbn")String isbn) {
        ServiceStatus result = copyService.deleteBookCopy(owner, isbn);
        return Response.status(result.getStatus()).entity(result).build();
    }

    /**
     * Löscht ein vorhandenes Disc Exemplar.
     * @param owner Name des Besitzers dessen Disc Exemplar.
     * @param barcode Der Barcode der Disc.
     * @return Response Objekt.
     */
    @DELETE
    @Path("{owner}/discs/{barcode}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteDiscCopy(@PathParam("owner")String owner, @PathParam("barcode")String barcode) {
        ServiceStatus result = copyService.deleteDiscCopy(owner, barcode);
        return Response.status(result.getStatus()).entity(result).build();
    }

    /**
     * Liefert alle Exemplare.
     * @return Response Objekt.
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCopies() {
        ServiceResult result = copyService.getCopies();
        ServiceStatus status = result.getStatus();
        return Response.status(status.getStatus())
                .entity(result.containsResult() ? result.getResult() : status)
                .build();
    }
    
    /**
     * Liefert ein vorhandenes Buch Exemplar.
     * @param owner Name des Besitzers dessen Buch Exemplar.
     * @param isbn Die ISBN des Buches.
     * @return Response Objekt.
     */
    @GET
    @Path("{owner}/books/{isbn}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getBookCopy(@PathParam("owner")String owner, @PathParam("isbn")String isbn) {
        ServiceResult result = copyService.getBookCopy(owner, isbn);
        ServiceStatus status = result.getStatus();
        return Response.status(status.getStatus())
                .entity(result.containsResult() ? result.getResult() : status)
                .build();
    }

    /**
     * Liefert ein vorhandenes Disc Exemplar.
     * @param owner Name des Besitzers dessen Disc Exemplar.
     * @param barcode Der Barcode der Disc.
     * @return Response Objekt.
     */
    @GET
    @Path("{owner}/discs/{barcode}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getDiscCopy(@PathParam("owner")String owner, @PathParam("barcode")String barcode) {
        ServiceResult result = copyService.getDiscCopy(owner, barcode);
        ServiceStatus status = result.getStatus();
        return Response.status(status.getStatus())
                .entity(result.containsResult() ? result.getResult() : status)
                .build();
    }
    

    /**
     * Liefert alle Buch Exemplare.
     * @return Response Objekt.
     */
    @GET
    @Path("books")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getBookCopies() {
        ServiceResult result = copyService.getBookCopies();
        ServiceStatus status = result.getStatus();
        return Response.status(status.getStatus())
                .entity(result.containsResult() ? result.getResult() : status)
                .build();
    }

    /**
     * Liefert alle Disc Exemplare.
     * @return Response Objekt.
     */
    @GET
    @Path("discs")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getDiscCopies() {
        ServiceResult result = copyService.getDiscCopies();
        ServiceStatus status = result.getStatus();
        return Response.status(status.getStatus())
                .entity(result.containsResult() ? result.getResult() : status)
                .build();
    }
    
    /**
     * Liefert alle Exemplare eines bestimmten Besitzers.
     * @param owner Name des Besitzers.
     * @return Response Objekt.
     */
    @GET
    @Path("{owner}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getOwnerCopies(@PathParam("owner")String owner) {
        ServiceResult result = copyService.getOwnerCopies(owner);
        ServiceStatus status = result.getStatus();
        return Response.status(status.getStatus())
                .entity(result.containsResult() ? result.getResult() : status)
                .build();
    }


}
