package edu.hm.shareit.client;

import edu.hm.shareit.model.Book;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class MediaClientTest {
    @Test
    public void get() throws Exception {
        MediaClient client = new MediaClient();

        Book book = client.get("12345");

        assertNotNull(book);
    }

    @Test
    public void testGetList() {
        MediaClient client = new MediaClient();
        List<Book> books = client.get();
        System.out.println(books);
        assertNotNull(books);
    }
}