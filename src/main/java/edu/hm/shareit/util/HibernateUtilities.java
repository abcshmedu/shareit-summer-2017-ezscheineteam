package edu.hm.shareit.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Class to create a sessionFactory for hibernate.
 */
public final class HibernateUtilities {
    private static SessionFactory sessionFactory;

    /**
     * Can't create an instance of this class.
     */
    private HibernateUtilities() { }

    static {
        try {
            sessionFactory = new Configuration().configure().buildSessionFactory();
        } catch (Throwable ex) {
            throw new ExceptionInInitializerError(ex);
        }
    }

    /**
     * Returns the Session-Factory instance.
     * @return SessionFactory instance
     */
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
