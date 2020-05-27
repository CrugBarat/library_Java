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
}
