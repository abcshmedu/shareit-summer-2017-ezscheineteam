package edu.hm.shareit.business;

import edu.hm.shareit.model.Book;
import edu.hm.shareit.model.Disc;
import edu.hm.shareit.model.Medium;
import edu.hm.shareit.repository.MediaRepository;
import edu.hm.shareit.repository.MediaRepositoryStub;

import java.util.List;

/**
 *
 */
public class MediaServiceImpl implements MediaService {
    private MediaRepository mediaRepository = new MediaRepositoryStub();

    private static final int MIN_ISBN_NUMBER_LENGTH = 4;
    private static final int MIN_BARCODE_NUMBER_LENGTH = 4;

    @Override
    public MediaServiceResult addBook(Book book) {
        if (book == null) {
            return MediaServiceResult.ERROR_PARSING_JSON;
        }
        if (book.getIsbn().length() < MIN_ISBN_NUMBER_LENGTH) {
            return MediaServiceResult.ERROR_ISBN_FORMAT;
        }
        mediaRepository.createBook(book);
        return MediaServiceResult.OK;
    }

    @Override
    public MediaServiceResult addDisc(Disc disc) {
        if (disc == null) {
            return MediaServiceResult.ERROR_PARSING_JSON;
        }
        if (disc.getBarcode().length() < MIN_BARCODE_NUMBER_LENGTH) {
            return MediaServiceResult.ERROR_BARCODE_FORMAT;
        }
        mediaRepository.createDisc(disc);
        return MediaServiceResult.OK;
    }

    @Override
    public Medium[] getBooks() {
        List<Book> books = mediaRepository.findAllBooks();
        return books.toArray(new Book[books.size()]);
    }

    @Override
    public Medium[] getDiscs() {
        List<Disc> discs = mediaRepository.findAllDiscs();
        return discs.toArray(new Disc[discs.size()]);
    }

    @Override
    public MediaServiceResult updateBook(Book book) {
        mediaRepository.update(book);

        return MediaServiceResult.OK;
    }

    @Override
    public MediaServiceResult updateDisc(Disc disc) {
        //mediaRepository.update(disc);

        return MediaServiceResult.OK;
    }

    @Override
    public Medium getBook(String isbn) {
        return mediaRepository.findBook(isbn);
    }

    @Override
    public Medium getDisc(String barcode) {
        return mediaRepository.findDisc(barcode);
    }
}
