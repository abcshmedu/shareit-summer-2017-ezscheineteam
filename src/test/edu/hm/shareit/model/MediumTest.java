package edu.hm.shareit.model;

import static org.junit.Assert.*;

import org.junit.Test;

public class MediumTest {
    
    @Test
    public void simpleTest(){
        Medium m = new Medium("BeispielMedium");
        assertEquals("Test ob Titel gespeichert wurde", m.getTitle(), "BeispielMedium");
    }
    
    
}
