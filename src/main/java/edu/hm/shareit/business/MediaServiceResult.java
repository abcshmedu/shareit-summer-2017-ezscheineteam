package edu.hm.shareit.business;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.ws.rs.core.Response;

/**
 * A class for describing the results/errors of the MediaService operations.
 */
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum MediaServiceResult {
    OK(Response.Status.OK, "Tutto bene."),
    ERROR_ISBN_FORMAT(Response.Status.BAD_REQUEST, "Die ISBN wurde falsch angegeben oder formatiert."),
    ERROR_BARCODE_FORMAT(Response.Status.BAD_REQUEST, "Der Barcode wurde falsch angegeben oder formatiert."),
    ERROR_BOOK_NOT_FOUND(Response.Status.NOT_FOUND, "Ein Buch mit dieser ISBN existiert nicht."),
    ERROR_DISC_NOT_FOUND(Response.Status.NOT_FOUND, "Eine Disc mit diesem Barcode existiert nicht."),
    ERROR_PARSING_JSON(Response.Status.BAD_REQUEST, "Das Json konnte nicht gelesen werden.");

    private Response.Status status;
    private String detail;

    /**
     * Creates an object containing the results of a MediaService operation.
     * @param status contains the http status code of the operation.
     * @param detail contains more details about the operation.
     */
    MediaServiceResult(Response.Status status, String detail) {
        this.status = status;
        this.detail = detail;
    }

    /**
     * Returns the corresponding HTTP-Status code.
     * @return HTTP-Status code
     */
    public int getCode() {
        return status.getStatusCode();
    }

    /**
     * More details about the result/errors occurred during execution.
     * @return A string containing more information about the operations results.
     */
    public String getDetail() {
        return detail;
    }

    /**
     * The HTTP-status code of the operation.
     * @return HTTP-status code of the operation
     */
    public Response.Status getStatus() {
        return status;
    }
}
