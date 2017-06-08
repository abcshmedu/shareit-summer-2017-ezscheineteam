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
}
