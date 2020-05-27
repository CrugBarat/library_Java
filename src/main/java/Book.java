import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Book {

    private String title;
    private String author;
    private String genre;
    private String dueDate;

    public Book(String title, String author, String genre, String dueDate) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.dueDate = dueDate;
    }

    public String getTitle() {
        return this.title;
    }

    public String getAuthor() {
        return this.author;
    }

    public String getGenre() {
        return this.genre;
    }

    public String getDueDate() {
        return this.dueDate;
    }

    public void setDueDate(String date) {
        this.dueDate = date;
    }

    public String parseDueDate() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date date = sdf.parse(getDueDate());
        return sdf.format(date);
    }

}
