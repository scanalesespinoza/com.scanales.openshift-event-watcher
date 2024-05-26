package com.scanales.openshift;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.HeaderParam;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/apis/events.k8s.io/v1") // Ensure this is correct
@RegisterRestClient(configKey="extensions-api")
public interface OpenShiftClient {

    @GET
    @Path("/namespaces/{namespace}/events")
    @Produces(MediaType.APPLICATION_JSON)
    String getNamespaceEvents(@HeaderParam("Authorization") String token, @PathParam("namespace") String namespace);
}
