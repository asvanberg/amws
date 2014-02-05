package service;

import org.glassfish.jersey.jackson.JacksonFeature;

import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;

public abstract class AbstractRemoteService {
    protected WebTarget api() {
        return ClientBuilder.newClient()
                .register(JacksonFeature.class)
                .target("http://localhost:8081");
    }
}
