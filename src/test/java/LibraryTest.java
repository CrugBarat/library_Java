import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LibraryTest {

    private Library library;
    private Book book1, book2;

    @Before
    public void before() {
        library = new Library(5);
        book1 = new Book("Mort", "Terry Pratchett", "Comic Fantasy");
        book2 = new Book("Wizard and Glass", "Stephen King", "Fantasy");
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

}
