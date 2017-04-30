package edu.hm.shareit.client;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

/**
 * Client zum Testen der CopyResource Implementation.
 */
public class CopyClient {

    private static final String MAIN_URI = "http://localhost:8080/shareit/copy/";
    
    private static final String USER_TEMPLATE = "user";

    private static final String ISBN_TEMPLATE = "isbn";

    private static final String BARCODE_TEMPLATE = "barcode";
    
    private static final String BOOKS_URI = "{user}/books/";
    
    private static final String BOOK_URI = BOOKS_URI + "{isbn}";
    
    private static final String DISCS_URI = "{user}/discs/";
    
    private static final String DISC_URI = DISCS_URI + "{barcode}";
    
    private final Client client;
    
    private final WebTarget target;

    
    /**
     * Erzeugt einen neuen Client.
     */
    public CopyClient() {
        client = ClientBuilder.newClient();
        target = client.target(MAIN_URI);
    }


    /**
     * Stellt eine Anfrage an ein bestimmtes Exemplar Buch 
     * welches das jeweilige Konto besitzt.
     * @param user Der Benutzername des Kontos.
     * @param isbn Die ISBN des Buches.
     * @return Ein Response Objekt des Servers.
     */
    public Response getBook(String user, String isbn) {
        return target.path(BOOK_URI)
                .resolveTemplate(USER_TEMPLATE, user)
                .resolveTemplate(ISBN_TEMPLATE, isbn)
                .request().get();
    }

    /**
     * Stellt eine Anfrage an ein bestimmtes Exemplar Disc 
     * welches das jeweilige Konto besitzt.
     * @param user Der Benutzername des Kontos.
     * @param barcode Der Barcode der Disc.
     * @return Ein Response Objekt des Servers.
     */
    public Response getDisc(String user, String barcode) {
        return target.path(DISC_URI)
                .resolveTemplate(USER_TEMPLATE, user)
                .resolveTemplate(BARCODE_TEMPLATE, barcode)
                .request().get();
    }

   /**
     * Stellt eine Anfrage an saemtlichen Exemplare Buch
     * welches das jeweilige Konto besitzt.
     * @param user Der Benutzername des Kontos.
     * @return Ein Response Objekt des Servers.
     */
    public Response getBooks(String user) {
        return target.path(BOOKS_URI)
                .resolveTemplate(USER_TEMPLATE, user)
                .request().get();
    }

    /**
     * Stellt eine Anfrage an saemtlichen Exemplare Disc
     * welches das jeweilige Konto besitzt.
     * @param user Der Benutzername des Kontos.
     * @return Ein Response Objekt des Servers.
     */
    public Response getDiscs(String user) {
        return target.path(DISCS_URI)
                .resolveTemplate(USER_TEMPLATE, user)
                .request().get();
    }

    /**
     * Stellt eine Anfrage ein Exemplar Buch
     * dem jeweiligen Konto hinzu zu fuegen.
     * @param user Der Benutzername des Kontos.
     * @param json Das JSON Objekt als String.
     * @return Ein Response Objekt des Servers.
     */
    public Response createBook(String user, String json) {
        return target.path(BOOKS_URI)
                .resolveTemplate(USER_TEMPLATE, user)
                .request().post(Entity.json(json));
    }

    /**
     * Stellt eine Anfrage ein Exemplar Disc
     * dem jeweiligen Konto hinzu zu fuegen.
     * @param user Der Benutzername des Kontos.
     * @param json Das JSON Objekt als String.
     * @return Ein Response Objekt des Servers.
     */
    public Response createDisc(String user, String json) {
        return target.path(DISCS_URI)
                .resolveTemplate(USER_TEMPLATE, user)
                .request().post(Entity.json(json));
    }
    
    /**
     * Stellt eine Anfrage die Eigenschaften eines Exemplares Buch,
     * welches das jeweiligen Konto besitzt,
     * zu aktualisieren.
     * @param user Der Benutzername des Kontos.
     * @param isbn Die ISBN des Buches.
     * @param json Das JSON Objekt als String.
     * @return Ein Response Objekt des Servers.
     */
    public Response updateBook(String user, String isbn, String json) {
        return target.path(BOOK_URI)
                .resolveTemplate(USER_TEMPLATE, user)
                .resolveTemplate(ISBN_TEMPLATE, isbn)
                .request().put(Entity.json(json));
    }

    /**
     * Stellt eine Anfrage die Eigenschaften eines Exemplares Disc,
     * welches das jeweiligen Konto besitzt,
     * zu aktualisieren.
     * @param user Der Benutzername des Kontos.
     * @param barcode Der Barcode der Disc.
     * @param json Das JSON Objekt als String.
     * @return Ein Response Objekt des Servers.
     */
    public Response updateDisc(String user, String barcode, String json) {
        return target.path(DISC_URI)
                .resolveTemplate(USER_TEMPLATE, user)
                .resolveTemplate(BARCODE_TEMPLATE, barcode)
                .request().put(Entity.json(json));
    }

    /**
     * Stellt eine Anfrage ein Exemplar Buch,
     * welches das jeweiligen Konto besitzt,
     * zu loeschen.
     * @param user Der Benutzername des Kontos.
     * @param isbn Die ISBN des Buches.
     * @return Ein Response Objekt des Servers.
     */
    public Response deleteBook(String user, String isbn) {
        return target.path(BOOK_URI)
                .resolveTemplate(USER_TEMPLATE, user)
                .resolveTemplate(ISBN_TEMPLATE, isbn)
                .request().delete();
    }

    /**
     * Stellt eine Anfrage ein Exemplar Disc,
     * welches das jeweiligen Konto besitzt,
     * zu loeschen.
     * @param user Der Benutzername des Kontos.
     * @param barcode Der Barcode der Disc.
     * @return Ein Response Objekt des Servers.
     */
    public Response deleteDisc(String user, String barcode) {
        return target.path(DISC_URI)
                .resolveTemplate(USER_TEMPLATE, user)
                .resolveTemplate(BARCODE_TEMPLATE, barcode)
                .request().delete();
    }
}
