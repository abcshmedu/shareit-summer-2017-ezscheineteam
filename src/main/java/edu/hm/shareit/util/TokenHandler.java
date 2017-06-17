package edu.hm.shareit.util;

import edu.hm.shareit.model.Token;

/**
 * Interface fuer Klassen welche mit Token umgehen koennen.
 */
public interface TokenHandler {

    /**
     * Ueberprueft ob ein token gueltig ist indem 
     * dieses an den Auth Server gesendet wird.
     * @param token Das Tokem
     * @return Ein Token Objekt falls das token gueltig ist, sonst null.
     */
    Token validateToken(String token);
    
    /**
     * Fragt eine Token-id an fuer einen bestimmten registrierten Benutzer.
     * @param name Name des Benutzers.
     * @param password Passwort des Benutzers.
     * @return Token-id als String oder null falls die Angaben nicht gueltig sind.
     */
    String getToken(String name, String password);
}
