package edu.hm.shareit.business;

import edu.hm.shareit.model.Book;
import edu.hm.shareit.model.Disc;
import edu.hm.shareit.repository.MediaRepository;
import edu.hm.shareit.util.MediumUtil;

import java.util.List;
import java.util.Objects;

import javax.inject.Inject;

/**
 * The media service handling our rest calls.
 */
public class MediaServiceImpl implements MediaService {
    
    @Inject
    private MediaRepository mediaRepository;

    @Override
    public ServiceStatus addBook(Book book) {
        if (book == null) {
            return ServiceStatus.ERROR_PARSING_JSON;
        }
        if (!MediumUtil.isValidISBN(book.getIsbn())) {
            return ServiceStatus.ERROR_ISBN_FORMAT;
        }
        book.setIsbn(MediumUtil.formatISBN(book.getIsbn()));
        if (!mediaRepository.createBook(book)) {
            return ServiceStatus.ERROR_ISBN_ALREADY_EXIST;
        }
        return ServiceStatus.OK;
    }

    @Override
    public ServiceStatus addDisc(Disc disc) {
        if (disc == null) {
            return ServiceStatus.ERROR_DISC_NOT_FOUND;
        }
        if (!MediumUtil.isValidBarcode(disc.getBarcode())) {
            return ServiceStatus.ERROR_BARCODE_FORMAT;
        }
        if (!mediaRepository.createDisc(disc)) {
            return ServiceStatus.ERROR_BARCODE_ALREADY_EXIST;
        }
        return ServiceStatus.OK;
    }

    @Override
    public ServiceResult getBooks() {
        List<Book> books = mediaRepository.findAllBooks();
        return new ServiceResult(ServiceStatus.OK, books.toArray(new Book[books.size()]));
    }

    @Override
    public ServiceResult getDiscs() {
        List<Disc> discs = mediaRepository.findAllDiscs();
        return new ServiceResult(ServiceStatus.OK, discs.toArray(new Disc[discs.size()]));
    }

    @Override
    public ServiceStatus updateBook(Book book, String isbn) {
        if (book == null) {
            return ServiceStatus.ERROR_PARSING_JSON;
        }
        if (!MediumUtil.isValidISBN(isbn)) {
            return ServiceStatus.ERROR_ISBN_FORMAT;
        }
        if (book.getAuthor() == null && book.getTitle().isEmpty()) {
           return ServiceStatus.ERROR_AUTHOR_AND_TITLE_MISSING;
        }
        book.setIsbn(MediumUtil.formatISBN(isbn));
        if (!mediaRepository.updateBook(book)) {
            return ServiceStatus.ERROR_BOOK_NOT_FOUND;
        }

        return ServiceStatus.OK;
    }

    @Override
    public ServiceStatus updateDisc(Disc disc, String barcode) {
        if (disc == null) {
            return ServiceStatus.ERROR_PARSING_JSON;
        }
        if (!MediumUtil.isValidBarcode(barcode)) {
            return ServiceStatus.ERROR_BARCODE_FORMAT;
        }
        if (disc.getDirector() == null || disc.getTitle() == null) {
            return ServiceStatus.ERROR_DIRECTOR_BARCODE_AND_FSK_MISSING;
        }
        if (Objects.nonNull(disc.getBarcode()) && !disc.getBarcode().equals(barcode)) {
            return ServiceStatus.ERROR_BARCODE_CHANGE;
        }
        if (!mediaRepository.updateDisc(disc)) {
            return ServiceStatus.ERROR_DISC_NOT_FOUND;
        }
        return ServiceStatus.OK;
    }

    @Override
    public ServiceResult getBook(String isbn) {
        if (!MediumUtil.isValidISBN(isbn)) {
            return new ServiceResult(ServiceStatus.ERROR_ISBN_FORMAT);
        }
        Book b = mediaRepository.findBook(MediumUtil.formatISBN(isbn));
        if (b == null) {
            return new ServiceResult(ServiceStatus.ERROR_BOOK_NOT_FOUND);
        }
        return new ServiceResult(ServiceStatus.OK, b);
    }

    @Override
    public ServiceResult getDisc(String barcode) {
        if (!MediumUtil.isValidBarcode(barcode)) {
            return new ServiceResult(ServiceStatus.ERROR_BARCODE_FORMAT);
        }
        Disc d = mediaRepository.findDisc(barcode);
        if (d == null) {
            return new ServiceResult(ServiceStatus.ERROR_DISC_NOT_FOUND);
        }
        return new ServiceResult(ServiceStatus.OK, d);
    }
}
