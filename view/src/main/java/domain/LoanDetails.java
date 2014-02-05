package domain;

import domain.dto.Loan;
import domain.dto.Person;

public class LoanDetails {
    private final Loan loan;
    private final Person person;

    public LoanDetails(Loan loan, Person person) {
        this.loan = loan;
        this.person = person;
    }

    @Override
    public String toString() {
        return "LoanDetails{" +
                "loan=" + loan +
                ", person=" + person +
                '}';
    }
}
