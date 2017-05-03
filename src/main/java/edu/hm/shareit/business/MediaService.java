package edu.hm.shareit.business;

import edu.hm.shareit.model.Book;
import edu.hm.shareit.model.Disc;

/**
 * Interface for creating, updating and retrieving Medias.
 */
public interface MediaService {
    /**
     * Validates the book and adds it to the repository.
     * @param book the book to be validated
     * @return the result of the operation
     */
    ServiceStatus addBook(Book book);
    /**
     * Validates the disc and adds it to the repository.
     * @param disc the disc to be validated
     * @return the result of the operation
     */
    ServiceStatus addDisc(Disc disc);

    /**
     * Returns all the books in the repository.
     * @return Array of all books.
     */
    ServiceResult getBooks();

    /**
     * Returns all the discs in the repository.
     * @return Array of all discs.
     */
    ServiceResult getDiscs();

    /**
     * Returns a book with an specific isbn.
     * @param isbn the isbn of the book.
     * @return the book or null if not available.
     */
    ServiceResult getBook(String isbn);

    /**
     * Returns a disc with a specific barcode.
     * @param barcode the barcode of the disc.
     * @return the disc or null if not available.
     */
    ServiceResult getDisc(String barcode);

    /**
     * Looks up the book in the repository and updates it.
     * @param book the book with updated values.
     * @param isbn the isbn of an existing book in the repo.
     * @return the result of the operation.
     */
    ServiceStatus updateBook(Book book, String isbn);

    /**
     * Looks up the disc in the repository and updates it.
     * @param disc the disc with updated values.
     * @param barcode the barcode of an existing disc in the repo.
     * @return the result of the operation.
     */
    ServiceStatus updateDisc(Disc disc, String barcode);
}
