package edu.hm.shareit.business;

import edu.hm.shareit.model.Copy;

/**
 * Stub für den Service: Anlegen von Exemplaren.
 */
public class CopyServiceImplStub implements CopyService {
    
    @Override
    public CopyServiceStatus addBook(Copy copy) {
        // TODO Auto-generated method stub
        return CopyServiceStatus.ERROR_NOT_IMPLEMENTED;
    }

    @Override
    public CopyServiceStatus addDisc(Copy copy) {
        // TODO Auto-generated method stub
        return CopyServiceStatus.ERROR_NOT_IMPLEMENTED;
    }

    @Override
    public CopyServiceResult getBooks(String user) {
        // TODO Auto-generated method stub
        return new CopyServiceResult(CopyServiceStatus.ERROR_NOT_IMPLEMENTED);
    }

    @Override
    public CopyServiceResult getDiscs(String user) {
        // TODO Auto-generated method stub
        return new CopyServiceResult(CopyServiceStatus.ERROR_NOT_IMPLEMENTED);
    }

}
