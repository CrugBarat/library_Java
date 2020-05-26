import java.util.ArrayList;
import java.util.HashMap;

public class Library {

    private ArrayList<Book> books;
    private int capacity;
    private HashMap<String, Integer> genreCount;

    public Library(int capacity){
        this.books = new ArrayList<Book>();
        this.capacity = capacity;
        this.genreCount = new HashMap<String, Integer>();
    }

    public int getBooks() {
        return this.books.size();
    }

    public void addBook(Book book) {
        if(getBooks() < this.capacity)
        this.books.add(book);
    }

    public int getCapacity() {
        return this.capacity;
    }

    public void removeBook(Book book) {
        int index = this.books.indexOf(book);
        this.books.remove(index);
    }

    public void lendBook(Book book, Borrower borrower) {
        borrower.addBook(book);
        removeBook(book);
    }


    public int getGenreCount() {
        return this.genreCount.size();
    }

    public void addGenre(Book book, Integer value) {
        this.genreCount.put(book.getGenre(), value);
    }
}
