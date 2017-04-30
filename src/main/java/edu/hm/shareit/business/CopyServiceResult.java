package edu.hm.shareit.business;

public class CopyServiceResult {

    private final CopyServiceStatus status;

    private final Object result;

    public CopyServiceResult(CopyServiceStatus status) {
        this.status = status;
        this.result = null;
    }

    public CopyServiceResult(CopyServiceStatus status, Object result) {
        this.status = status;
        this.result = result;
    }

    public boolean containsResult() {
        return result != null;
    }

    public CopyServiceStatus getStatus() {
        return status;
    }
    
    public Object getResult() {
        return result;
    }

}
