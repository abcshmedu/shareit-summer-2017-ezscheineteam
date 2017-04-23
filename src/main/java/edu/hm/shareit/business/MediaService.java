package edu.hm.shareit.business;

import edu.hm.shareit.model.Book;
import edu.hm.shareit.model.Disc;
import edu.hm.shareit.model.Medium;

/**
 *
 */
public interface MediaService {
    /**
     * Validates the book and adds it to the repository.
     * @param book the book to be validated
     * @return the result of the operation
     */
    MediaServiceResult addBook(Book book);
    /**
     * Validates the disc and adds it to the repository.
     * @param disc the disc to be validated
     * @return the result of the operation
     */
    MediaServiceResult addDisc(Disc disc);

    /**
     * Returns all the books in the repository.
     * @return Array of all books.
     */
    Medium[] getBooks();

    /**
     * Returns all the discs in the repository.
     * @return Array of all discs.
     */
    Medium[] getDiscs();

    /**
     * Returns a book with an specific isbn.
     * @param isbn the isbn of the book.
     * @return the book or null if not available.
     */
    Medium getBook(String isbn);

    /**
     * Returns a disc with a specific barcode.
     * @param barcode the barcode of the disc.
     * @return the disc or null if not available.
     */
    Medium getDisc(String barcode);

    /**
     * Looks up the book in the repository and updates it.
     * @param book the book to be updated.
     * @return the result of the operation.
     */
    MediaServiceResult updateBook(Book book);

    /**
     * Looks up the disc in the repository and updates it.
     * @param disc the disc to be updated.
     * @return the result of the operation.
     */
    MediaServiceResult updateDisc(Disc disc);
}
