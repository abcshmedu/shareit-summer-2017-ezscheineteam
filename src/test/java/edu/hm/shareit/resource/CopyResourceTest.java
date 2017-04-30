package edu.hm.shareit.resource;

import static org.junit.Assert.assertEquals;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.junit.Test;

import edu.hm.shareit.client.CopyClient;

/**
 * JUnit Testklasse fuer CopyResource.
 */
@SuppressWarnings("JavadocMethod")
public class CopyResourceTest {
    
    @Test
    public void getDiscTest() {  
       CopyClient client = new CopyClient();
       Response response = client.getDisc("HANZ", "123456789");
       assertEquals(Status.NOT_FOUND.getStatusCode(), response.getStatus());     
    }
    
    @Test
    public void getBookTest() {
        CopyClient client = new CopyClient();
        Response response = client.getBook("HANZ", "123456789");
        assertEquals(Status.NOT_FOUND.getStatusCode(), response.getStatus());
    }
    
    
    @Test
    public void getDiscsTest() {
       CopyClient client = new CopyClient();
       Response response = client.getDiscs("HANZ");
       assertEquals(Status.NOT_IMPLEMENTED.getStatusCode(), response.getStatus());
       String entity = response.readEntity(String.class);     
       String expectedEntity = "{\"status\":501,\"detail\":\"Service noch nicht implementiert\"}";
       assertEquals(expectedEntity, entity);       
    }
    
    @Test
    public void getBooksTest() {
        CopyClient client = new CopyClient();
        Response response = client.getBooks("HANZ");
        assertEquals(Status.NOT_IMPLEMENTED.getStatusCode(), response.getStatus());
        String entity = response.readEntity(String.class);     
        String expectedEntity = "{\"status\":501,\"detail\":\"Service noch nicht implementiert\"}";
        assertEquals(expectedEntity, entity);       
    }

    @Test
    public void createDiscTest() {
       CopyClient client = new CopyClient();
       Response response = client.createDisc("HANZ", "{}");
       assertEquals(Status.NOT_IMPLEMENTED.getStatusCode(), response.getStatus());
       String entity = response.readEntity(String.class);     
       String expectedEntity = "{\"status\":501,\"detail\":\"Service noch nicht implementiert\"}";
       assertEquals(expectedEntity, entity);       
    }
    
    @Test
    public void createBookTest() {
        CopyClient client = new CopyClient();
        Response response = client.createBook("HANZ", "{}");
        assertEquals(Status.NOT_IMPLEMENTED.getStatusCode(), response.getStatus());
        String entity = response.readEntity(String.class);     
        String expectedEntity = "{\"status\":501,\"detail\":\"Service noch nicht implementiert\"}";
        assertEquals(expectedEntity, entity);       
    }
    
    @Test
    public void updateDiscTest() {
        CopyClient client = new CopyClient();
        Response response = client.updateDisc("HANZ", "123456789", "{}");
        assertEquals(Status.NOT_FOUND.getStatusCode(), response.getStatus());      
    }
    
    @Test
    public void updateBookTest() {
        CopyClient client = new CopyClient();
        Response response = client.updateBook("HANZ", "123456789", "{}");
        assertEquals(Status.NOT_FOUND.getStatusCode(), response.getStatus());             
    }
    
    @Test
    public void deleteDiscTest() {
        CopyClient client = new CopyClient();
        Response response = client.deleteDisc("HANZ", "123456789");
        assertEquals(Status.NOT_FOUND.getStatusCode(), response.getStatus());      
    }
    
    @Test
    public void deleteBookTest() {
        CopyClient client = new CopyClient();
        Response response = client.deleteBook("HANZ", "123456789");
        assertEquals(Status.NOT_FOUND.getStatusCode(), response.getStatus());             
    }
    
}
