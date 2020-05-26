import org.junit.Before;

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

}
