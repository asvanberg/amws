package service;

import domain.dto.Book;

import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;

public class BookService {
    public Book get(long id) {
        return ClientBuilder.newClient()
                .target("http://localhost:8081")
                .path("book")
                .path(Long.toString(id))
                .request(MediaType.APPLICATION_JSON_TYPE)
                .get(Book.class);
    }
}
