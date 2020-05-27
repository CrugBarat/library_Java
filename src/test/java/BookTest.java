import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BookTest {

    private Book book;

    @Before
    public void before(){
        book = new Book("The Gunslinger", "Stephen King", "Sci-Fi", "31/05/2020");
    }

    @Test
    public void hasTitle(){
        assertEquals("The Gunslinger", book.getTitle());
    }

    @Test
    public void hasAuthor(){
        assertEquals("Stephen King", book.getAuthor());
    }

    @Test
    public void hasGenre(){
        assertEquals("Sci-Fi", book.getGenre());
    }

    @Test
    public void hasDueDate(){
        assertEquals("31/05/2020", book.getDueDate());
    }

}
