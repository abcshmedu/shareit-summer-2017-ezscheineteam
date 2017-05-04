package edu.hm.shareit.business;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import edu.hm.shareit.model.Book;
import edu.hm.shareit.model.Disc;

public class MediaServiceImplTest {

    MediaServiceImpl msi;

    @Before
    public void setUp() {
        msi = new MediaServiceImpl();
    }

    @Test
    public void addBookTest() {
        assertEquals(ServiceStatus.ERROR_PARSING_JSON, msi.addBook(null));
        assertEquals(ServiceStatus.ERROR_ISBN_FORMAT, msi.addBook(new Book("title", "author", null)));
        assertEquals(ServiceStatus.ERROR_ISBN_FORMAT, msi.addBook(new Book("title", "author", "1234567")));
        assertEquals(ServiceStatus.OK, msi.addBook(new Book("title", "author", "0987654321")));
        assertEquals(ServiceStatus.ERROR_ISBN_ALREADY_EXIST, msi.addBook(new Book("title", "author", "0987654321")));
    }

    @Test
    public void getDiscTest() {
        Disc testDisc = new Disc("Never Gonna Give You Up", "wrongBARCODE", 0, "Rick Astley");
        assertEquals(ServiceStatus.ERROR_BARCODE_FORMAT, msi.getDisc((testDisc.getBarcode())).getStatus());
        testDisc = new Disc("Never Gonna Give You Up", "87654312", 0, "Rick Astley");
        assertEquals(ServiceStatus.ERROR_DISC_NOT_FOUND, msi.getDisc((testDisc.getBarcode())).getStatus());
        testDisc = new Disc("Never Gonna Give You Up", "12345678", 0, "Rick Astley");
        assertEquals(ServiceStatus.OK, msi.getDisc((testDisc.getBarcode())).getStatus());
    }

    @Test
    public void addDiscTest() {
        assertEquals(ServiceStatus.ERROR_DISC_NOT_FOUND, msi.addDisc(null));
        assertEquals(ServiceStatus.ERROR_BARCODE_FORMAT,
                msi.addDisc(new Disc("Title", "wrongBarcode", 0, "Thomas Edison")));
        assertEquals(ServiceStatus.OK, msi.addDisc(new Disc("Title", "12345687", 0, "Thomas Edison")));
        assertEquals(ServiceStatus.ERROR_BARCODE_ALREADY_EXIST,
                msi.addDisc(new Disc("Title", "12345687", 0, "Thomas Edison")));
    }

    @Test
    public void updateBookTest() {
        assertEquals(ServiceStatus.ERROR_PARSING_JSON, msi.updateBook(null, null));
        assertEquals(ServiceStatus.ERROR_PARSING_JSON, msi.updateBook(null, "123"));
        assertEquals(ServiceStatus.ERROR_BOOK_NOT_FOUND,
                msi.updateBook(new Book("Title", "Author", "1234567890123"), null));
        assertEquals(ServiceStatus.ERROR_ISBN_FORMAT, msi.updateBook(new Book("Title", "Author", "wrongISBN"), null));

    }
}
