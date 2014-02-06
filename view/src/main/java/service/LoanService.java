package service;

import domain.dto.Loan;

import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import java.util.List;

public class LoanService extends AbstractRemoteService {
    public List<Loan> get(long bookId) {
        System.out.println("Before loan fetch/parse: " + System.currentTimeMillis() % 10000);
        List<Loan> loans = api()
                .path("loan")
                .path(Long.toString(bookId))
                .request(MediaType.APPLICATION_JSON_TYPE)
                .get(new GenericType<List<Loan>>(){});
        System.out.println("After loan fetch/parse: " + System.currentTimeMillis() % 10000);
        return loans;
    }
}
