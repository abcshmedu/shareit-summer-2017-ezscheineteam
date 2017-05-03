package edu.hm.shareit.business;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.ws.rs.core.Response;

/**
 * A class for describing the results/errors of the RestAPI calls.
 */
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum ServiceStatus {
    OK(Response.Status.OK, "Tutto bene."),
    ERROR_ISBN_FORMAT(Response.Status.BAD_REQUEST, "Die ISBN wurde falsch angegeben oder formatiert."),
    ERROR_BARCODE_FORMAT(Response.Status.BAD_REQUEST, "Der Barcode wurde falsch angegeben oder formatiert."),
    ERROR_BOOK_NOT_FOUND(Response.Status.NOT_FOUND, "Ein Buch mit dieser ISBN existiert nicht."),
    ERROR_DISC_NOT_FOUND(Response.Status.NOT_FOUND, "Eine Disc mit diesem Barcode existiert nicht."),
    ERROR_PARSING_JSON(Response.Status.BAD_REQUEST, "Das JSON-Objekt konnte nicht gelesen werden."),
    ERROR_NOT_IMPLEMENTED(Response.Status.NOT_IMPLEMENTED, "Service noch nicht implementiert"),
    ERROR_BOOK_LIST_EMPTY(Response.Status.NOT_FOUND, "Die B�cher-Liste ist leer."),
    ERROR_DISC_LIST_EMPTY(Response.Status.NOT_FOUND, "Die Disc-Liste ist leer."),
    ERROR_ISBN_ALREADY_EXIST(Response.Status.BAD_REQUEST, "Ein Buch mit dieser ISBN existiert bereits."),
    ERROR_BARCODE_ALREADY_EXIST(Response.Status.BAD_REQUEST, "Eine Disc mit diesem Barcode existiert bereits.");

    /**
     * Returns the status of an operation.
     * @param status the status of an operation.
     */
    public void setStatus(int status) {
        this.status = status;
    }

    /**
     * Returns more meta data to the status of an operation.
     * @param detail - More meta data to the status of an operation.
     */
    public void setDetail(String detail) {
        this.detail = detail;
    }

    private int status;
    private String detail;

    /**
     * Creates an object containing the results of a ServiceResult operation.
     *
     * @param status contains the http status code of the operation.
     * @param detail contains more details about the operation.
     */
    ServiceStatus(@JsonProperty("status") Response.Status status, @JsonProperty("detail") String detail) {
        this.status = status.getStatusCode();
        this.detail = detail;
    }

    /**
     * The HTTP-status code of the operation.
     *
     * @return HTTP-status code of the operation
     */
    @JsonProperty("status")
    public int getStatus() {
        return status;
    }

    /**
     * More details about the result/errors occurred during execution.
     *
     * @return A string containing more information about the operations results.
     */
    @JsonProperty("detail")
    public String getDetail() {
        return detail;
    }

}
