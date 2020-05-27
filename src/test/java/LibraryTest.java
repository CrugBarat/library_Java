import org.junit.Before;
import org.junit.Test;

import java.text.ParseException;

import static org.junit.Assert.assertEquals;

public class LibraryTest {

    private Library library;
    private Book book1, book2;
    private Borrower borrower;

    @Before
    public void before() {
        library = new Library(5);
        book1 = new Book("Mort", "Terry Pratchett", "Comic Fantasy", "");
        book2 = new Book("Wizard and Glass", "Stephen King", "Fantasy", "");
        borrower = new Borrower("Jane Doe");
    }

    @Test
    public void hasNoBooks() {
        assertEquals(0, library.getBooks());
    }

    @Test
    public void canAddBook() {
        library.addBook(book1);
        assertEquals(1, library.getBooks());
    }

    @Test
    public void hasCapacity() {
        assertEquals(5, library.getCapacity());
    }

    @Test
    public void overCapacity() {
        library = new Library(1);
        library.addBook(book2);
        assertEquals(1, library.getBooks());
    }

    @Test
    public void canRemoveBook() {
        library.addBook(book1);
        library.addBook(book2);
        library.removeBook(book2);
        assertEquals(1, library.getBooks());
    }

    @Test
    public void canLendBook() {
        library.addBook(book1);
        library.addBook(book2);
        library.lendBook(book1, borrower, "11/07/2020");
        assertEquals(1, library.getBooks());
    }

    @Test
    public void loanedBookDueDateSet() {
        library.addBook(book1);
        library.addBook(book2);
        library.lendBook(book1, borrower, "11/07/2020");
        assertEquals("11/07/2020", book1.getDueDate());
    }

    @Test
    public void genreCountHashStartsAtZero() {
        assertEquals(0, library.getGenreCountSize());
    }

    @Test
    public void canAddGenre() {
        library.addGenre(book1, 1);
        assertEquals(1, library.getGenreCountSize());
    }

    @Test
    public void canGetGenreValue() {
        library.addGenre(book1, 10);
        assertEquals(10, library.getGenreValue(book1));
    }

    @Test
    public void canCountGenre() {
        library.incrementGenreValue(book1);
        library.incrementGenreValue(book2);
        library.incrementGenreValue(book1);
        assertEquals(2, library.getGenreValue(book1));
    }

    @Test
    public void canReceiveReturnedBook() {
        library.addBook(book1);
        library.lendBook(book1, borrower, "23/05/2020");
        borrower.returnBook(book1, library);
        assertEquals(1, library.getBooks());
    }

    @Test
    public void returnedBookDueDateReset() {
        library.addBook(book1);
        library.lendBook(book1, borrower, "23/05/2020");
        borrower.returnBook(book1, library);
        assertEquals("", book1.getDueDate());
    }

    @Test
    public void overdueBooksStartsAtZero() {
        assertEquals(0, library.getOverdueBooksSize());
    }

    @Test
    public void getParsedCurrentDate() {
        assertEquals("27/05/2020", library.parseCurrentDate());
    }

    @Test
    public void canGetOverdueBooksT1() {
        book1 = new Book("Mort", "Terry Pratchett", "Comic Fantasy", "11/05/2020");
        book2 = new Book("Wizard and Glass", "Stephen King", "Fantasy", "18/05/2020");
        library.addBook(book1);
        library.addBook(book2);
        library.getOverdueBooks();
        assertEquals(2, library.getOverdueBooksSize());
    }

    @Test
    public void canGetOverdueBooksT2() {
        book1 = new Book("Mort", "Terry Pratchett", "Comic Fantasy", "11/05/2020");
        book2 = new Book("Wizard and Glass", "Stephen King", "Fantasy", "31/05/2020");
        library.addBook(book1);
        library.addBook(book2);
        library.getOverdueBooks();
        assertEquals(1, library.getOverdueBooksSize());
    }

}
