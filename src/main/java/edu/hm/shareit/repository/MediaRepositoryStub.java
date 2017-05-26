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
    private static List<Book> allBooks = new ArrayList<>();
    private static List<Disc> allDiscs = new ArrayList<>();

    @Override
    public boolean createBook(Book book) {
        for (Book b : allBooks) {
            if (b.getIsbn().equals(book.getIsbn())) {
                return false;
            }
        }
        allBooks.add(book);
        return true;
    }

    @Override
    public boolean updateDisc(Disc disc, String barcode) {
        int index = -1;
        for (Disc d : allDiscs) {
            if (d.getBarcode().equals(barcode)) {
                index = allDiscs.indexOf(d);
                break;
            }
        }
        if (index == -1) {
            return false;
        }
        allDiscs.set(index, disc);
        return true;
    }

    @Override
    public boolean updateBook(Book book, String isbn) {
        // search the database to see if we have a book with that isbn already
        // select * from Books where isbn = ?
        // if rs size == 0
        // insert into book table
        // else
        // update the Book
        int index = -1;
        for (Book b : allBooks) {
            if (b.getIsbn().equals(isbn)) {
                index = allBooks.indexOf(b);
                break;
            }
        }
        if (index == -1) {
            return false;
        }
        allBooks.set(index, book);
        return true;
    }

    @Override
    public List<Book> findAllBooks() {
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
    public boolean createDisc(Disc disc) {
        for (Disc d : allDiscs) {
            if (d.getBarcode().equals(disc.getBarcode())) {
                return false;
            }
        }
        allDiscs.add(disc);
        return true;
    }
}
