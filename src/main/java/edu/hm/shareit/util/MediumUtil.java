package edu.hm.shareit.util;

import java.util.regex.Pattern;

/**
 * Helper class for validating Medias.
 */
public final class MediumUtil {

    /**
     * Can't be created.
     */
    private MediumUtil() {
    }

    /**
     * Checks if isbn is in a valid ISBN13 or ISBN10 Format.
     * 
     * @param isbn
     *            The isbn.
     * @return true if valid, else false.
     */
    public static boolean isValidISBN(String isbn) {
        if (isbn == null) {
            return false;
        }
        String regex = "^(\\d{3}[- ]?)?\\d[- ]?\\d{5}[- ]?\\d{3}[- ]?\\d$";
        Pattern p = Pattern.compile(regex);
        return p.matcher(isbn).matches();
    }

    /**
     * Checks if barcode is in a valid EAN8 or EAN13 Format.
     * 
     * @param barcode
     *            the barcode.
     * @return true if valid, else false.
     */
    public static boolean isValidBarcode(String barcode) {
        String regex = "^\\d{8}(\\d{5})?$";
        Pattern p = Pattern.compile(regex);
        return p.matcher(barcode).matches();
    }
}
