package edu.hm.shareit.model;

import static org.junit.Assert.*;

import org.junit.Test;

@SuppressWarnings("JavadocType")
public class DiscTest {

    private final int mult31 = 31;
    private final int expectedFSK15 = 15;
    private final int expectedFSK13 = 13;
    private final int expectedFSK18 = 18;
    
    @Test
    @SuppressWarnings("JavadocMethod")
    public void toStringTest() {
        String expected = "Disc{" + "barcode='" + "1234567890123" + '\'' + ", director='" + "HANS" + '\'' + ", fsk="
                + expectedFSK18 + '}';
        Disc d = new Disc("", "1234567890123", expectedFSK18, "HANS");
        assertEquals(expected, d.toString());

        d = new Disc("", "1234567890123", expectedFSK15, "HANS");
        assertNotEquals(expected, d.toString());
    }

    @SuppressWarnings("JavadocMethod")
    @Test
    public void discParamsHashTest() {
        Disc disc = new Disc("Title", null, 0, null);
        int expected = "Title".hashCode() * mult31 * mult31 * mult31;
        assertEquals(expected, disc.hashCode());

        disc = new Disc("Title", "123", 0, null);
        expected = ("Title".hashCode() * mult31 + "123".hashCode()) * mult31 * mult31;
        assertEquals(expected, disc.hashCode());

        disc = new Disc("Title", "123", 0, "HANS");
        expected = (("Title".hashCode() * mult31 + "123".hashCode()) * mult31 + "HANS".hashCode()) * mult31;
        assertEquals(expected, disc.hashCode());
    }

    @SuppressWarnings("JavadocMethod")
    @Test
    public void gettersTest() {
        final int expectedFSK = 18;
        Disc disc = new Disc("Title", "123", expectedFSK, "HANS");
        String expectedDirector = "HANS";
        String expectedBarcode = "123";
        assertEquals(expectedBarcode, disc.getBarcode());
        assertEquals(expectedDirector, disc.getDirector());
        assertEquals(expectedFSK, disc.getFsk());
    }

    @SuppressWarnings("JavadocMethod")
    @Test
    public void discEqualsTest() {
        Disc dOne = new Disc("", "1234567890123", expectedFSK15, "HANS");
        Disc dTwo = new Disc("", "1234567890123", expectedFSK15, "HANS");
        assertTrue(dOne.equals(dTwo));
        dTwo = new Disc("", "1234567890123", expectedFSK15, "PETER");
        assertFalse(dOne.equals(dTwo));
        assertFalse(dOne.equals(null));
        dTwo = new Disc("TITLE", "1234567890123", expectedFSK15, "HANS");
        assertFalse(dOne.equals(dTwo));
        Book b = new Book();
        assertFalse(dOne.equals(b));
        dTwo = new Disc("", "1234567890123", expectedFSK13, "HANS");
        assertFalse(dOne.equals(dTwo));
        dOne = new Disc("", null, expectedFSK15, "HANS");
        dTwo = new Disc("", "1234567890123", expectedFSK13, "HANS");
        assertFalse(dOne.equals(dTwo));
        assertFalse(dTwo.equals(dOne));
        dOne = new Disc("", "1234567890123", expectedFSK13, "HANS");
        dTwo = new Disc("", "1234567890123123", expectedFSK13, "HANS");
        assertFalse(dTwo.equals(dOne));
    }
}
