import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BookTest {

    private Book book;

    @Before
    public void before(){
        book = new Book("The Gunslinger", "Stephen King", "Sci-Fi");
    }

    @Test
    public void hasTitle(){
        assertEquals("The Gunslinger", book.getTitle());
    }

    @Test
    public void hasAuthor(){
        assertEquals("Stephen King", book.getAuthor());
    }

}
