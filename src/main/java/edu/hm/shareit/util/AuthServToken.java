package edu.hm.shareit.util;

import javax.ws.rs.ProcessingException;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.fasterxml.jackson.databind.ObjectMapper;

import edu.hm.shareit.model.Token;

/**
 * Klasse welches TokenHandler implementiert.
 */
public class AuthServToken implements TokenHandler {

    private static final String AUTH_JSON = "{\"name\" : \"%s\",\"password\" : \"%s\"}";

    private static final String TOKEN_TEMPLATE = "token";

    private static final String MAIN_URI = "http://auth-server-ezschein.herokuapp.com/oauth/";
    
    private static final String TOKEN_URI = "users/authenticate";
    
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

    @Override
    public String getToken(String name, String password) {
        String post = String.format(AUTH_JSON, name, password);
        String jsonToken = ClientBuilder.newClient()
                .target(MAIN_URI)
                .path(TOKEN_URI)
                .request()
                .post(Entity.json(post), String.class);
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.readTree(jsonToken).get("token").textValue();
        } catch (Exception e) {
            return null;
        }
    }

}
