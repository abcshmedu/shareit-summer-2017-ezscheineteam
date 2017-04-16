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
     *
     */
    public MediaClient() {
        client = ClientBuilder.newClient();
    }

    /**
     *
     * @param isbn asd
     * @return asd
     */
    public Book getBooks(String isbn) {
        WebTarget target = client.target("http://localhost:8080/shareit/media/");
        Response response =  target.path("books/" + isbn).request().get(Response.class);

        if (response.getStatus() != MediaServiceResult.OK.getCode()) {
            throw new RuntimeException(response.getStatus() + ": there was an error on the server.");
        }

        return response.readEntity(Book.class);
    }

    /**
     *
     * @param isbn asd
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
     *
     * @return asd
     */
    public List<Book> getBooks() {
        WebTarget target = client.target("http://localhost:8080/shareit/media/");
        return target.path("books").request(MediaType.APPLICATION_JSON).get(new GenericType<List<Book>>() { });
    }

    /**
     *
     * @return
     */
    public List<Disc> getDiscs() {
        WebTarget target = client.target("http://localhost:8080/shareit/media/");
        return target.path("discs").request(MediaType.APPLICATION_JSON).get(new GenericType<List<Disc>>() { });
    }

    /**
     *
     * @param book asd
     * @return asd
     */
    public Book create(Book book) {
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
     * @return the updated book
     */
    public Book update(Book book) {
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
