package edu.hm.shareit.client;

import edu.hm.shareit.model.Book;
import edu.hm.shareit.model.Disc;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * A Client to test our server implementation.
 */
public class MediaClient {
    private WebTarget target;

    private static final String MAIN_URI = "http://localhost:8080/shareit/media/";
    private static final String PATH_BOOKS = "books/";
    private static final String PATH_DISCS = "discs/";

    /**
     * Creates a new client.
     */
    MediaClient() {
        Client client = ClientBuilder.newClient();
        target = client.target(MAIN_URI);
    }

    /**
     * Requests a book with a specific isbn.
     * @param isbn The isbn to look for.
     * @return The book if found or else runtime exception.
     */
    Response getBook(String isbn) {
        return target.path(PATH_BOOKS + isbn).request().get(Response.class);
    }

    /**
     * The client requests a disc with a specified barcode.
     * @param barcode barcode to get list from.
     * @return asd
     */
    Response getDisc(String barcode) {
        return target.path(PATH_DISCS + barcode).request().get(Response.class);
    }
    /**
     * The client requests all books.
     * @return A list containing all books.
     */
    public Response getBooks() {
        return target.path(PATH_BOOKS).request(MediaType.APPLICATION_JSON).get(Response.class);
    }

    /**
     * Requests all discs.
     * @return A list containing all discs.
     */
    public Response getDiscs() {
        return target.path(PATH_DISCS).request(MediaType.APPLICATION_JSON).get(Response.class);
    }

    /**
     * Request the creation of a book in the repository of the server.
     * @param book the book to be created
     * @return The newly created book.
     */
    Response createBook(Book book) {
        return target.path(PATH_BOOKS)
                .request(MediaType.APPLICATION_JSON)
                .post(Entity.entity(book, MediaType.APPLICATION_JSON));
    }

    /**
     * Request a book to be updated.
     * @param book book to be updated.
     * @return the response to the request.
     */
    public Response updateBook(Book book) {
        return target.path(PATH_BOOKS + book.getIsbn())
                .request(MediaType.APPLICATION_JSON)
                .put(Entity.entity(book, MediaType.APPLICATION_JSON));
    }

    /**
     * Request a disc to be updated.
     * @param disc disc to be updated.
     * @return the response to the request.
     */
    public Response updateDisc(Disc disc) {
        return target.path(PATH_DISCS + disc.getBarcode())
                .request(MediaType.APPLICATION_JSON)
                .put(Entity.entity(disc, MediaType.APPLICATION_JSON));
    }

    /**
     * Request the creation of a new disc on the server.
     * @param disc - the disc to be created (needs a valid Barcode).
     * @return the response to the request.
     */
    public Response createDisc(Disc disc) {
        return target.path(PATH_DISCS)
                .request(MediaType.APPLICATION_JSON)
                .post(Entity.entity(disc, MediaType.APPLICATION_JSON));
    }
}
