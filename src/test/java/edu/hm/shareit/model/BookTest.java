package edu.hm.shareit.model;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;

import java.io.IOException;

public class BookTest {
    public final ExpectedException exception = ExpectedException.none();

    static String jsonInput = "{\"title\":\"Buch\", \"author\": \"Author\", \"isbn\": \"1234\"}";

    @Test
    public void serialize() throws JsonProcessingException {
        ObjectMapper m = new ObjectMapper();
        m.enableDefaultTyping();
        String toParse = "{\"title\":\"title\",\"author\":\"author\",\"isbn\":\"12314\"}";
        Book b = new Book("title", "author", "12314");
        String result = m.writeValueAsString(b);
        assertEquals(toParse, result);
    }

    @Test
    public void deserialize1() throws IOException {
        ObjectMapper m = new ObjectMapper();
        Book b = m.readValue(jsonInput, Book.class);
        assertNotEquals(null, b);
        assertEquals("Buch", b.getTitle());
        assertEquals("Author", b.getAuthor());
        assertEquals("1234", b.getIsbn());
    }

    @Test
    public void emptyBookEqualsNullTest() {
        Book b = new Book();
        assertFalse(b.equals(null));
    }

    @Test
    public void BookWithAllNullParams() {
        exception.expect(IllegalArgumentException.class);
        Book b = new Book(null, null, null);
    }

    @Test
    public void BookWithNullParamsEqualsTest() {
        Book bookAuthorNull = new Book("LENO PALENO", null, "1234567890123");
        Book bookISBNNull = new Book("LENO PALENO", "PETER", null);
        assertFalse(bookAuthorNull.equals(bookISBNNull));
        assertFalse(bookISBNNull.equals(bookAuthorNull));
    }

    @Test
    public void BooksWithDifferentParamsEqualsTest() {
        Book bookOne = new Book("LENO PALENO", "PETER", "1234567890123");
        Book bookTwo = new Book("LENO PALENO", "PETER", "1234567");
        assertFalse(bookOne.equals(bookTwo));
    }

    @Test
    public void BookWithNullParamsHashTest() {
        Book b = new Book("LENO PALENO", null, null);
        int expected = "LENO PALENO".hashCode() * 31 * 31;
        assertEquals(expected, b.hashCode());

        b = new Book("LENO PALENO", "author", null);
        expected = ("LENO PALENO".hashCode() * 31 + "author".hashCode()) * 31;
        assertEquals(expected, b.hashCode());

        b = new Book("LENO PALENO", null, "");
        expected = "LENO PALENO".hashCode() * 31 * 31 + "".hashCode();
        assertEquals(expected, b.hashCode());
    }
    
    @Test
    public void ToStringTest(){
        Book b = new Book("LENO PALENO", "PETER", "1234567890123");
        String expected = "{"
                + "title='" + "LENO PALENO" + '\''
                + ", author='" + "PETER" + '\''
                + ", isbn='" + "1234567890123" + '\''
                + '}';
        assertEquals(expected, b.toString());
    }

}