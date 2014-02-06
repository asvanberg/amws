package service;

import org.glassfish.jersey.jackson.JacksonFeature;

import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;

public abstract class AbstractRemoteService {

    private static final WebTarget TARGET = ClientBuilder.newClient()
            .register(JacksonFeature.class)
            .target("http://localhost:8081");

    protected WebTarget api() {
        return TARGET;
    }
}
