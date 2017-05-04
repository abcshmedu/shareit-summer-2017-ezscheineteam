package edu.hm.shareit.resource;

import static org.junit.Assert.assertEquals;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.junit.Test;

import edu.hm.shareit.client.CopyClient;

public class MediaResourceTest {

    @Test
    public void getBookTest() {
        CopyClient client = new CopyClient();
        Response response = client.getBook("HANZ", "123456789");
        assertEquals(Status.NOT_FOUND.getStatusCode(), response.getStatus());
    }
}
