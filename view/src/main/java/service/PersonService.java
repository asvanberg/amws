package service;

import domain.dto.Person;

import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;

public class PersonService {
    public Person get(long id) {
        return ClientBuilder.newClient()
                .target("http://localhost:8081")
                .path("person")
                .path(Long.toString(id))
                .request(MediaType.APPLICATION_JSON_TYPE)
                .get(Person.class);
    }
}
