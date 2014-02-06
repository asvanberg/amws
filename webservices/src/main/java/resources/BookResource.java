package resources;

import domain.Book;
import domain.Person;

import javax.ws.rs.*;
import java.util.HashMap;
import java.util.Map;

@Path("/book")
@Produces("application/json")
public class BookResource {

    public static final long BOOK_DELAY = 0;

    public static final Map<Long, Book> BOOKS = new HashMap<Long, Book>() {
        {
            put(1L, new Book("Microsoft and why we win", 2010, new Person("Bill", "Gates")));
            put(2L, new Book("Apple and my followers", 2010, new Person("Steve", "Jobs")));
            put(3L, new Book("Use Linux or you're stupid", 2010, new Person("Linus", "Torvalds")));
        }
    };

    @GET
    @Path("/{id}")
    public Book read(@PathParam("id") long id) throws Exception {
        Thread.sleep(BOOK_DELAY);
        if (BOOKS.containsKey(id)) {
            return BOOKS.get(id);
        }
        throw new NotFoundException();
    }
}
