package edu.hm.shareit.business;

import edu.hm.shareit.model.Copy;

/**
 * Interface für den Service: Anlegen von Exemplaren.
 */
public interface CopyService {
  
    CopyServiceStatus addBook(Copy copy);

    
    CopyServiceStatus addDisc(Copy copy);


    CopyServiceResult getBooks(String user);


    CopyServiceResult getDiscs(String user);
}
