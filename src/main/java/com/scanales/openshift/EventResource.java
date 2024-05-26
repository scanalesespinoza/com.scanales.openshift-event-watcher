package com.scanales.openshift;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/events")
public class EventResource {

    @Inject
    EventService eventService;

    @GET
    @Path("/{namespace}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getEvents(@PathParam("namespace") String namespace) {
        return eventService.fetchEvents(namespace);
    }
}
