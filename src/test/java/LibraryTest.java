import org.junit.Before;

public class LibraryTest {

    private Library library;
    private Book book1, book2

    @Before
    public void before() {
        library = new Library();
        book1 = new Book("Mort", "Terry Pratchett", "Comic Fantasy");
        book2 = new Book("Wizard and Glass", "Stephen King", "Fantasy");
    }

}
