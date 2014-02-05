package service;

import domain.dto.Book;

import javax.ws.rs.core.MediaType;

public class BookService extends AbstractRemoteService {
    public Book get(long id) {
        return api()
                .path("book")
                .path(Long.toString(id))
                .request(MediaType.APPLICATION_JSON_TYPE)
                .get(Book.class);
    }
}
