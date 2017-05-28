package edu.hm.shareit.util;

import java.io.IOException;

import javax.ws.rs.ProcessingException;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.Provider;

import edu.hm.shareit.business.ServiceStatus;
import edu.hm.shareit.model.Token;


/**
 * This filter verify the access permissions for a user
 * based on username and passowrd provided in request. 
 */
@Provider
public class AuthenticationFilter implements javax.ws.rs.container.ContainerRequestFilter {

    private static final String TOKEN_TEMPLATE = "token";

    public static final String TOKEN_HEADER_FIELD = "UserToken";

    public static final String TOKEN_PROP = "CurrentTokenData";

    private static final String MAIN_URI = "http://auth-server-ezschein.herokuapp.com/oauth/";
    
    private static final String CHECK_URI = "check/{token}";
    
    @Override
    public void filter(ContainerRequestContext requestContext) throws IOException {
        String token = requestContext.getHeaderString(TOKEN_HEADER_FIELD);
        if (token == null) {
            requestContext.abortWith(Response
                    .status(ServiceStatus.ERROR_UNAUTHORIZED.getStatus())
                    .entity(ServiceStatus.ERROR_UNAUTHORIZED)
                    .build());
        } else {
            Token currentToken = validateToken(token);
            if (currentToken == null) {
                requestContext.abortWith(Response
                        .status(ServiceStatus.ERROR_TOKEN_NOT_VALID.getStatus())
                        .entity(ServiceStatus.ERROR_TOKEN_NOT_VALID)
                        .build());
            } else {
                requestContext.setProperty(TOKEN_PROP, currentToken);
            }
        }
    }


    /**
     * Ueberprueft ob ein token gueltig ist indem 
     * dieses an den Auth Server gesendet wird.
     * @param token Das Tokem
     * @return Ein Token Objekt falls das token gueltig ist, sonst null.
     */
    private Token validateToken(String token) {
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
