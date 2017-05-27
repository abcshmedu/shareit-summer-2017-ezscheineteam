package edu.hm.shareit.client;

import edu.hm.shareit.business.ServiceStatus;
import edu.hm.shareit.model.Book;
import edu.hm.shareit.model.Disc;
import org.junit.Test;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import static org.junit.Assert.assertEquals;

@SuppressWarnings({"JavadocType", "JavadocMethod"})
public class MediaClientTest {
    
    @Test
    public void testOnStartNoBooks() {
        MediaClient client = new MediaClient();
        Response response = client.getBooks();
        assertEquals(Status.OK.getStatusCode(), response.getStatus());
        String entity = response.readEntity(String.class);
        String expectedEntity = "[]";
        assertEquals(expectedEntity, entity);
    }
    
    @Test
    public void testOnStartNoDiscs() {
        MediaClient client = new MediaClient();
        Response response = client.getDiscs();
        assertEquals(Status.OK.getStatusCode(), response.getStatus());
        String entity = response.readEntity(String.class);
        String expectedEntity = "[]";
        assertEquals(expectedEntity, entity);
    }
    
    
    @Test
    public void testCreateBookNodash() {
        MediaClient client = new MediaClient();
        Book book = new Book("Harry Potter", "Rowling", "9783551354013");
        Response response = client.createBook(book);
        assertEquals(Status.OK.getStatusCode(), response.getStatus());
        String entity = response.readEntity(String.class);
        String expectedEntity = "{\"status\":200,\"detail\":\"Tutto bene.\"}";
        assertEquals(expectedEntity, entity);
    }
    
    @Test
    public void testCreateBookWithdash() {
        MediaClient client = new MediaClient();
        Book book = new Book("Harry Potter", "Rowling", "978-3551354013");
        Response response = client.createBook(book);
        assertEquals(Status.BAD_REQUEST.getStatusCode(), response.getStatus());
        String entity = response.readEntity(String.class);
        String expectedEntity = "{\"status\":400,\"detail\":\"Ein Buch mit dieser ISBN existiert bereits.\"}";
        assertEquals(expectedEntity, entity);
    }
    
    @Test
    public void testCreateBook() {
        MediaClient client = new MediaClient();
        Book book = new Book("TestBook", "AutoTestBook", "1234567892");
        Response r = client.createBook(book);
        String entity = r.readEntity(String.class);
        String asserted = "{\"status\":200,\"detail\":\"Tutto bene.\"}";
        assertEquals(asserted, entity);
    }

    
    @Test
    public void testCreateDisc() {
        MediaClient client = new MediaClient();
        Disc disc = new Disc("TestDisc", "56712345", 0, "TestAutor");
        Response r = client.createDisc(disc);
        String entity = r.readEntity(String.class);
        String asserted = "{\"status\":200,\"detail\":\"Tutto bene.\"}";
        assertEquals(asserted, entity);
    }

    
    @Test
    public void testPutBook() {
        MediaClient client = new MediaClient();
        Book book = new Book("New Book", "New Author", "1234567892");
        Response r = client.updateBook(book);
        String entity = r.readEntity(String.class);
        String asserted = "{\"status\":200,\"detail\":\"Tutto bene.\"}";
        assertEquals(asserted, entity);
    }

    
    @Test
    public void testPutDisc() {
        MediaClient client = new MediaClient();
        Disc disc = new Disc("New Title", "56712345", 0, "The Director");
        Response r = client.updateDisc(disc);
        String entity = r.readEntity(String.class);
        String asserted = "{\"status\":200,\"detail\":\"Tutto bene.\"}";
        assertEquals(asserted, entity);
    }

    
    @Test
    public void getBook() throws Exception {
        MediaClient client = new MediaClient();
        Response r = client.getBook("1234567892");
        assertEquals(ServiceStatus.OK.getStatus(), r.getStatus());
    }

    
    @Test
    public void getDisc() throws Exception {
        MediaClient client = new MediaClient();
        Response r = client.getDisc("56712345");
        assertEquals(ServiceStatus.OK.getStatus(), r.getStatus());
    }

    
    @Test
    public void testGetBookList() {
        MediaClient client = new MediaClient();
        Response r = client.getBooks();
        assertEquals(ServiceStatus.OK.getStatus(), r.getStatus());
    }

    
    @Test
    public void testGetDiscList() {
        MediaClient client = new MediaClient();
        Response r = client.getDiscs();
        assertEquals(ServiceStatus.OK.getStatus(), r.getStatus());
    }

    
    @Test
    public void testGetBookWithBadRequest() {
        MediaClient client = new MediaClient();
        Response r = client.getBook("123");
        assertEquals(ServiceStatus.ERROR_ISBN_FORMAT.getStatus(), r.getStatus());
    }

    
    @Test
    public void testGetBookWithBookNotFound() {
        MediaClient client = new MediaClient();
        Response r = client.getBook("2222244444");
        assertEquals(ServiceStatus.ERROR_BOOK_NOT_FOUND.getStatus(), r.getStatus());
    }
}