package edu.hm.shareit.util;

import edu.hm.shareit.model.Disc;

import java.util.regex.Pattern;

public class MediumUtil {
    public static boolean isValidISBN(String isbn) {
        String regex = "^(\\d{3}[- ]?)?\\d[- ]?\\d{5}[- ]?\\d{3}[- ]?\\d$";
        Pattern p = Pattern.compile(regex);
        return p.matcher(isbn).matches();
    }

    public static boolean isValidBarcode(Disc d) {
        String barcode = d.getBarcode();
        return barcode.length() > 4;
    }
}
