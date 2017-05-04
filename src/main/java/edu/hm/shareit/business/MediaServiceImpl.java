package edu.hm.shareit.business;

import edu.hm.shareit.model.Book;
import edu.hm.shareit.model.Disc;
import edu.hm.shareit.repository.MediaRepository;
import edu.hm.shareit.repository.MediaRepositoryStub;
import edu.hm.shareit.util.MediumUtil;

import java.util.List;

/**
 * The media service handling our rest calls.
 */
public class MediaServiceImpl implements MediaService {
    private MediaRepository mediaRepository = new MediaRepositoryStub();

    @Override
    public ServiceStatus addBook(Book book) {
        if (book == null) {
            return ServiceStatus.ERROR_PARSING_JSON;
        }
        if (!MediumUtil.isValidISBN(book.getIsbn())) {
            return ServiceStatus.ERROR_ISBN_FORMAT;
        }
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
        if (books.isEmpty()) {
            return new ServiceResult(ServiceStatus.ERROR_BOOK_LIST_EMPTY);
        }
        return new ServiceResult(ServiceStatus.OK, books.toArray(new Book[books.size()]));
    }

    @Override
    public ServiceResult getDiscs() {
        List<Disc> discs = mediaRepository.findAllDiscs();
        if (discs.isEmpty()) {
            return new ServiceResult(ServiceStatus.ERROR_DISC_LIST_EMPTY);
        }
        return new ServiceResult(ServiceStatus.OK, discs.toArray(new Disc[discs.size()]));
    }

    @Override
    public ServiceStatus updateBook(Book book, String isbn) {
        if (book == null) {
            return ServiceStatus.ERROR_PARSING_JSON;
        }
        if (!MediumUtil.isValidISBN(book.getIsbn())) {
            return ServiceStatus.ERROR_ISBN_FORMAT;
        }

        if (!mediaRepository.updateBook(book, isbn)) {
            return ServiceStatus.ERROR_BOOK_NOT_FOUND;
        }

        return ServiceStatus.OK;
    }

    @Override
    public ServiceStatus updateDisc(Disc disc, String barcode) {
        if (disc == null) {
            return ServiceStatus.ERROR_PARSING_JSON;
        }
        if (!MediumUtil.isValidBarcode(disc.getBarcode())) {
            return ServiceStatus.ERROR_BARCODE_FORMAT;
        }

        if (!mediaRepository.updateDisc(disc, barcode)) {
            return ServiceStatus.ERROR_DISC_NOT_FOUND;
        }
        return ServiceStatus.OK;
    }

    @Override
    public ServiceResult getBook(String isbn) {
        if (!MediumUtil.isValidISBN(isbn)) {
            return new ServiceResult(ServiceStatus.ERROR_ISBN_FORMAT);
        }
        Book b = mediaRepository.findBook(isbn);
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
