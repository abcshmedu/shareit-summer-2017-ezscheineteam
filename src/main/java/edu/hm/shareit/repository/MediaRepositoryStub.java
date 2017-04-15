package edu.hm.shareit.repository;

import edu.hm.shareit.model.Book;
import edu.hm.shareit.model.Disc;
import edu.hm.shareit.model.Medium;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Just a mock class as long as we don't have a real Repository.
 */
public class MediaRepositoryStub implements MediaRepository {
    private List<Book> allBooks = new ArrayList<>();
    private List<Disc> allDiscs = new ArrayList<>();

    @Override
    public void createBook(Book b) {
        System.out.println(allBooks.size());
        allBooks.add(b);
        System.out.println(allBooks.size());
    }

    /**
     *
     */
    public MediaRepositoryStub() {
        allBooks.add(new Book("Die Eule mit der Beule", "Susanne Weber", "978-3789167065"));
        allBooks.add(new Book("Das Buch", "DerAutor", "12345"));
        allDiscs.add(new Disc("Never Gonna Give You Up", "123-124132", 0, "Rick Astley"));
        allDiscs.add(new Disc("Die CD", "123-123", 0, "Der Künstler"));
    }
    @Override
    public List<Medium> findAllMedia() {
        List<Medium> media = new ArrayList<>();

        media.addAll(allBooks);
        media.addAll(allDiscs);

        return media;
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
}
