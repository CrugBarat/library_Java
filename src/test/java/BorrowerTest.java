import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BorrowerTest {

    private Borrower borrower;
    private Library library;
    private Book book1, book2;

    @Before
    public void before() {
        borrower = new Borrower("Jane Doe");
        library = new Library(5);
        book1 = new Book("Mort", "Terry Pratchett", "Comic Fantasy");
        book2 = new Book("Wizard and Glass", "Stephen King", "Fantasy");
    }

    @Test
    public void hasName() {
        assertEquals("Jane Doe", borrower.getName());
    }

    @Test
    public void hasNoBooks() {
        assertEquals(0, borrower.getCollection());
    }

    @Test
    public void canAddBook() {
        borrower.addBook(book1);
        assertEquals(1, borrower.getCollection());
    }

    @Test
    public void canGetBookFromLibrary() {
        library.addBook(book1);
        library.addBook(book2);
        library.lendBook(book1, borrower);
        assertEquals(1, borrower.getCollection());
    }

    @Test
    public void canRemoveBook() {
        library.addBook(book1);
        library.lendBook(book1, borrower);
        borrower.removeBook(book1);
        assertEquals(0, borrower.getCollection());
    }

    @Test
    public void canReturnBookToLibrary() {
        library.addBook(book1);
        library.lendBook(book1, borrower);
        borrower.returnBook(book1, library);
        assertEquals(0, borrower.getCollection());
    }

}
