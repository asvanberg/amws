package service;

import domain.dto.Person;

import javax.ws.rs.core.MediaType;

public class PersonService extends AbstractRemoteService {
    public Person get(long id) {
        System.out.println("Before person fetch/parse: " + System.currentTimeMillis() % 10000);
        Person person = api()
                .path("person")
                .path(Long.toString(id))
                .request(MediaType.APPLICATION_JSON_TYPE)
                .get(Person.class);
        System.out.println("After person fetch/parse: " + System.currentTimeMillis() % 10000);
        return person;
    }
}
