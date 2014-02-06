package service;

import domain.dto.Book;

import javax.ws.rs.core.MediaType;

public class BookService extends AbstractRemoteService {
    public Book get(long id) {
        System.out.println("Before book fetch/parse: " + System.currentTimeMillis() % 10000);
        Book book = api()
                .path("book")
                .path(Long.toString(id))
                .request(MediaType.APPLICATION_JSON_TYPE)
                .get(Book.class);
        System.out.println("After book fetch/parse: " + System.currentTimeMillis() % 10000);
        return book;
    }
}
