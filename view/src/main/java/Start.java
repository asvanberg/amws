import domain.BookDetails;
import service.BookDetailsService;
import service.BookService;
import service.LoanService;
import service.PersonService;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class Start {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        BookDetailsService bookDetailsService = new BookDetailsService(new BookService(), new PersonService(), new LoanService());

        long start = System.nanoTime();
        Future<BookDetails> details = bookDetailsService.getDetails(1L);
        BookDetails bookDetails = details.get();
        long end = System.nanoTime();

        System.out.printf("get(): %s%n", (end - start) / 1e9);
        System.out.println(bookDetails);
    }
}
