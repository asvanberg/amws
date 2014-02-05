package domain.dto;

import java.util.Date;

public class Loan {
    public long bookId;
    public long personId;
    public Date loanedAt;

    public long getPersonId() {
        return personId;
    }

    @Override
    public String toString() {
        return "Loan{" +
                "bookId=" + bookId +
                ", personId=" + personId +
                ", loanedAt=" + loanedAt +
                '}';
    }
}
