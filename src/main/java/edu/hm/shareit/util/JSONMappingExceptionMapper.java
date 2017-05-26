package edu.hm.shareit.util;

import com.fasterxml.jackson.databind.JsonMappingException;
import edu.hm.shareit.business.ServiceStatus;

import javax.inject.Singleton;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 * Maps all Exception occurring during json mapping to a appropriate response.
 */
@Provider
@Singleton
public class JSONMappingExceptionMapper implements ExceptionMapper<JsonMappingException> {
    @Override
    public Response toResponse(JsonMappingException e) {
        return Response.status(ServiceStatus.ERROR_PARSING_JSON.getStatus()).entity(ServiceStatus.ERROR_PARSING_JSON).build();
    }
}
