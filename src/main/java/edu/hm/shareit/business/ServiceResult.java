package edu.hm.shareit.business;

public class ServiceResult {

    private final ServiceStatus status;

    private final Object result;

    public ServiceResult(ServiceStatus status) {
        this.status = status;
        this.result = null;
    }

    public ServiceResult(ServiceStatus status, Object result) {
        this.status = status;
        this.result = result;
    }

    public boolean containsResult() {
        return result != null;
    }

    public ServiceStatus getStatus() {
        return status;
    }
    
    public Object getResult() {
        return result;
    }

}
