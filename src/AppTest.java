import model.*;
import service.BuyService;

public class AppTest {
    public static void addBookToInventoryTest(){
        System.out.println("Adding new book to inventory");
        try{
            Inventory inventory = new Inventory();

            // Add Paper Book
            Book b1 = new PaperBook("1111", "paperBook", 2022, 50, 10);
            // Add EBook
            Book b2 = new EBook("1112", "EBook", 2022, 50, "pdf");
            // Add Demo Book
            Book b3 = new DemoBook("1113", "DemoBook", 2022, 0);

            inventory.addBook(b1);
            inventory.addBook(b2);
            inventory.addBook(b3);

            for(Book book : inventory.getBooks()){
                System.out.println("i added this book " + book.getTitle());
            }

        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public static void removeBookFromInventoryTest(){
        System.out.println("Removing book from inventory");
        try{
            Inventory inventory = new Inventory();

            // Add Paper Book
            Book b1 = new PaperBook("1111", "paperBook", 2022, 50, 10);
            // Add EBook
            Book b2 = new EBook("1112", "EBook", 2022, 50, "pdf");
            // Add Demo Book
            Book b3 = new DemoBook("1113", "DemoBook", 2022, 0);

            inventory.addBook(b1);
            inventory.addBook(b2);
            inventory.addBook(b3);
            System.out.println("Add 3 books to Inventory");

            inventory.removeBook(b1);

            System.out.println("after remove now number of books is = " + inventory.getBooks().size() + " (Expected -> 2)");

        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public static void removeOutdatedBookFromInventoryTest(){
        System.out.println("Removing outdated book from inventory");
        try{
            Inventory inventory = new Inventory();

            // Add Paper Book
            Book b1 = new PaperBook("1111", "paperBook", 2024, 50, 10);
            // Add EBook
            Book b2 = new EBook("1112", "EBook", 2023, 50, "pdf");
            // Add Demo Book
            Book b3 = new DemoBook("1113", "DemoBook", 2022, 0);

            inventory.addBook(b1);
            inventory.addBook(b2);
            inventory.addBook(b3);
            System.out.println("Add 3 books to Inventory");

            // any book before 2024 will remove (2025 - 2 = 2023)
            inventory.removeOutdatedBooks(2);

            System.out.println("books in inventory (must not showing DemoBook and EBook)");
            for(Book book : inventory.getBooks()){
                System.out.println("i added this book " + book.getTitle());
            }

        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }


    public static void buyTest(){
        System.out.println("buy test");
        try{
            Inventory inventory = new Inventory();

            // Add Paper Book
            Book b1 = new PaperBook("1111", "paperBook", 2022, 50, 10);
            // Add EBook
            Book b2 = new EBook("1112", "EBook", 2022, 50, "pdf");
            // Add Demo Book
            Book b3 = new DemoBook("1113", "DemoBook", 2022, 0);

            inventory.addBook(b1);
            inventory.addBook(b2);
            inventory.addBook(b3);

            // order book 1111
            Order order = new Order(b1, 5, "omargoher59@gmail.com", "Egypt-Cairo");

            BuyService.buy(order);

        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
