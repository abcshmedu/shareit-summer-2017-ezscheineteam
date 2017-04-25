package edu.hm.shareit.resource;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import edu.hm.shareit.model.Book;
import edu.hm.shareit.model.Disc;

@Path("copy")
public class CopyResource {

    

   @POST
   @Path("books/{user}")
   @Consumes(MediaType.APPLICATION_JSON)
   public Response createBook(Book b, @PathParam("user")String user) {
       System.out.println("Benutzername: " + user);
       System.out.println(b.getIsbn());
       
       return Response.ok().build();
   }
   
   
   @POST
   @Path("discs/{user}")
   @Consumes(MediaType.APPLICATION_JSON)
   public Response createDisc(Disc d, @PathParam("user")String user) {
       System.out.println("Benutzername: " + user);
       System.out.println(d.getBarcode());
      
       
       return Response.ok().build();
   }
   
}
