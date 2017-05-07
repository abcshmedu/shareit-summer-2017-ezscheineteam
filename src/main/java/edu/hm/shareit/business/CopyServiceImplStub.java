package edu.hm.shareit.business;

import edu.hm.shareit.model.Copy;

/**
 * Stub für den Service: Anlegen von Exemplaren.
 */
public class CopyServiceImplStub implements CopyService {
    
    
    @Override
    public ServiceStatus addCopy(Copy copy) {
        // TODO Auto-generated method stub
        return ServiceStatus.ERROR_NOT_IMPLEMENTED;
    }

    @Override
    public ServiceStatus updateBookCopy(Copy copy, String owner, String isbn) {
        // TODO Auto-generated method stub
        return ServiceStatus.ERROR_NOT_IMPLEMENTED;
    }

    @Override
    public ServiceStatus updateDiscCopy(Copy copy, String owner, String barcode) {
        // TODO Auto-generated method stub
        return ServiceStatus.ERROR_NOT_IMPLEMENTED;
    }

    @Override
    public ServiceStatus deleteBookCopy(String owner, String isbn) {
        // TODO Auto-generated method stub
        return ServiceStatus.ERROR_NOT_IMPLEMENTED;
    }

    @Override
    public ServiceStatus deleteDiscCopy(String owner, String barcode) {
        // TODO Auto-generated method stub
        return ServiceStatus.ERROR_NOT_IMPLEMENTED;
    }

    @Override
    public ServiceResult getCopies() {
        // TODO Auto-generated method stub
        return new ServiceResult(ServiceStatus.ERROR_NOT_IMPLEMENTED);
    }

    @Override
    public ServiceResult getBookCopy(String owner, String isbn) {
        // TODO Auto-generated method stub
        return new ServiceResult(ServiceStatus.ERROR_NOT_IMPLEMENTED);
    }

    @Override
    public ServiceResult getDiscCopy(String owner, String barcode) {
        // TODO Auto-generated method stub
        return new ServiceResult(ServiceStatus.ERROR_NOT_IMPLEMENTED);
    }

    @Override
    public ServiceResult getBookCopies() {
        // TODO Auto-generated method stub
        return new ServiceResult(ServiceStatus.ERROR_NOT_IMPLEMENTED);
    }

    @Override
    public ServiceResult getDiscCopies() {
        // TODO Auto-generated method stub
        return new ServiceResult(ServiceStatus.ERROR_NOT_IMPLEMENTED);
    }

    @Override
    public ServiceResult getOwnerCopies(String owner) {
        // TODO Auto-generated method stub
        return new ServiceResult(ServiceStatus.ERROR_NOT_IMPLEMENTED);
    }

}
