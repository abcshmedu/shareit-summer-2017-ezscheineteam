package edu.hm.shareit.repository;

import edu.hm.shareit.model.Book;
import edu.hm.shareit.model.Disc;
import edu.hm.shareit.model.Medium;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Just a mock class, as long as we don't have a real repository.
 */
public class MediaRepositoryStub implements MediaRepository {
    private List<Book> allBooks = new ArrayList<>();
    private List<Disc> allDiscs = new ArrayList<>();

    /**
     * Creates our example repository.
     */
    public MediaRepositoryStub() {
        allBooks.add(new Book("Die Eule mit der Beule", "Susanne Weber", "978-3789167065"));
        allBooks.add(new Book("Das Buch", "DerAutor", "12345"));
        allDiscs.add(new Disc("Never Gonna Give You Up", "123-124132", 0, "Rick Astley"));
        allDiscs.add(new Disc("Die CD", "123-123", 0, "Der Künstler"));
    }
    /**
     * Creates a new book in our repository.
     * @param b - The book to be inserted in our repository.
     */
    @Override
    public void createBook(Book b) {
        System.out.println(allBooks.size());
        allBooks.add(b);
        allBooks.forEach(System.out::println);
        System.out.println(allBooks.size());
    }

    /**
     * Looks for an available book and updates it accordingly.
     * If the book can't be found it is created.
     * @param book - The book to be updated.
     * @return updated book
     */
    @Override
    public Book update(Book book) {
        // search the database to see if we have a book with that isbn already
        // select * from Books where isbn = ?
        // if rs size == 0
        // insert into book table
        // else
        // update the Book
        return book;
    }


    /**
     * Return all Media.
     * @return A list containing all media.
     */
    @Override
    public List<Medium> findAllMedia() {
        List<Medium> media = new ArrayList<>();

        media.addAll(allBooks);
        media.addAll(allDiscs);

        return media;
    }

    /**
     * Returns all books.
     * @return A list containing all books.
     */
    @Override
    public List<Book> findAllBooks() {
        System.out.println(allBooks.size());
        allBooks.forEach(System.out::println);
        return allBooks;
    }

    /**
     * Looks for a book with a specific isbn.
     * @param isbn - the isbn to look for.
     * @return The book with the isbn or null if it can't be found.
     */
    @Override
    public Book findBook(String isbn) {
        Optional<Book> b = allBooks.stream().filter(book -> book.getIsbn().equals(isbn)).findFirst();
        return b.orElse(null);
    }

    /**
     * Looks for a disc with a specific barcode.
     * @param barcode - the barcode to look for.
     * @return The disc with the barcode or null if it can't be found.
     */
    @Override
    public Disc findDisc(String barcode) {
        Optional<Disc> d = allDiscs.stream().filter(disc -> disc.getBarcode().equals(barcode)).findFirst();
        return d.orElse(null);
    }

    /**
     * Returns all discs in the repository.
     * @return A list containing all discs.
     */
    @Override
    public List<Disc> findAllDiscs() {
        return allDiscs;
    }

    @Override
    public Disc createDisc(Disc disc) {
        return null;
    }
}
