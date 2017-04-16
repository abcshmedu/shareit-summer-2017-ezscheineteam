package edu.hm.shareit.repository;

import edu.hm.shareit.model.Book;
import edu.hm.shareit.model.Disc;
import edu.hm.shareit.model.Medium;

import java.util.List;

public interface MediaRepository {
    List<Medium> findAllMedia();
    List<Book> findAllBooks();
    List<Disc> findAllDiscs();
    Book findBook(String isbn);
    Disc findDisc(String barcode);
    void createBook(Book b);
    Book update(Book book);
    Disc createDisc(Disc disc);
}
