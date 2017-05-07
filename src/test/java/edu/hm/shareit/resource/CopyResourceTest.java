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
    public void getDiscCopyTest() {  
       CopyClient client = new CopyClient();
       Response response = client.getDiscCopy("HANZ", "123456789");
       assertEquals(Status.NOT_IMPLEMENTED.getStatusCode(), response.getStatus());
       String entity = response.readEntity(String.class);     
       String expectedEntity = "{\"status\":501,\"detail\":\"Service noch nicht implementiert\"}";
       assertEquals(expectedEntity, entity);   
    }
    
    @Test
    public void getBookCopyTest() {
        CopyClient client = new CopyClient();
        Response response = client.getBookCopy("HANZ", "123456789");
        assertEquals(Status.NOT_IMPLEMENTED.getStatusCode(), response.getStatus());
        String entity = response.readEntity(String.class);     
        String expectedEntity = "{\"status\":501,\"detail\":\"Service noch nicht implementiert\"}";
        assertEquals(expectedEntity, entity);
    }
    
    
    @Test
    public void getOwnerDiscCopiesTest() {
       CopyClient client = new CopyClient();
       Response response = client.getDiscCopies("HANZ");
       assertEquals(Status.NOT_FOUND.getStatusCode(), response.getStatus());       
    }
    
    @Test
    public void getOwnerBookCopiesTest() {
        CopyClient client = new CopyClient();
        Response response = client.getBookCopies("HANZ");
        assertEquals(Status.NOT_FOUND.getStatusCode(), response.getStatus());       
    }

    @Test
    public void getDiscCopiesTest() {
       CopyClient client = new CopyClient();
       Response response = client.getDiscCopies();
       assertEquals(Status.NOT_IMPLEMENTED.getStatusCode(), response.getStatus());
       String entity = response.readEntity(String.class);     
       String expectedEntity = "{\"status\":501,\"detail\":\"Service noch nicht implementiert\"}";
       assertEquals(expectedEntity, entity);       
    }
    
    @Test
    public void getBookCopiesTest() {
        CopyClient client = new CopyClient();
        Response response = client.getBookCopies();
        assertEquals(Status.NOT_IMPLEMENTED.getStatusCode(), response.getStatus());
        String entity = response.readEntity(String.class);     
        String expectedEntity = "{\"status\":501,\"detail\":\"Service noch nicht implementiert\"}";
        assertEquals(expectedEntity, entity);       
    }
    
    @Test
    public void getOwnerCopiesTest() {
        CopyClient client = new CopyClient();
        Response response = client.getOwnerCopies("HANZ");
        assertEquals(Status.NOT_IMPLEMENTED.getStatusCode(), response.getStatus());
        String entity = response.readEntity(String.class);     
        String expectedEntity = "{\"status\":501,\"detail\":\"Service noch nicht implementiert\"}";
        assertEquals(expectedEntity, entity);  
    }
    
    @Test
    public void getCopiesTest() {
        CopyClient client = new CopyClient();
        Response response = client.getCopies();
        assertEquals(Status.NOT_IMPLEMENTED.getStatusCode(), response.getStatus());
        String entity = response.readEntity(String.class);     
        String expectedEntity = "{\"status\":501,\"detail\":\"Service noch nicht implementiert\"}";
        assertEquals(expectedEntity, entity);  
    }
    
    @Test
    public void createCopyTest() {
       CopyClient client = new CopyClient();
       Response response = client.createCopy("{}");
       assertEquals(Status.NOT_IMPLEMENTED.getStatusCode(), response.getStatus());
       String entity = response.readEntity(String.class);     
       String expectedEntity = "{\"status\":501,\"detail\":\"Service noch nicht implementiert\"}";
       assertEquals(expectedEntity, entity);       
    }
    
    @Test
    public void updateDiscCopyTest() {
        CopyClient client = new CopyClient();
        Response response = client.updateDiscCopy("HANZ", "123456789", "{}");
        assertEquals(Status.NOT_IMPLEMENTED.getStatusCode(), response.getStatus());
        String entity = response.readEntity(String.class);     
        String expectedEntity = "{\"status\":501,\"detail\":\"Service noch nicht implementiert\"}";
        assertEquals(expectedEntity, entity);
    }
    
    @Test
    public void updateBookCopyTest() {
        CopyClient client = new CopyClient();
        Response response = client.updateBookCopy("HANZ", "123456789", "{}");
        assertEquals(Status.NOT_IMPLEMENTED.getStatusCode(), response.getStatus());
        String entity = response.readEntity(String.class);     
        String expectedEntity = "{\"status\":501,\"detail\":\"Service noch nicht implementiert\"}";
        assertEquals(expectedEntity, entity);         
    }
    
    @Test
    public void deleteDiscCopyTest() {
        CopyClient client = new CopyClient();
        Response response = client.deleteDiscCopy("HANZ", "123456789");
        assertEquals(Status.NOT_IMPLEMENTED.getStatusCode(), response.getStatus());
        String entity = response.readEntity(String.class);     
        String expectedEntity = "{\"status\":501,\"detail\":\"Service noch nicht implementiert\"}";
        assertEquals(expectedEntity, entity);    
    }
    
    @Test
    public void deleteBookCopyTest() {
        CopyClient client = new CopyClient();
        Response response = client.deleteBookCopy("HANZ", "123456789");
        assertEquals(Status.NOT_IMPLEMENTED.getStatusCode(), response.getStatus());
        String entity = response.readEntity(String.class);     
        String expectedEntity = "{\"status\":501,\"detail\":\"Service noch nicht implementiert\"}";
        assertEquals(expectedEntity, entity);          
    }
    
}
