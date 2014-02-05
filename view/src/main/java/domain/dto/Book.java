package domain.dto;

public class Book {
    public String title;
    public int year;
    public Person author;

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", year=" + year +
                ", author=" + author +
                '}';
    }
}
