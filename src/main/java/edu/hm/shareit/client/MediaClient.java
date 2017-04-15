package edu.hm.shareit.client;

import edu.hm.shareit.model.Book;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 *
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
    public Book get(String isbn) {
        WebTarget target = client.target("http://localhost:8080/shareit/media/");
        return target.path("books/" + isbn).request().get(Book.class);
    }

    /**
     *
     * @return
     */
    public List<Book> get() {
        WebTarget target = client.target("http://localhost:8080/shareit/media/");
        return target.path("books").request(MediaType.APPLICATION_JSON).get(new GenericType<List<Book>>() { });
    }
}
