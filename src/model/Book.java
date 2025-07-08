package model;

import java.time.Year;

public abstract class Book {
    private String ISBN;
    private String title;
    private int publishedYear;
    private double price;

    public Book(String ISBN, String title, int publishedYear, double price) {
        setISBN(ISBN);
        setTitle(title);
        setPublishedYear(publishedYear);
        setPrice(price);
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        if (ISBN == null || ISBN.trim().isEmpty()) {
            throw new RuntimeException("ISBN cannot be empty.");
        }
        this.ISBN = ISBN.trim();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        if (title == null || title.trim().isEmpty()) {
            throw new RuntimeException("title cannot be empty.");
        }
        this.title = title.trim();
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        if(price < 0){
            throw new RuntimeException(" Price cannot be less than 0.");
        }
        // handle if book is not Buyable
        if(!isBuyable() && price > 0){
            throw new RuntimeException("you can not create price to not Buyable book.");
        }
        this.price = price;
    }

    public int getPublishedYear() {
        return publishedYear;
    }

    public void setPublishedYear(int publishedYear) {
        if(publishedYear < 0){
            throw new RuntimeException("published Year cannot be less than 0.");
        }
        if(publishedYear > Year.now().getValue()){
            throw new RuntimeException("published Year cannot be greater than current year.");
        }
        this.publishedYear = publishedYear;
    }

    public abstract boolean isBuyable();

    public abstract void handleBuying(Order order);
}
