package domain;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Loan {
    private final long bookId;
    private final long personId;
    private final Date loanedAt;

    public Loan(long bookId, long personId, Date loanedAt) {
        this.bookId = bookId;
        this.personId = personId;
        this.loanedAt = loanedAt;
    }

    public long getBookId() {
        return bookId;
    }

    public long getPersonId() {
        return personId;
    }

    public Date getLoanedAt() {
        return loanedAt;
    }
}
