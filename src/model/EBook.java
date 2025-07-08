package model;

import service.MailService;

public class EBook extends Book{
    private String fileType;

    public EBook(String ISBN, String title, int publishedYear, double price, String fileType) {
        super(ISBN, title, publishedYear, price);
        setFileType(fileType);
    }

    public void setFileType(String fileType) {
        if (fileType == null || fileType.trim().isEmpty()) {
            throw new RuntimeException("fileType cannot be empty.");
        }
        this.fileType = fileType.trim();
    }

    public String getFileType() {
        return fileType;
    }

    @Override
    public boolean isBuyable() {
        return true;
    }

    @Override
    public void handleBuying(Order order) {

        // customer can buy multiple EBook
        double amount = order.getQuantity() * order.getBook().getPrice();
        System.out.println("Total Amount = " + amount);

        // send to Email ...
        MailService.send(order);
    }
}
