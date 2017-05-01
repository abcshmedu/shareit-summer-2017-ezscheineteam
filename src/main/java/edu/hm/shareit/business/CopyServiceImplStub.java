package edu.hm.shareit.business;

import edu.hm.shareit.model.Copy;

/**
 * Stub f�r den Service: Anlegen von Exemplaren.
 */
public class CopyServiceImplStub implements CopyService {
    
    @Override
    public ServiceStatus addBook(Copy copy) {
        // TODO Auto-generated method stub
        return ServiceStatus.ERROR_NOT_IMPLEMENTED;
    }

    @Override
    public ServiceStatus addDisc(Copy copy) {
        // TODO Auto-generated method stub
        return ServiceStatus.ERROR_NOT_IMPLEMENTED;
    }

    @Override
    public ServiceResult getBooks(String user) {
        // TODO Auto-generated method stub
        return new ServiceResult(ServiceStatus.ERROR_NOT_IMPLEMENTED);
    }

    @Override
    public ServiceResult getDiscs(String user) {
        // TODO Auto-generated method stub
        return new ServiceResult(ServiceStatus.ERROR_NOT_IMPLEMENTED);
    }

}
