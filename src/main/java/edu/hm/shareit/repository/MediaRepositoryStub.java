package edu.hm.shareit.repository;

import edu.hm.shareit.model.Book;
import edu.hm.shareit.model.Disc;

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

    @Override
    public void createBook(Book b) {
        System.out.println(allBooks.size());
        allBooks.add(b);
        allBooks.forEach(System.out::println);
        System.out.println(allBooks.size());
    }

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

    @Override
    public List<Book> findAllBooks() {
        System.out.println(allBooks.size());
        allBooks.forEach(System.out::println);
        return allBooks;
    }

    @Override
    public Book findBook(String isbn) {
        Optional<Book> b = allBooks.stream().filter(book -> book.getIsbn().equals(isbn)).findFirst();
        return b.orElse(null);
    }

    @Override
    public Disc findDisc(String barcode) {
        Optional<Disc> d = allDiscs.stream().filter(disc -> disc.getBarcode().equals(barcode)).findFirst();
        return d.orElse(null);
    }

    @Override
    public List<Disc> findAllDiscs() {
        return allDiscs;
    }

    @Override
    public Disc createDisc(Disc disc) {
        return null;
    }
}
