package resources;

import domain.Person;

import javax.ws.rs.*;
import java.util.HashMap;
import java.util.Map;

@Path("/person")
@Produces("application/json")
public class PersonResource {

    public static final long PERSON_DELAY = 1000L;

    public static final Map<Long, Person> PEOPLE = new HashMap<Long, Person>() {
        {
            put(1L, new Person("Bill", "Gates"));
            put(2L, new Person("Steve", "Jobs"));
            put(3L, new Person("Linus", "Torvalds"));
        }
    };

    @GET
    @Path("/{id}")
    public Person read(@PathParam("id") long id) throws Exception {
        Thread.sleep(PERSON_DELAY);
        if (PEOPLE.containsKey(id)) {
            return PEOPLE.get(id);
        }
        throw new NotFoundException();
    }
}
