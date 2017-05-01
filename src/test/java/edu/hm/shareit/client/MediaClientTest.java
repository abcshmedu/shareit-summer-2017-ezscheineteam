package java.edu.hm.shareit.client;

import edu.hm.shareit.business.ServiceStatus;
import edu.hm.shareit.client.MediaClient;
import edu.hm.shareit.model.Book;
import edu.hm.shareit.model.Disc;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertNotNull;

public class MediaClientTest {
    @Test
    public void testCreateBook() {
        MediaClient client = new MediaClient();
        Book book = new Book("TestBook", "AutoTestBook", "1234567891");
        ServiceStatus s = client.createBook(book);
        assertNotNull(s);
    }

    @Test
    public void testPutBook() {
        MediaClient client = new MediaClient();
        Book book = new Book("New Book", "New Author", "1234567890");
        ServiceStatus s = client.updateBook(book);
        assertNotNull(s);
    }

    @Test
    public void getBook() throws Exception {
        MediaClient client = new MediaClient();
        Book book = client.getBook("1234567890");
        assertNotNull(book);
    }

    @Test
    public void getDisc() throws Exception {
        MediaClient client = new MediaClient();
        Disc disc = client.getDisc("123-123");
        assertNotNull(disc);
    }

    @Test
    public void testGetBookList() {
        MediaClient client = new MediaClient();
        List<Book> books = client.getBooks();
        System.out.println(books);
        assertNotNull(books);
    }

    @Test
    public void testGetDiscList() {
        MediaClient client = new MediaClient();
        List<Disc> discs = client.getDiscs();
        System.out.println(discs);
        assertNotNull(discs);
    }

    @Test(expected = RuntimeException.class)
    public void testGetBookWithBadRequest() {
        MediaClient client = new MediaClient();
        client.getBook("123");
    }

    @Test(expected = RuntimeException.class)
    public void testGetBookWithBookNotFound() {
        MediaClient client = new MediaClient();
        client.getBook("12345678987654321");
    }
}