package code;

import code.model.Author;
import code.model.Book;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class BookTest {
    @Test
    public void createBookFromArrayBigName() {
        ArrayList<String> arr = new ArrayList<>(Arrays.asList(
                "4", "The", "Great", "Gatsby", "1925", "F. Scott Fitzgerald", "tragedy"));
        Book expectedBook = new Book(4, "The Great Gatsby",
                1925, new Author("F. Scott", "Fitzgerald"), "tragedy");
        Book actualBook = Book.convertArrayToBook(arr);
        assertThat(actualBook.toString()).isEqualTo(expectedBook.toString());
    }

    @Test
    public void createBookFromArray() {
        ArrayList<String> arr = new ArrayList<>(Arrays.asList(
                "1", "Anna", "Karenina", "1887", "Leo Tolstoy", "novel"));
        Book expectedBook = new Book(1, "Anna Karenina",
                1887, new Author("Leo", "Tolstoy"), "novel");
        Book actualBook = Book.convertArrayToBook(arr);
        assertThat(actualBook.toString()).isEqualTo(expectedBook.toString());
    }

}
