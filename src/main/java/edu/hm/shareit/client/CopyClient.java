package edu.hm.shareit.client;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

import com.fasterxml.jackson.databind.ObjectMapper;

import edu.hm.shareit.util.AuthenticationFilter;

/**
 * Client zum Testen der CopyResource Implementation.
 */
public class CopyClient {

    private static final String MAIN_URI = "http://localhost:8080/shareit/copy/";
    
    private static final String OWNER_TEMPLATE = "owner";

    private static final String ISBN_TEMPLATE = "isbn";

    private static final String BARCODE_TEMPLATE = "barcode";
    
    private static final String BOOKS_URI = "books/";
    
    private static final String OWNER_URI = "{owner}/";
    
    private static final String OWNER_BOOKS_URI = OWNER_URI + BOOKS_URI;
    
    private static final String BOOK_URI = OWNER_BOOKS_URI + "{isbn}";
    
    private static final String DISCS_URI = "discs/";
    
    private static final String OWNER_DISCS_URI = OWNER_URI + DISCS_URI;
    
    private static final String DISC_URI = OWNER_DISCS_URI + "{barcode}";
    
    private static final String TOKEN_URI = "http://auth-server-ezschein.herokuapp.com/oauth/users/authenticate";
    
    private final Client client;
    
    private final WebTarget target;

    private String token;
    
    /**
     * Erzeugt einen neuen Client.
     */
    public CopyClient() {
        client = ClientBuilder.newClient();
        String jsonToken = client.target(TOKEN_URI)
                .request()
                .post(Entity.json("{\"name\" : \"WalterWhite\",\"password\" : \"knockknock\"}"), String.class);
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            token =  objectMapper.readTree(jsonToken).get("token").textValue();
        } catch (Exception e) {
            e.printStackTrace();
        }
        target = client.target(MAIN_URI);
    }


    /**
     * Stellt eine Anfrage an ein bestimmtes Exemplar Buch 
     * welches der jeweiligen Besitzer besitzt.
     * @param owner Der Name des Besitzers.
     * @param isbn Die ISBN des Buches.
     * @return Ein Response Objekt des Servers.
     */
    public Response getBookCopy(String owner, String isbn) {
        return target.path(BOOK_URI)
                .resolveTemplate(OWNER_TEMPLATE, owner)
                .resolveTemplate(ISBN_TEMPLATE, isbn)
                .request()
                .header(AuthenticationFilter.TOKEN_HEADER_FIELD, token)
                .get();
    }

    /**
     * Stellt eine Anfrage an ein bestimmtes Exemplar Disc 
     * welches der jeweiligen Besitzer besitzt.
     * @param owner Der Name des Besitzers.
     * @param barcode Der Barcode der Disc.
     * @return Ein Response Objekt des Servers.
     */
    public Response getDiscCopy(String owner, String barcode) {
        return target.path(DISC_URI)
                .resolveTemplate(OWNER_TEMPLATE, owner)
                .resolveTemplate(BARCODE_TEMPLATE, barcode)
                .request()
                .header(AuthenticationFilter.TOKEN_HEADER_FIELD, token)
                .get();
    }

   /**
     * Stellt eine Anfrage an saemtlichen Exemplare Buch
     * welches der jeweiligen Besitzer besitzt.
     * @param owner Der Benutzername des Kontos.
     * @return Ein Response Objekt des Servers.
     */
    public Response getBookCopies(String owner) {
        return target.path(OWNER_BOOKS_URI)
                .resolveTemplate(OWNER_TEMPLATE, owner)
                .request()
                .header(AuthenticationFilter.TOKEN_HEADER_FIELD, token)
                .get();
    }

    /**
     * Stellt eine Anfrage an saemtlichen Exemplare Disc
     * welches der jeweiligen Besitzer besitzt.
     * @param owner Der Name des Besitzers.
     * @return Ein Response Objekt des Servers.
     */
    public Response getDiscCopies(String owner) {
        return target.path(OWNER_DISCS_URI)
                .resolveTemplate(OWNER_TEMPLATE, owner)
                .request()
                .header(AuthenticationFilter.TOKEN_HEADER_FIELD, token)
                .get();
    }
    
    /**
     * Stellt eine Anfrage an saemtlichen Exemplare Buch.
     * @return Ein Response Objekt des Servers.
     */
    public Response getBookCopies() {
        return target.path(BOOKS_URI)
                .request()
                .header(AuthenticationFilter.TOKEN_HEADER_FIELD, token)
                .get();
    }

    /**
     * Stellt eine Anfrage an saemtlichen Exemplare Disc.
     * @return Ein Response Objekt des Servers.
     */
    public Response getDiscCopies() {
        return target.path(DISCS_URI)
                .request()
                .header(AuthenticationFilter.TOKEN_HEADER_FIELD, token)
                .get();
    }

    /**
     * Stellt eine Anfrage an saemtlichen Exemplare
     * welches der jeweiligen Besitzer besitzt.
     * @param owner Der Name des Besitzers.
     * @return Ein Response Objekt des Servers.
     */
    public Response getOwnerCopies(String owner) {
        return target.path(OWNER_URI)
                .resolveTemplate(OWNER_TEMPLATE, owner)
                .request()
                .header(AuthenticationFilter.TOKEN_HEADER_FIELD, token)
                .get();
    }
    
    /**
     * Stellt eine Anfrage an saemtlichen Exemplare.
     * @return Ein Response Objekt des Servers.
     */
    public Response getCopies() {
        return target.request()
                .header(AuthenticationFilter.TOKEN_HEADER_FIELD, token)
                .get();
    }
    
    /**
     * Stellt eine Anfrage ein Exemplar hinzu zu fuegen.
     * @param json Das JSON Objekt als String.
     * @return Ein Response Objekt des Servers.
     */
    public Response createCopy(String json) {
        return target.request()
                .header(AuthenticationFilter.TOKEN_HEADER_FIELD, token)
                .post(Entity.json(json));
    }
    
    /**
     * Stellt eine Anfrage die Eigenschaften eines Exemplares Buch,
     * welches der jeweiligen Besitzer besitzt,
     * zu aktualisieren.
     * @param owner Der Name des Besitzers.
     * @param isbn Die ISBN des Buches.
     * @param json Das JSON Objekt als String.
     * @return Ein Response Objekt des Servers.
     */
    public Response updateBookCopy(String owner, String isbn, String json) {
        return target.path(BOOK_URI)
                .resolveTemplate(OWNER_TEMPLATE, owner)
                .resolveTemplate(ISBN_TEMPLATE, isbn)
                .request()
                .header(AuthenticationFilter.TOKEN_HEADER_FIELD, token)
                .put(Entity.json(json));
    }

    /**
     * Stellt eine Anfrage die Eigenschaften eines Exemplares Disc,
     * welches der jeweilige Besitzer besitzt,
     * zu aktualisieren.
     * @param owner Der Name des Besitzers.
     * @param barcode Der Barcode der Disc.
     * @param json Das JSON Objekt als String.
     * @return Ein Response Objekt des Servers.
     */
    public Response updateDiscCopy(String owner, String barcode, String json) {
        return target.path(DISC_URI)
                .resolveTemplate(OWNER_TEMPLATE, owner)
                .resolveTemplate(BARCODE_TEMPLATE, barcode)
                .request()
                .header(AuthenticationFilter.TOKEN_HEADER_FIELD, token)
                .put(Entity.json(json));
    }

    /**
     * Stellt eine Anfrage ein Exemplar Buch,
     * welches der jeweilige Besitzer besitzt,
     * zu loeschen.
     * @param owner Der Name des Besitzers.
     * @param isbn Die ISBN des Buches.
     * @return Ein Response Objekt des Servers.
     */
    public Response deleteBookCopy(String owner, String isbn) {
        return target.path(BOOK_URI)
                .resolveTemplate(OWNER_TEMPLATE, owner)
                .resolveTemplate(ISBN_TEMPLATE, isbn)
                .request()
                .header(AuthenticationFilter.TOKEN_HEADER_FIELD, token)
                .delete();
    }

    /**
     * Stellt eine Anfrage ein Exemplar Disc,
     * welches der jeweilige Besitzer besitzt,
     * zu loeschen.
     * @param owner Der Name des Besitzers.
     * @param barcode Der Barcode der Disc.
     * @return Ein Response Objekt des Servers.
     */
    public Response deleteDiscCopy(String owner, String barcode) {
        return target.path(DISC_URI)
                .resolveTemplate(OWNER_TEMPLATE, owner)
                .resolveTemplate(BARCODE_TEMPLATE, barcode)
                .request()
                .header(AuthenticationFilter.TOKEN_HEADER_FIELD, token)
                .delete();
    }
}
