package com.scanales.openshift;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.eclipse.microprofile.config.inject.ConfigProperty;

@ApplicationScoped
public class EventService {

    @Inject
    @RestClient
    OpenShiftClient openShiftClient;

    @ConfigProperty(name = "openshift.api.url")
    String apiUrl;

    @ConfigProperty(name = "openshift.api.token")
    String apiToken;

    public String fetchEvents(String namespace) {
        String token = "Bearer " + apiToken;
        return openShiftClient.getNamespaceEvents(token, namespace);
    }
}
