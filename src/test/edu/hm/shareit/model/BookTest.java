package edu.hm.shareit.model;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.xml.internal.ws.policy.AssertionSet;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class BookTest {
    @Test
    public void serialize() throws JsonProcessingException {
        ObjectMapper m = new ObjectMapper();
        m.enableDefaultTyping();
        String toParse = "{\"title\":\"title\", \"author\": \"author\", \"isbn\": \"12314\"}";
        Book b = new Book("title", "author", "12314");
        String result = m.writeValueAsString(b);
        assertEquals(toParse, result);
    }
    static String jsonInput = "{\"title\":\"Buch\", \"author\": \"Author\", \"isbn\": \"1231231\"}";
    @Test
    public void deserialize1() throws IOException {
        ObjectMapper m = new ObjectMapper();
        Medium b = m.readValue(jsonInput, Medium.class);
        assertNotEquals(null, b);
    }
}