package edu.hm.shareit.filter;

import java.io.IOException;

import javax.inject.Inject;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;

import edu.hm.shareit.business.ServiceStatus;
import edu.hm.shareit.model.Token;
import edu.hm.shareit.util.TokenHandler;


/**
 * This filter verify the access permissions for a user
 * based on username and passowrd provided in request. 
 */
@Provider
public class AuthenticationFilter implements javax.ws.rs.container.ContainerRequestFilter {

    public static final String TOKEN_HEADER_FIELD = "UserToken";

    public static final String TOKEN_PROP = "CurrentTokenData";
    
    private final TokenHandler tokenHandler;
    
    /**
     * Erzeugt ein neues AuthenticationFilter Objekt.
     * @param tokenHandler Token Handler welcher verwendet werden soll.
     */
    @Inject
    public AuthenticationFilter(TokenHandler tokenHandler) {
        this.tokenHandler = tokenHandler;
    }
    
    @Override
    public void filter(ContainerRequestContext requestContext) throws IOException {
        String token = requestContext.getHeaderString(TOKEN_HEADER_FIELD);
        if (token == null) {
            requestContext.abortWith(Response
                    .status(ServiceStatus.ERROR_UNAUTHORIZED.getStatus())
                    .entity(ServiceStatus.ERROR_UNAUTHORIZED)
                    .build());
        } else {
            Token currentToken = tokenHandler.validateToken(token);
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
}
