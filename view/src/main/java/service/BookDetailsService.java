package service;

import domain.BookDetails;
import domain.LoanDetails;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;
import java.util.stream.Collectors;

public class BookDetailsService {
    private final BookService bookService;
    private final PersonService personService;
    private final LoanService loanService;

    public BookDetailsService(BookService bookService, PersonService personService, LoanService loanService) {
        this.bookService = bookService;
        this.personService = personService;
        this.loanService = loanService;
    }

    public Future<BookDetails> getDetails(long bookId) {
        long start = System.nanoTime();
        CompletableFuture<List<LoanDetails>> loanDetails = CompletableFuture.supplyAsync(() -> loanService.get(bookId))
                .thenApply(loans -> loans
                        .parallelStream()
                        .map(loan -> new LoanDetails(loan, personService.get(loan.getPersonId())))
                        .collect(Collectors.toList())
                );
        CompletableFuture<BookDetails> bookDetails = CompletableFuture.supplyAsync(() -> bookService.get(bookId))
                .thenCombine(loanDetails, BookDetails::new);
        long end = System.nanoTime();
        System.out.printf("Futures: %s%n", (end - start) / 1e9);
        return bookDetails;
    }
}
