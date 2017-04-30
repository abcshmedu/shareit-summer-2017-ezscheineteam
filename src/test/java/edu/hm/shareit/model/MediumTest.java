package edu.hm.shareit.model;

import static org.junit.Assert.*;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class MediumTest {

    @Rule
    public final ExpectedException exception = ExpectedException.none();

    @Test
    public void simpleTest() {
        Medium m = new Medium("BeispielMedium");
        assertEquals("Test ob Titel gespeichert wurde", m.getTitle(), "BeispielMedium");
    }

    @Test
    public void nullMediumTitleTest() {
        exception.expect(IllegalArgumentException.class);
        Medium m = new Medium(null);
    }

    @Test
    public void equalsTest() {
        Medium root = new Medium("root");
        assertFalse(root.equals(new Object()));
        assertFalse(root.equals(5));
        assertFalse(root.equals("bamboo"));
        assertFalse(root.equals(new Medium("otherMedium")));
        assertFalse(root.equals(false));
        assertFalse(root.equals(null));
        assertTrue(root.equals(new Medium("root")));
        assertTrue(root.equals(root));
    }

    @Test
    public void hashTest() {
        Medium m1 = new Medium("Medium");
        Medium m2 = new Medium("Medium");
        Medium m3 = new Medium("Another");
        assertEquals(m1.hashCode(), m2.hashCode());
        assertNotEquals(m1.hashCode(), m3.hashCode());
        assertNotEquals(m2.hashCode(), m3.hashCode());
    }

    @Test
    public void toStringTest() {
        Medium m = new Medium("MediumUnderTest");
        assertEquals(m.toString(), "Medium{title='MediumUnderTest'}");
    }

}
