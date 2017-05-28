package edu.hm.shareit.repository;

import edu.hm.shareit.model.Book;
import edu.hm.shareit.model.Disc;
import edu.hm.shareit.util.MediumUtil;

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
    public boolean updateDisc(Disc disc) {
        int index = -1;
        for (Disc d : allDiscs) {
            if (d.getBarcode().equals(disc.getBarcode())) {
                index = allDiscs.indexOf(d);
                break;
            }
        }
        if (index == -1) {
            if (MediumUtil.isValidDisc(disc)) {
                allDiscs.add(disc);
                return true;
            }
            return false;
        }
        else {
            Disc found = allDiscs.get(index);
            if (disc.getDirector() != null) {
                found.setDirector(disc.getDirector());
            }

            return true;
        }
    }

    @Override
    public boolean updateBook(Book book) {
        int index = -1;
        for (Book b : allBooks) {
            if (b.getIsbn().equals(book.getIsbn())) {
                index = allBooks.indexOf(b);
                break;
            }
        }

        // Book not found
        if (index == -1) {
            if (MediumUtil.isValidBook(book)) {
                allBooks.add(book);
                return true;
            }
            return false;
        }
        // Book found
        else {
            Book found = allBooks.get(index);
            if (book.getAuthor() != null) {
                found.setAuthor(book.getAuthor());
            }

            if (book.getTitle() != null) {
                found.setTitle(book.getTitle());
            }

            return true;
        }
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
