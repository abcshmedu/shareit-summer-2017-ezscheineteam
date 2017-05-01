package edu.hm.shareit.repository;

import edu.hm.shareit.model.Book;
import edu.hm.shareit.model.Disc;

import java.util.List;

/**
 * The interface for the repository.
 */
public interface MediaRepository {
    /**
     * Return all books.
     * @return A list containing all books.
     */
    List<Book> findAllBooks();

    /**
     * Return all discs in the repository.
     * @return A list containing all discs.
     */
    List<Disc> findAllDiscs();

    /**
     * Searches for a book with the specified isbn.
     * @param isbn the isbn to look for.
     * @return the book, or null if not available.
     */
    Book findBook(String isbn);

    /**
     * Searches for a disk with the specified barcode in the repository.
     * @param barcode - Barcode of the disc to look for.
     * @return the Disc, or null if not found.
     */
    Disc findDisc(String barcode);

    /**
     * Creates a new book in the repository.
     * @param b - the new book.
     */
    void createBook(Book b);

    /**
     * Creates a disc in the repository.
     * @param disc - the new disc.
     * @return the created Disc.
     */
    void createDisc(Disc disc);

    /**
     * Updates an existing book in the repository.
     * @param book - book with updated information.
     * @return the updated book.
     */
    boolean updateBook(Book book, String isbn);


    /**
     * Updates an existing book in the repository.
     * @param disc - book with updated information.
     * @return the updated book.
     */
    void updateDisc(Disc disc);

}
