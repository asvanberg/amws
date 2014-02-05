package service;

import domain.dto.Loan;

import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import java.util.List;

public class LoanService {
    public List<Loan> get(long bookId) {
        return ClientBuilder.newClient()
                .target("http://localhost:8081")
                .path("loan")
                .path(Long.toString(bookId))
                .request(MediaType.APPLICATION_JSON_TYPE)
                .get(new GenericType<List<Loan>>(){});
    }
}
