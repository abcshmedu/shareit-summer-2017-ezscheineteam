package edu.hm.shareit.util;

import edu.hm.shareit.model.Medium;
import org.junit.Test;

import static org.junit.Assert.*;

public class MediumUtilTest {
    @Test
    public void isValidISBN13WithLines() throws Exception {
        String isbn = "987-0-14026-690-0";
        assertTrue(MediumUtil.isValidISBN(isbn));
    }

    @Test
    public void isValidISBN13WithSpaces() throws Exception {
        String isbn = "123 4 56781 234 5";
        assertTrue(MediumUtil.isValidISBN(isbn));
    }

    @Test
    public void isValidISBN13WithoutSpaces() throws Exception {
        String isbn = "1234567891234";
        assertTrue(MediumUtil.isValidISBN(isbn));
    }

    @Test
    public void isValidISBN10WithoutSpaces() throws Exception {
        String isbn = "1234567891";
        assertTrue(MediumUtil.isValidISBN(isbn));
    }

    @Test
    public void isNotValidISBN13() throws Exception {
        String isbn = "123";
        assertFalse(MediumUtil.isValidISBN(isbn));
    }

    @Test
    public void isValidBarcode() throws Exception {
        String barcode = "56712346";
        assertTrue(MediumUtil.isValidBarcode(barcode));
    }

    @Test
    public void isNotValidBarcode() throws Exception {
        String barcode = "1234567";
        assertFalse(MediumUtil.isValidBarcode(barcode));
    }

}