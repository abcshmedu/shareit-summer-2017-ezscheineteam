package edu.hm.shareit.util;

import javax.ws.rs.ProcessingException;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import edu.hm.shareit.model.Token;

/**
 * Klasse welches TokenHandler implementiert.
 */
public class AuthServToken implements TokenHandler {

    private static final String TOKEN_TEMPLATE = "token";

    private static final String MAIN_URI = "http://auth-server-ezschein.herokuapp.com/oauth/";
    
    private static final String CHECK_URI = "check/{token}";
    
    @Override
    public Token validateToken(String token) {
        try {
            Response response = ClientBuilder.newClient()
                    .target(MAIN_URI)
                    .path(CHECK_URI)
                    .resolveTemplate(TOKEN_TEMPLATE, token)
                    .request().get();
            if (response.getStatus() == Status.OK.getStatusCode()) {
                return response.readEntity(Token.class);
            }
        } catch (ProcessingException processingException) {
            processingException.printStackTrace();
        }
        return null;
    }

}
