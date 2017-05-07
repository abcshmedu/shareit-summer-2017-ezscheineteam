package edu.hm.shareit.client;

import edu.hm.shareit.business.ServiceStatus;
import edu.hm.shareit.model.Book;
import edu.hm.shareit.model.Disc;
import org.junit.Test;

import javax.ws.rs.core.Response;

import static org.junit.Assert.assertEquals;

@SuppressWarnings("JavadocType")
public class MediaClientTest {
    @SuppressWarnings("JavadocMethod")
    @Test
    public void testCreateBook() {
        MediaClient client = new MediaClient();
        Book book = new Book("TestBook", "AutoTestBook", "1234567892");
        Response r = client.createBook(book);
        String entity = r.readEntity(String.class);
        String asserted = "{\"status\":200,\"detail\":\"Tutto bene.\"}";
        assertEquals(asserted, entity);
    }

    @SuppressWarnings("JavadocMethod")
    @Test
    public void testCreateDisc() {
        MediaClient client = new MediaClient();
        Disc disc = new Disc("TestDisc", "56712345", 0, "TestAutor");
        Response r = client.createDisc(disc);
        String entity = r.readEntity(String.class);
        String asserted = "{\"status\":200,\"detail\":\"Tutto bene.\"}";
        assertEquals(asserted, entity);
    }

    @SuppressWarnings("JavadocMethod")
    @Test
    public void testPutBook() {
        MediaClient client = new MediaClient();
        Book book = new Book("New Book", "New Author", "1234567890");
        Response r = client.updateBook(book);
        String entity = r.readEntity(String.class);
        String asserted = "{\"status\":200,\"detail\":\"Tutto bene.\"}";
        assertEquals(asserted, entity);
    }

    @SuppressWarnings("JavadocMethod")
    @Test
    public void testPutDisc() {
        MediaClient client = new MediaClient();
        Disc disc = new Disc("New Title", "12345678", 0, "The Director");
        Response r = client.updateDisc(disc);
        String entity = r.readEntity(String.class);
        String asserted = "{\"status\":200,\"detail\":\"Tutto bene.\"}";
        assertEquals(asserted, entity);
    }

    @SuppressWarnings("JavadocMethod")
    @Test
    public void getBook() throws Exception {
        MediaClient client = new MediaClient();
        Response r = client.getBook("1234567890");
        assertEquals(ServiceStatus.OK.getStatus(), r.getStatus());
    }

    @SuppressWarnings("JavadocMethod")
    @Test
    public void getDisc() throws Exception {
        MediaClient client = new MediaClient();
        Response r = client.getDisc("12345678");
        assertEquals(ServiceStatus.OK.getStatus(), r.getStatus());
    }

    @SuppressWarnings("JavadocMethod")
    @Test
    public void testGetBookList() {
        MediaClient client = new MediaClient();
        Response r = client.getBooks();
        assertEquals(ServiceStatus.OK.getStatus(), r.getStatus());
    }

    @SuppressWarnings("JavadocMethod")
    @Test
    public void testGetDiscList() {
        MediaClient client = new MediaClient();
        Response r = client.getDiscs();
        assertEquals(ServiceStatus.OK.getStatus(), r.getStatus());
    }

    @SuppressWarnings("JavadocMethod")
    @Test
    public void testGetBookWithBadRequest() {
        MediaClient client = new MediaClient();
        Response r = client.getBook("123");
        assertEquals(ServiceStatus.ERROR_ISBN_FORMAT.getStatus(), r.getStatus());
    }

    @SuppressWarnings("JavadocMethod")
    @Test
    public void testGetBookWithBookNotFound() {
        MediaClient client = new MediaClient();
        Response r = client.getBook("2222244444");
        assertEquals(ServiceStatus.ERROR_BOOK_NOT_FOUND.getStatus(), r.getStatus());
    }
}