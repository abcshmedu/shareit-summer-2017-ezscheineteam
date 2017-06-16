package edu.hm.shareit.repository;

import edu.hm.shareit.model.Book;
import edu.hm.shareit.model.Disc;
import edu.hm.shareit.util.HibernateUtilities;
import edu.hm.shareit.util.MediumUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import javax.inject.Inject;
import java.util.List;

/**
 * La real repository.
 */
public class MediaRepositoryHibernate implements MediaRepository {
    /**
     * Erzeugt ein neues MediaRepositoryHibernate Objekt.
     */
    @Inject
    public MediaRepositoryHibernate() {
    }

    @Override
    public List<Book> findAllBooks() {
        List<Book> books = null;
        Transaction tx = null;
        try (Session session = HibernateUtilities.getSessionFactory().openSession()) {
            tx = session.beginTransaction();
            Query query = session.createQuery("from Book");
            books = query.list();
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        }
        return books;
    }

    @Override
    public List<Disc> findAllDiscs() {
        List<Disc> discs = null;
        Transaction tx = null;
        try (Session session = HibernateUtilities.getSessionFactory().openSession()) {
            tx = session.beginTransaction();
            Query query = session.createQuery("from Disc");
            discs = query.list();
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        }
        return discs;
    }

    @Override
    public Book findBook(String isbn) {
        Book book = null;
        Transaction tx = null;
        try (Session session = HibernateUtilities.getSessionFactory().openSession()) {
            tx = session.beginTransaction();
            Query query = session.createQuery("from Book where isbn='" + isbn + "'");
            List<Book> books = query.list();
            if (books.size() == 1) {
                book = books.get(0);
            }
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        }

        return book;
    }

    @Override
    public Disc findDisc(String barcode) {
        Disc disc = null;
        Transaction tx = null;
        Session session = HibernateUtilities.getSessionFactory().openSession();
        try {
            tx = session.beginTransaction();
            Query query = session.createQuery("from Disc where barcode='" + barcode + "'");
            List<Disc> discs = query.list();
            if (discs.size() == 1) {
                disc = discs.get(0);
            }
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        }

        return disc;
    }

    @Override
    public boolean createBook(Book book) {
        if (findBook(book.getIsbn()) != null) {
            return false;
        }
        save(book);
        return true;
    }

    /**
     * Saves an object in the database.
     * @param obj to be saved.
     */
    private void save(Object obj) {
        Transaction tx = null;
        Session session = HibernateUtilities.getSessionFactory().openSession();
        try {
            tx = session.beginTransaction();
            session.save(obj);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    @Override
    public boolean createDisc(Disc disc) {
        if (findDisc(disc.getBarcode()) != null) {
            return false;
        }
        save(disc);
        return true;
    }

    @Override
    public boolean updateBook(Book book) {
        Book b = null;
        Transaction tx = null;
        try (Session session = HibernateUtilities.getSessionFactory().openSession()) {
            tx = session.beginTransaction();
            Query query = session.createQuery("from Book where isbn='" + book.getIsbn() + "'");
            List<Book> books = query.list();
            tx.commit();
            tx = session.beginTransaction();
            if (books.size() == 1) {
                b = books.get(0);
            }
            if (b == null) {
                if (MediumUtil.isValidBook(book)) {
                    session.save(book);
                    tx.commit();
                    return true;
                } else {
                    return false;
                }
            } else {
                if (book.getAuthor() != null) {
                    b.setAuthor(book.getAuthor());
                }

                if (book.getTitle() != null) {
                    b.setTitle(book.getTitle());
                }
                tx.commit();
            }
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        }
        return true;
    }

    @Override
    public boolean updateDisc(Disc disc) {
        Disc d = null;
        Transaction tx = null;
        try (Session session = HibernateUtilities.getSessionFactory().openSession()) {
            tx = session.beginTransaction();
            Query query = session.createQuery("from Disc where barcode='" + disc.getBarcode() + "'");
            List<Disc> discs = query.list();
            tx.commit();
            tx = session.beginTransaction();
            if (discs.size() == 1) {
                d = discs.get(0);
            }
            if (d == null) {
                if (MediumUtil.isValidDisc(disc)) {
                    session.save(disc);
                    tx.commit();
                    return true;
                } else {
                    return false;
                }
            } else {
                if (disc.getDirector() != null) {
                    d.setDirector(disc.getDirector());
                }

                if (disc.getTitle() != null) {
                    d.setTitle(disc.getTitle());
                }

                if (disc.getFsk() != -1) {
                    d.setFsk(disc.getFsk());
                }

                tx.commit();
            }
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        }
        return true;
    }
}
