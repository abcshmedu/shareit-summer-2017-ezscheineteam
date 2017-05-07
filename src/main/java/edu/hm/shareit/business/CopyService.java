package edu.hm.shareit.business;

import edu.hm.shareit.model.Copy;

/**
 * Interface für den Service: Anlegen von Exemplaren.
 */
public interface CopyService {
  
    /**
     * Verifiziert das Exemplar und speichert dieses ab.
     * @param copy Das Exemplar.
     * @return Ergebnis durch das Aufrufen.
     */
    ServiceStatus addCopy(Copy copy);

    /**
     * Sucht nach dem Exemplar Buch und aktualisert dieses.
     * @param copy Das Exemplar.
     * @param owner Name des Besitzers.
     * @param isbn Die ISBN des Buches.
     * @return Ergebnis durch das Aufrufen.
     */
    ServiceStatus updateBookCopy(Copy copy, String owner, String isbn);
    
    /**
     * Sucht nach dem Exemplar Disc und aktualisert dieses.
     * @param copy Das Exemplar.
     * @param owner Name des Besitzers.
     * @param barcode Der Barcode der Disc.
     * @return Ergebnis durch das Aufrufen.
     */
    ServiceStatus updateDiscCopy(Copy copy, String owner, String barcode);
    
    /**
     * Sucht nach dem Exemplar Buch und loescht dieses.
     * @param owner Name des Besitzers.
     * @param isbn Die ISBN des Buches.
     * @return Ergebnis durch das Aufrufen.
     */
    ServiceStatus deleteBookCopy(String owner, String isbn);
    
    /**
     * Sucht nach dem Exemplar Disc und loescht dieses.
     * @param owner Name des Besitzers.
     * @param barcode Der Barcode der Disc.
     * @return Ergebnis durch das Aufrufen.
     */
    ServiceStatus deleteDiscCopy(String owner, String barcode);

    /**
     * Gibt alle gespeicherte Exemplare zurueck.
     * @return Ergebnis und Rueckgabe durch das Aufrufen.
     */
    ServiceResult getCopies();
    
    /**
     * Gibt ein bestimmtes Exemplare Buch
     * eines Besitzers zurueck.
     * @param owner Name des Besitzers.
     * @param isbn Die ISBN des Buches.
     * @return Ergebnis und Rueckgabe durch das Aufrufen.
     */
    ServiceResult getBookCopy(String owner, String isbn);
    
    /**
     * Gibt ein bestimmtes Exemplare Disc
     * eines Besitzers zurueck.
     * @param owner Name des Besitzers.
     * @param barcode Der Barcode der Disc.
     * @return Ergebnis und Rueckgabe durch das Aufrufen.
     */
    ServiceResult getDiscCopy(String owner, String barcode);

    /**
     * Gibt alle gespeicherte Exemplare Buch zurueck.
     * @return Ergebnis und Rueckgabe durch das Aufrufen.
     */
    ServiceResult getBookCopies();
    
    /**
     * Gibt alle gespeicherte Exemplare Disc zurueck.
     * @return Ergebnis und Rueckgabe durch das Aufrufen.
     */
    ServiceResult getDiscCopies();
    
    /**
     * Gibt alle gespeicherte Exemplare eines Besitzers zurueck.
     * @param owner Name des Besitzers.
     * @return Ergebnis und Rueckgabe durch das Aufrufen.
     */
    ServiceResult getOwnerCopies(String owner);
    
    
}
