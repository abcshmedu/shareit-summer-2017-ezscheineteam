package edu.hm.shareit.model;

import static org.junit.Assert.assertEquals;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

/**
 * Tests fuer die Klasse Copy.
 *
 */
public class CopyTest {

    @Rule
    public final ExpectedException exception = ExpectedException.none();

    /**
     * Simpler Test, der den Standardfall mit validen Konstruktorparametern
     * testet.
     */
    @Test
    public void simpleTest() {
        Copy c = new Copy("Max Mustermann", new Medium("Medium Titel"), 1);
        assertEquals("Max Mustermann", c.getOwner());
        assertEquals("Medium Titel", c.getMedium().getTitle());
        assertEquals(1, c.getQuantity());
    }

    /**
     * Test wo die Copy, die dem Konstruktor uebergeben wird, null ist. Erwartet
     * wird die IllegalArgumentException.
     */
    @Test
    public void ownerNullTest() {
        // expect exception as input parameter null
        exception.expect(IllegalArgumentException.class);
        Copy c = new Copy(null, new Medium("Medium Title"), 1);
    }

    /**
     * Test wo das Medium, das dem Konstruktor uebergeben wird, null ist.
     * Erwartet wird die IllegalArgumentException.
     */
    @Test
    public void mediumNullTest() {
        // expect exception as input parameter null
        exception.expect(IllegalArgumentException.class);
        Copy c = new Copy("Max Mustermann", null, 1);
    }

    /**
     * Test wo Quantity, das dem Konstruktor uebergeben wird, 0 ist.
     * Erwartet wird die IllegalArgumentException.
     */
    @Test
    public void quantityNullTest() {
        // expect exception as input parameter null
        exception.expect(IllegalArgumentException.class);
        Copy c = new Copy("Max Mustermann", new Medium("Medium Title"), 0);
    }
}
