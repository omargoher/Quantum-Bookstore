package model;

public class Order {
    private Book book;
    private int quantity;
    private String email;
    private String address;

    public Order(Book book, int quantity, String email, String address) {
        setBook(book);
        setQuantity(quantity);
        setEmail(email);
        setAddress(address);
    }
    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        if (book == null) {
            throw new RuntimeException("book cannot be null.");
        }
        this.book = book;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if (email == null || email.trim().isEmpty()) {
            throw new RuntimeException("email cannot be empty.");
        }
        this.email = email.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        if (address == null || address.trim().isEmpty()) {
            throw new RuntimeException("address cannot be empty.");
        }
        this.address = address.trim();
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        if(quantity < 0){
            throw new RuntimeException("Quantity cannot be less than 0.");
        }
        this.quantity = quantity;
    }
}
