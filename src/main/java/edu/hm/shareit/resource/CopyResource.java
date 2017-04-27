package edu.hm.shareit.resource;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import edu.hm.shareit.business.CopyService;
import edu.hm.shareit.business.CopyServiceImplStub;
import edu.hm.shareit.business.CopyServiceResult;
import edu.hm.shareit.model.Book;
import edu.hm.shareit.model.Disc;
import edu.hm.shareit.model.Medium;

@Path("copy")
public class CopyResource {
    private CopyService copyService = new CopyServiceImplStub();
    

   @POST
   @Path("{user}/books")
   @Consumes(MediaType.APPLICATION_JSON)
   public Response createBook(Book b, @PathParam("user")String user) {
       CopyServiceResult result = copyService.addBook(b, user);
       return Response.status(result.getStatus()).entity(toJson(result)).build();
   }
   
   
   @POST
   @Path("{user}/discs")
   @Consumes(MediaType.APPLICATION_JSON)
   public Response createDisc(Disc d, @PathParam("user")String user) {
       CopyServiceResult result = copyService.addDisc(d, user);
       return Response.status(result.getStatus()).entity(toJson(result)).build();
   }
   
  @GET
  @Path("{user}/books")
  @Produces(MediaType.APPLICATION_JSON)
  public Response getBooks(@PathParam("user")String user) {
      Medium[] medias = copyService.getBooks(user);
      return Response.ok()
              .entity(toJson(medias))
              .build();
  }

  @GET
  @Path("{user}/discs")
  @Produces(MediaType.APPLICATION_JSON)
  public Response getDiscs(@PathParam("user")String user) {
      Medium[] medias = copyService.getDiscs(user);
      return Response.ok()
              .entity(toJson(medias))
              .build();
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
