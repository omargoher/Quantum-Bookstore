package model;

import java.time.Year;
import java.util.*;

public class Inventory {
    private List<Book> books = new ArrayList<>();

    public List<Book> getBooks() {
        return books;
    }
    public void addBook(Book book){
        if(books == null){
            throw new RuntimeException("can not add null book");
        }
        // handle if book already exists
        for (Book item : books) {
            if (item.equals(book)) {
                throw new RuntimeException("book already exists");
            }
        }
        books.add(book);
    }

    public void removeBook(Book book){
        if(books == null){
            throw new RuntimeException("can not remove null book");
        }
        books.remove(book);
    }

    public void removeOutdatedBooks(int year){
        if(year <= 0){
            throw new RuntimeException("year must be greater than 0");
        }
        int currentYear = Year.now().getValue();
        for (int i = books.size() - 1; i >= 0; i--) {
            Book book = books.get(i);
            // difference between current year and publishedYear
            int diff = currentYear - book.getPublishedYear();
            if (diff >= year) {
                books.remove(i);
            }
        }
    }
}
