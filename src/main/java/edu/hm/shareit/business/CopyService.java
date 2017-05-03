package edu.hm.shareit.business;

import edu.hm.shareit.model.Copy;

/**
 * Interface für den Service: Anlegen von Exemplaren.
 */
public interface CopyService {
  
    ServiceStatus addBook(Copy copy);

    
    ServiceStatus addDisc(Copy copy);


    ServiceResult getBooks(String user);


    ServiceResult getDiscs(String user);
}
