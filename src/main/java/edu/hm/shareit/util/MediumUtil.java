package edu.hm.shareit.util;

import edu.hm.shareit.model.Book;
import edu.hm.shareit.model.Disc;

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
    private static final int ISBN13_FORMAT_GROUP1_END = 3;
    private static final int ISBN13_FORMAT_GROUP2_END = 4;
    private static final int ISBN13_FORMAT_GROUP3_END = 9;
    private static final int ISBN13_FORMAT_GROUP4_END = 12;
    private static final int ISBN13_FORMAT_GROUP5_END = 13;

    private static final int ISBN10_FORMAT_GROUP1_END = 1;
    private static final int ISBN10_FORMAT_GROUP2_END = 6;
    private static final int ISBN10_FORMAT_GROUP3_END = 9;
    private static final int ISBN10_FORMAT_GROUP4_END = 10;

    private static final int ISBN13_LENGTH = 13;
    /**
     * Formats the ISBN.
     * @param isbn which should be formatted.
     * @return the formatted isbn
     */
    public static String formatISBN(String isbn) {
        isbn = isbn.replaceAll("-", "");
        if (isbn.length() == ISBN13_LENGTH) {
            return String.format("%s-%s-%s-%s-%s",
                    isbn.substring(0, ISBN13_FORMAT_GROUP1_END),
                    isbn.substring(ISBN13_FORMAT_GROUP1_END, ISBN13_FORMAT_GROUP2_END),
                    isbn.substring(ISBN13_FORMAT_GROUP2_END, ISBN13_FORMAT_GROUP3_END),
                    isbn.substring(ISBN13_FORMAT_GROUP3_END, ISBN13_FORMAT_GROUP4_END),
                    isbn.substring(ISBN13_FORMAT_GROUP4_END, ISBN13_FORMAT_GROUP5_END));
        } else {
            return String.format("%s-%s-%s-%s",
                    isbn.substring(0, ISBN10_FORMAT_GROUP1_END),
                    isbn.substring(ISBN10_FORMAT_GROUP1_END, ISBN10_FORMAT_GROUP2_END),
                    isbn.substring(ISBN10_FORMAT_GROUP2_END, ISBN10_FORMAT_GROUP3_END),
                    isbn.substring(ISBN10_FORMAT_GROUP3_END, ISBN10_FORMAT_GROUP4_END));
        }
    }

    /**
     * Checks if a book contains non null attributes.
     * @param book the book to be checked.
     * @return false, if one or more attributes are null.
     */
    public static boolean isValidBook(Book book) {
        return book.getTitle() != null && book.getAuthor() != null && book.getIsbn() != null;
    }

    /**
     * Checks if a disc contains non null attributes.
     * @param disc the disc to be checked.
     * @return false, if one ore more attributes are null.
     */
    public static boolean isValidDisc(Disc disc) {
        return disc.getTitle() != null && disc.getDirector() != null && disc.getBarcode() != null;
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
