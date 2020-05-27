import java.util.ArrayList;
import java.util.HashMap;

public class Library {

    private ArrayList<Book> books;
    private int capacity;
    private HashMap<String, Integer> genreCount;
    private ArrayList<Book> overdueBooks;

    public Library(int capacity){
        this.books = new ArrayList<Book>();
        this.capacity = capacity;
        this.genreCount = new HashMap<String, Integer>();
        this.overdueBooks = new ArrayList<Book>();
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

    public void lendBook(Book book, Borrower borrower, String date) {
        borrower.addBook(book);
        removeBook(book);
        book.setDueDate(date);
    }

    public int getGenreCountSize() {
        return this.genreCount.size();
    }

    public void addGenre(Book book, Integer value) {
        this.genreCount.put(book.getGenre(), value);
    }

    public int getGenreValue(Book book) {
        return this.genreCount.get(book.getGenre());
    }

    public void incrementGenreValue(Book book) {
        if (!this.genreCount.containsKey(book.getGenre())) {
            addGenre(book, 1);
        } else {
            int value = getGenreValue(book) + 1;
            this.genreCount.replace(book.getGenre(), value);
        }
    }

    public int getOverdueBooks() {
        return this.overdueBooks.size();
    }
}
