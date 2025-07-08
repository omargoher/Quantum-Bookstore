public class Main {
    public static void main(String[] args) {
       AppTest.addBookToInventoryTest();
        System.out.println("------------------");
        AppTest.removeBookFromInventoryTest();
        System.out.println("------------------");
        AppTest.removeOutdatedBookFromInventoryTest();
        System.out.println("------------------");
        AppTest.buyTest();
    }
}