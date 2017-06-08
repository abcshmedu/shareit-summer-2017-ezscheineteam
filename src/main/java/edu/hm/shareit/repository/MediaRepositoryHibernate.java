package edu.hm.shareit.repository;

import java.util.List;

import javax.inject.Inject;

import org.hibernate.Session;
import org.hibernate.Transaction;

import edu.hm.shareit.model.Book;
import edu.hm.shareit.model.Disc;

/**
 * La real repository.
 */
public class MediaRepositoryHibernate implements MediaRepository {

    private final Session entityMananger;
    
    /**
     * Erzeugt ein neues MediaRepositoryHibernate Objekt.
     * @param entityMananger Entity Mananger welcher verwendet werden soll.
     */
    @Inject
    public MediaRepositoryHibernate(Session entityMananger) {
        this.entityMananger = entityMananger;
    }
    
    @Override
    public List<Book> findAllBooks() {
        Transaction transaction = entityMananger.beginTransaction();
        transaction.commit();
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Disc> findAllDiscs() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Book findBook(String isbn) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Disc findDisc(String barcode) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean createBook(Book b) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean createDisc(Disc disc) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean updateBook(Book book) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean updateDisc(Disc disc) {
        // TODO Auto-generated method stub
        return false;
    }

}
