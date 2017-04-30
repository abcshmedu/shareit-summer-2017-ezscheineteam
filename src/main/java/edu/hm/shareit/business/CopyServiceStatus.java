package edu.hm.shareit.business;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.ws.rs.core.Response;

/**
 * A class for describing the results/errors of the CopyService operations.
 */
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum CopyServiceStatus {
    OK(Response.Status.OK, "Operation ausgeführt"),
    ERROR_ISBN_FORMAT(Response.Status.BAD_REQUEST, "Die ISBN wurde falsch angegeben oder formatiert."),
    ERROR_BARCODE_FORMAT(Response.Status.BAD_REQUEST, "Der Barcode wurde falsch angegeben oder formatiert."),
    ERROR_BOOK_NOT_FOUND(Response.Status.NOT_FOUND, "Ein Buch mit dieser ISBN existiert nicht."),
    ERROR_DISC_NOT_FOUND(Response.Status.NOT_FOUND, "Eine Disc mit diesem Barcode existiert nicht."),
    ERROR_PARSING_JSON(Response.Status.BAD_REQUEST, "Das JSON-Objekt konnte nicht gelesen werden."),
    ERROR_NOT_IMPLEMENTED(Response.Status.NOT_IMPLEMENTED, "Service noch nicht implementiert");

    private int status;
    
    private String detail;

    /**
     * Creates an object containing the results of a CopyServiceResult operation.
     * @param status contains the http status code of the operation.
     * @param detail contains more details about the operation.
     */
    CopyServiceStatus(Response.Status status, String detail) {
        this.status = status.getStatusCode();
        this.detail = detail;
    }

    /**
     * The HTTP-status code of the operation.
     * @return HTTP-status code of the operation
     */
    public int getStatus() {
        return status;
    }

    /**
     * More details about the result/errors occurred during execution.
     * @return A string containing more information about the operations results.
     */
    public String getDetail() {
        return detail;
    }
}
