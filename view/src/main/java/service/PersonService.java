package service;

import domain.dto.Person;

import javax.ws.rs.core.MediaType;

public class PersonService extends AbstractRemoteService {
    public Person get(long id) {
        return api()
                .path("person")
                .path(Long.toString(id))
                .request(MediaType.APPLICATION_JSON_TYPE)
                .get(Person.class);
    }
}
