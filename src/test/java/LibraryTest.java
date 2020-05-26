import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LibraryTest {

    private Library library;
    private Book book1, book2;
    private Borrower borrower;

    @Before
    public void before() {
        library = new Library(5);
        book1 = new Book("Mort", "Terry Pratchett", "Comic Fantasy");
        book2 = new Book("Wizard and Glass", "Stephen King", "Fantasy");
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
        library.lendBook(book1, borrower);
        assertEquals(1, library.getBooks());
    }

    @Test
    public void borrowerGetsBook() {
        library.addBook(book1);
        library.addBook(book2);
        library.lendBook(book1, borrower);
        assertEquals(1, borrower.getCollection());
    }



}
