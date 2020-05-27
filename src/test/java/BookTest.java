import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BookTest {

    private Book book1, book2;

    @Before
    public void before(){
        book1 = new Book("The Gunslinger", "Stephen King", "Sci-Fi", "31/05/2020");
        book2 = new Book("Wizard and Glass", "Stephen King", "Fantasy", "");
    }

    @Test
    public void hasTitle(){
        assertEquals("The Gunslinger", book1.getTitle());
    }

    @Test
    public void hasAuthor(){
        assertEquals("Stephen King", book1.getAuthor());
    }

    @Test
    public void hasGenre(){
        assertEquals("Sci-Fi", book1.getGenre());
    }

    @Test
    public void hasDueDate(){
        assertEquals("31/05/2020", book1.getDueDate());
    }

    @Test
    public void hasNoDueDate(){
        assertEquals("", book2.getDueDate());
    }

}
