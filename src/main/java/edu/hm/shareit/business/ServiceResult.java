package edu.hm.shareit.business;

/**
 * A class containing the result object of an request and
 * meta data to the status of the operation.
 */
public class ServiceResult {

    private final ServiceStatus status;

    private final Object result;

    /**
     * Creates a new ServiceResult instance.
     * @param status - the state of an request operation.
     */
    public ServiceResult(ServiceStatus status) {
        this.status = status;
        this.result = null;
    }

    /**
     * Creates a new ServiceResult instance.
     * @param status - the state of an request operation.
     * @param result - the result object of the request operation.
     */
    public ServiceResult(ServiceStatus status, Object result) {
        this.status = status;
        this.result = result;
    }

    /**
     * Checks if we already have a result object.
     * @return true, if there is a result object, false otherwise.
     */
    public boolean containsResult() {
        return result != null;
    }

    /**
     * The current state of the operation.
     * @return state of the current operation
     */
    public ServiceStatus getStatus() {
        return status;
    }

    /**
     * The result of the operation.
     * @return result of the operation.
     */
    public Object getResult() {
        return result;
    }

}
