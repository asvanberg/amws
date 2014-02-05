package domain;

import domain.dto.Book;

import java.util.Collection;

public class BookDetails {
    private final Book book;
    private final Collection<LoanDetails> loans;

    public BookDetails(Book book, Collection<LoanDetails> loans) {
        this.book = book;
        this.loans = loans;
    }

    @Override
    public String toString() {
        return "BookDetails{" +
                "book=" + book +
                ", loans=" + loans +
                '}';
    }
}
