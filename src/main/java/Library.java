import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

public class Library {

    private ArrayList<Book> books;
    private int capacity;
    private HashMap<String, Integer> genreCount;
    private ArrayList<Book> loanedBooks;
    private ArrayList<Book> overdueBooks;

    public Library(int capacity){
        this.books = new ArrayList<Book>();
        this.capacity = capacity;
        this.genreCount = new HashMap<String, Integer>();
        this.loanedBooks = new ArrayList<Book>();
        this.overdueBooks = new ArrayList<Book>();
    }

    public int getBooks() {
        return this.books.size();
    }

    public int getCapacity() {
        return this.capacity;
    }

    public int getLoanedBookSize() {
        return this.loanedBooks.size();
    }

    public int getGenreCountSize() {
        return this.genreCount.size();
    }

    public int getGenreValue(Book book) {
        return this.genreCount.get(book.getGenre());
    }

    public int getOverdueBooksSize() {
        return this.overdueBooks.size();
    }

    public void addBook(Book book) {
        if(getBooks() < this.capacity)
        this.books.add(book);
    }

    public void addBookToLoaned(Book book) {
        this.loanedBooks.add(book);
    }

    public void addGenre(Book book, Integer value) {
        this.genreCount.put(book.getGenre(), value);
    }

    public void removeBook(Book book) {
        int index = this.books.indexOf(book);
        this.books.remove(index);
    }

    public void removeFromLoaned(Book book) {
        int index = this.loanedBooks.indexOf(book);
        this.loanedBooks.remove(index);
    }

    public void lendBook(Book book, Borrower borrower, String date) {
        book.setDueDate(date);
        borrower.addBook(book);
        removeBook(book);
        addBookToLoaned(book);
    }

    public void incrementGenreValue(Book book) {
        if (!this.genreCount.containsKey(book.getGenre())) {
            addGenre(book, 1);
        } else {
            int value = getGenreValue(book) + 1;
            this.genreCount.replace(book.getGenre(), value);
        }
    }

    public String parseCurrentDate() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/YYYY");
        Date date = new Date(System.currentTimeMillis());
        return sdf.format(date);
    }

    public void getOverdueBooks() {
        for (Book book : this.loanedBooks) {
            try {
                if (book.parseDueDate().compareTo(parseCurrentDate()) < 0) {
                    this.overdueBooks.add(book);
                }
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
    }

}
