package model;

import service.MailService;
import service.ShippingService;

public class PaperBook extends Book{
    // number of book in this stock
    private int stock;

    public PaperBook(String ISBN, String title, int publishedYear, double price, int stock) {
        super(ISBN, title, publishedYear, price);
        increaseStock(stock);
    }

    public int getStock() {
        return stock;
    }

    public void increaseStock(int stock) {
        if(stock < 0){
            throw new RuntimeException("stock cannot be less than 0.");
        }
        this.stock += stock;
    }

    public void decreaseStock(int stock) {
        if(stock < 0){
            throw new RuntimeException("stock cannot be less than 0.");
        }
        // handle if user enter number > books in stock
        if(stock > this.stock){
            throw new RuntimeException("your input ust be less than stock.");
        }
        this.stock -= stock;
    }

    @Override
    public boolean isBuyable() {
        return true;
    }

    @Override
    public void handleBuying(Order order) {
        // handle if user need buy number > books in stock
        if(order.getQuantity() >= stock) {
            throw new RuntimeException("this number of books not in stock");
        }

        // Reduces the quantity of the book from the inventory
        stock = stock - order.getQuantity();
        double amount = order.getQuantity() * order.getBook().getPrice();
        System.out.println("Total Amount = " + amount);
        // Shipping ....
        ShippingService.ship(order);
    }
}
