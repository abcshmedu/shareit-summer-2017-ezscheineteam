package edu.hm.shareit.client;

import edu.hm.shareit.business.MediaServiceResult;
import edu.hm.shareit.model.Book;
import edu.hm.shareit.model.Disc;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

/**
 * A Client to test our server implementation.
 */
public class MediaClient {
    private Client client;

    /**
     * Creates a new client.
     */
    public MediaClient() {
        client = ClientBuilder.newClient();
    }

    /**
     * Requests a book with a specific isbn.
     * @param isbn The isbn to look for.
     * @return The book if found or else runtime exception.
     */
    public Book getBook(String isbn) {
        WebTarget target = client.target("http://localhost:8080/shareit/media/");
        Response response =  target.path("books/" + isbn).request().get(Response.class);

        if (response.getStatus() != MediaServiceResult.OK.getCode()) {
            throw new RuntimeException(response.getStatus() + ": there was an error on the server.");
        }

        return response.readEntity(Book.class);
    }

    /**
     * The client requests a disc with a specified barcode.
     * @param barcode barcode to get list from.
     * @return asd
     */
    public Disc getDisc(String barcode) {
        WebTarget target = client.target("http://localhost:8080/shareit/media/");
        Response response =  target.path("discs/" + barcode).request().get(Response.class);

        if (response.getStatus() != MediaServiceResult.OK.getCode()) {
            throw new RuntimeException(response.getStatus() + ": there was an error on the server.");
        }

        return response.readEntity(Disc.class);
    }
    /**
     * The client requests all books.
     * @return A list containing all books.
     */
    public List<Book> getBooks() {
        WebTarget target = client.target("http://localhost:8080/shareit/media/");
        return target.path("books").request(MediaType.APPLICATION_JSON).get(new GenericType<List<Book>>() { });
    }

    /**
     * Requests all discs.
     * @return A list containing all discs.
     */
    public List<Disc> getDiscs() {
        WebTarget target = client.target("http://localhost:8080/shareit/media/");
        return target.path("discs").request(MediaType.APPLICATION_JSON).get(new GenericType<List<Disc>>() { });
    }

    /**
     * Request the creation of a book in the repository of the server.
     * @param book the book to be created
     * @return The newly created book.
     */
    public Book createBook(Book book) {
        WebTarget target = client.target("http://localhost:8080/shareit/media/");

        Response response =  target.path("books/")
                .request(MediaType.APPLICATION_JSON)
                .post(Entity.entity(book, MediaType.APPLICATION_JSON));

        if (response.getStatus() != MediaServiceResult.OK.getCode()) {
            throw new RuntimeException(response.getStatus() + ": there was an error on the server.");
        }

        return response.readEntity(Book.class);
    }

    /**
     * Updates a book.
     * @param book book to be updated.
     * @return the updated book.
     */
    public Book updateBook(Book book) {
        WebTarget target = client.target("http://localhost:8080/shareit/media/");

        Response response =  target.path("books/" + book.getIsbn())
                .request(MediaType.APPLICATION_JSON)
                .put(Entity.entity(book, MediaType.APPLICATION_JSON));

        if (response.getStatus() != MediaServiceResult.OK.getCode()) {
            throw new RuntimeException(response.getStatus() + ": there was an error on the server.");
        }

        return response.readEntity(Book.class);
    }
}
