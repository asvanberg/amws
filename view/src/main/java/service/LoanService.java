package service;

import domain.dto.Loan;

import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import java.util.List;

public class LoanService extends AbstractRemoteService {
    public List<Loan> get(long bookId) {
        return api()
                .path("loan")
                .path(Long.toString(bookId))
                .request(MediaType.APPLICATION_JSON_TYPE)
                .get(new GenericType<List<Loan>>(){});
    }
}
