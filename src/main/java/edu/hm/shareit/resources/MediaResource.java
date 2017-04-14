package edu.hm.shareit.resources;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.hm.shareit.model.Medium;
import edu.hm.shareit.repository.MediaRepository;
import edu.hm.shareit.repository.MediaRepositoryStub;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("media")
public class MediaResource {
    private MediaRepository activityRepository = new MediaRepositoryStub();

    /**
     * Gibt das Buch zur passenden ISBN zurück.
     * @param isbn ISBN Nummer des Buches.
     * @return Response mit Buchinformationen.
     */
    @GET
    @Produces(MediaType.APPLICATION_XML)
    public List<Medium> getAllActivities() {
        ObjectMapper mapper = new ObjectMapper();
        return activityRepository.findAllMedia();
    }
}
