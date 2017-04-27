package edu.hm.shareit.business;

import edu.hm.shareit.model.Book;
import edu.hm.shareit.model.Disc;
import edu.hm.shareit.model.Medium;

public interface CopyService {
  
    CopyServiceResult addBook(Book book, String user);
    
  
    CopyServiceResult addDisc(Disc disc, String user);

  
    Medium[] getBooks(String user);

 
    Medium[] getDiscs(String user);
}
