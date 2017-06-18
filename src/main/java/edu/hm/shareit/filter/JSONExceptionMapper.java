package edu.hm.shareit.filter;

import com.fasterxml.jackson.databind.exc.PropertyBindingException;

import edu.hm.shareit.business.ServiceStatus;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 * Maps all Exception occurring during json mapping to a appropriate response.
 */
@Provider
public class JSONExceptionMapper implements ExceptionMapper<PropertyBindingException> {
    @Override
    public Response toResponse(PropertyBindingException e) {
        return Response.status(ServiceStatus.ERROR_PARSING_JSON.getStatus()).entity(ServiceStatus.ERROR_PARSING_JSON).build();
    }
}
