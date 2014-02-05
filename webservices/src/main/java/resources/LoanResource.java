package resources;

import domain.Loan;

import javax.ws.rs.*;
import java.util.*;

@Path("/loan")
@Produces("application/json")
public class LoanResource {

    public static final long LOAN_DELAY = 1000L;

    public static final Map<Long, Collection<Loan>> LOANS = new HashMap<Long, Collection<Loan>>() {
        {
            put(1L, Arrays.asList(
                    new Loan(1L, 1L, new Date()),
                    new Loan(1L, 2L, new Date()),
                    new Loan(1L, 3L, new Date())
            ));
            put(2L, Arrays.asList(
                    new Loan(1L, 1L, new Date())
            ));
            put(3L, Arrays.asList(
                    new Loan(1L, 1L, new Date()),
                    new Loan(1L, 2L, new Date())
            ));
        }
    };

    @GET
    @Path("/{id}")
    public Collection<Loan> loans(@PathParam("id") long bookId) throws Exception {
        Thread.sleep(LOAN_DELAY);
        return LOANS.getOrDefault(bookId, Collections.emptyList());
    }
}
