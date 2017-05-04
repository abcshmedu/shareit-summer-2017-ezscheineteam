package edu.hm.shareit.model;

import static org.junit.Assert.*;

import org.junit.Test;

public class DiscTest {
    @Test
    public void toStringTest() {
        String expected = "Disc{" + "barcode='" + "1234567890123" + '\'' + ", director='" + "HANS" + '\'' + ", fsk="
                + 18 + '}';
        Disc d = new Disc("", "1234567890123", 18, "HANS");
        assertEquals(expected, d.toString());
        
        d = new Disc("", "1234567890123", 15, "HANS");
        assertNotEquals(expected, d.toString());
    }
    
    @Test
    public void DiscParamsHashTest() {
        Disc disc = new Disc("Title",null,0,null);
        int expected = "Title".hashCode() * 31 * 31 * 31;
        assertEquals(expected, disc.hashCode());
        
        disc = new Disc("Title","123",0,null);
        expected = ("Title".hashCode() * 31 + "123".hashCode()) * 31 * 31;
        assertEquals(expected, disc.hashCode());
        
        disc = new Disc("Title","123",0,"HANS");
        expected = (("Title".hashCode() * 31 + "123".hashCode()) * 31  + "HANS".hashCode())* 31;
        assertEquals(expected, disc.hashCode());
    }
    
    @Test
    public void gettersTest(){
        Disc disc = new Disc("Title","123",18,"HANS");
        String expectedDirector = "HANS";
        int expectedFSK = 18;
        String expectedBarcode = "123";
        assertEquals(expectedBarcode, disc.getBarcode());
        assertEquals(expectedDirector, disc.getDirector());
        assertEquals(expectedFSK, disc.getFsk());
    }
    
    @Test
    public void DiscEqualsTest(){
        Disc dOne = new Disc("", "1234567890123", 15, "HANS");
        Disc dTwo = new Disc("", "1234567890123", 15, "HANS");
        assertTrue(dOne.equals(dTwo));
        dTwo = new Disc("", "1234567890123", 15, "PETER");
        assertFalse(dOne.equals(dTwo));
        assertFalse(dOne.equals(null));
        dTwo = new Disc("TITLE", "1234567890123", 15, "HANS");
        assertFalse(dOne.equals(dTwo));
        Book b = new Book();
        assertFalse(dOne.equals(b));
        dTwo = new Disc("", "1234567890123", 13, "HANS");
        assertFalse(dOne.equals(dTwo));
        dOne = new Disc("", null, 15, "HANS");
        dTwo = new Disc("", "1234567890123", 13, "HANS");
        assertFalse(dOne.equals(dTwo));
        assertFalse(dTwo.equals(dOne));
        dOne = new Disc("", "1234567890123", 13, "HANS");
        dTwo = new Disc("", "1234567890123123", 13, "HANS");
        assertFalse(dTwo.equals(dOne));
    }
}
