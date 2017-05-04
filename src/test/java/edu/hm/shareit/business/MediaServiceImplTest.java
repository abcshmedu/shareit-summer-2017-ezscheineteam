package edu.hm.shareit.business;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import edu.hm.shareit.model.Book;

public class MediaServiceImplTest {

    MediaServiceImpl msi;

    @Before
    public void setUp() {
        msi = new MediaServiceImpl();
    }

    @Test
    public void getDiscChecks() {
        assertEquals(ServiceStatus.ERROR_PARSING_JSON, msi.addBook(null));
        assertEquals(ServiceStatus.ERROR_ISBN_FORMAT, msi.addBook(new Book("title", "author", null)));
        assertEquals(ServiceStatus.ERROR_ISBN_FORMAT, msi.addBook(new Book("title", "author", "1234567")));
        assertEquals(ServiceStatus.OK, msi.addBook(new Book("title", "author", "0987654321")));
        assertEquals(ServiceStatus.ERROR_ISBN_ALREADY_EXIST, msi.addBook(new Book("title", "author", "0987654321")));
    }
}
