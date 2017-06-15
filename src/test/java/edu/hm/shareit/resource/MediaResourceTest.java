package edu.hm.shareit.resource;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.core.Response;

import org.junit.Test;

import com.fasterxml.jackson.core.JsonProcessingException;

import edu.hm.shareit.business.MediaService;
import edu.hm.shareit.business.ServiceResult;
import edu.hm.shareit.business.ServiceStatus;
import edu.hm.shareit.model.Book;
import edu.hm.shareit.model.Disc;

/**
 * JUnit Testklasse fuer MediaResource.
 */
@SuppressWarnings("JavadocMethod")
public class MediaResourceTest {

    private final MediaService mediaServiceMock = mock(MediaService.class);
    private final MediaResource mediaResource = new MediaResource(mediaServiceMock);
    
    @Test
    public void testNoBooks() throws JsonProcessingException {
        ServiceStatus serviceStatus = ServiceStatus.OK;
        List<Book> books = new ArrayList<Book>();
        ServiceResult serviceResult = new ServiceResult(serviceStatus, books);
        when(mediaServiceMock.getBooks()).thenReturn(serviceResult);
        Response response = mediaResource.getBooks();
        assertEquals(serviceStatus.getStatus(), response.getStatus());
        assertEquals(books, response.getEntity());       
    }
    
    @Test
    public void testNoDiscs() throws JsonProcessingException {
        ServiceStatus serviceStatus = ServiceStatus.OK;
        List<Disc> discs = new ArrayList<Disc>();
        ServiceResult serviceResult = new ServiceResult(serviceStatus, discs);
        when(mediaServiceMock.getDiscs()).thenReturn(serviceResult);
        Response response = mediaResource.getDiscs();
        assertEquals(serviceStatus.getStatus(), response.getStatus());
        assertEquals(discs, response.getEntity());       
    }
    
    @Test
    public void testSomeBooks() throws JsonProcessingException {
        ServiceStatus serviceStatus = ServiceStatus.OK;
        Book bookNum1 = new Book("Bla Bla", "Dr. Bla", "1337133742");
        Book bookNum2 = new Book("Bla Bla2", "Dr. Bla", "1337421337");
        List<Book> books = new ArrayList<Book>();
        books.add(bookNum1);
        books.add(bookNum2);
        ServiceResult serviceResult = new ServiceResult(serviceStatus, books);
        when(mediaServiceMock.getBooks()).thenReturn(serviceResult);
        Response response = mediaResource.getBooks();
        assertEquals(serviceStatus.getStatus(), response.getStatus());
        assertEquals(books, response.getEntity());       
    }
    
    @Test
    public void testSomeDiscs() throws JsonProcessingException {
        ServiceStatus serviceStatus = ServiceStatus.OK;
        Disc discNum1 = new Disc("Wermachtdensowas? Part 1", "0123456789", 0, "Hains Rüdiger");
        Disc discNum2 = new Disc("Wermachtdensowas? Part 2", "0123456789", 0, "Hains Rüdiger");
        List<Disc> discs = new ArrayList<Disc>();
        discs.add(discNum1);
        discs.add(discNum2);
        ServiceResult serviceResult = new ServiceResult(serviceStatus, discs);
        when(mediaServiceMock.getDiscs()).thenReturn(serviceResult);
        Response response = mediaResource.getDiscs();
        assertEquals(serviceStatus.getStatus(), response.getStatus());
        assertEquals(discs, response.getEntity());       
    }

}
