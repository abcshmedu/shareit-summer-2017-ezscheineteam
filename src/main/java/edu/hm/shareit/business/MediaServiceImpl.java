package edu.hm.shareit.business;

import edu.hm.shareit.model.Book;
import edu.hm.shareit.model.Disc;
import edu.hm.shareit.repository.MediaRepository;
import edu.hm.shareit.repository.MediaRepositoryStub;
import edu.hm.shareit.util.MediumUtil;

import java.util.List;

/**
 *
 */
public class MediaServiceImpl implements MediaService {
    private MediaRepository mediaRepository = new MediaRepositoryStub();

    private static final int MIN_ISBN_NUMBER_LENGTH = 4;
    private static final int MIN_BARCODE_NUMBER_LENGTH = 4;

    @Override
    public ServiceStatus addBook(Book book) {
        if (book == null) {
            return ServiceStatus.ERROR_PARSING_JSON;
        }
        if (book.getIsbn().length() < MIN_ISBN_NUMBER_LENGTH) {
            return ServiceStatus.ERROR_ISBN_FORMAT;
        }
        mediaRepository.createBook(book);
        return ServiceStatus.OK;
    }

    @Override
    public ServiceStatus addDisc(Disc disc) {
        if (disc == null) {
            return ServiceStatus.ERROR_BOOK_NOT_FOUND;
        }
        if (disc.getBarcode().length() < MIN_BARCODE_NUMBER_LENGTH) {
            return ServiceStatus.ERROR_BARCODE_FORMAT;
        }
        mediaRepository.createDisc(disc);
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
        if (book == null || !MediumUtil.isValidISBN(book.getIsbn())) {
            return ServiceStatus.ERROR_ISBN_FORMAT;
        }

        if (!mediaRepository.updateBook(book, isbn))
            return ServiceStatus.ERROR_BOOK_NOT_FOUND;

        return ServiceStatus.OK;
    }

    @Override
    public ServiceStatus updateDisc(Disc disc) {
        if (disc == null || !MediumUtil.isValidBarcode(disc))
            return ServiceStatus.ERROR_BARCODE_FORMAT;
        mediaRepository.updateDisc(disc);
        return ServiceStatus.OK;
    }

    @Override
    public ServiceResult getBook(String isbn) {
        Book b = mediaRepository.findBook(isbn);
        if (b == null)
            return new ServiceResult(ServiceStatus.ERROR_BOOK_NOT_FOUND);
        return new ServiceResult(ServiceStatus.OK, b);
    }

    @Override
    public ServiceResult getDisc(String barcode) {
        Disc d = mediaRepository.findDisc(barcode);
        return new ServiceResult(ServiceStatus.OK, d);
    }
}
