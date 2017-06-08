package edu.hm.shareit.filter;

import com.fasterxml.jackson.core.JsonParseException;
import edu.hm.shareit.business.ServiceStatus;

import javax.inject.Singleton;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 * Maps all Exceptions occurring during json parsing to an appropriate server response.
 */
@Provider
@Singleton
public class JSONParseExceptionMapper implements ExceptionMapper<JsonParseException> {
    @Override
    public Response toResponse(JsonParseException e) {
        return Response.status(ServiceStatus.ERROR_PARSING_JSON.getStatus()).entity(ServiceStatus.ERROR_PARSING_JSON).build();
    }
}

