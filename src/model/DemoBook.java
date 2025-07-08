package model;

public class DemoBook extends Book{

    public DemoBook(String ISBN, String title, int publishedYear, double price) {
        super(ISBN, title, publishedYear, price);
    }

    @Override
    public boolean isBuyable() {
        return false;
    }

    @Override
    public void handleBuying(Order order) {
        throw new RuntimeException("Can Not buy demo book .");
    }
}
