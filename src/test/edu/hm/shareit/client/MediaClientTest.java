package edu.hm.shareit.client;

import edu.hm.shareit.model.Book;
import edu.hm.shareit.model.Disc;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class MediaClientTest {
    @Test
    public void testCreate() {
        MediaClient client = new MediaClient();
        Book book = new Book();
        book = client.create(book);
        assertNotNull(book);
    }

    @Test
    public void testPut() {
        MediaClient client = new MediaClient();
        Book book = new Book("New Book", "New Author", "12345");
        book = client.update(book);
        assertNotNull(book);
    }

    @Test
    public void getBook() throws Exception {
        MediaClient client = new MediaClient();
        Book book = client.getBooks("12345");
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
    public void testGetWithBadRequest() {
        MediaClient client = new MediaClient();
        client.getBooks("123");
    }
}