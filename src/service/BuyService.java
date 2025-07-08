package service;

import model.Order;

public class BuyService {
    public static void buy(Order order) {
        order.getBook().handleBuying(order);
    }
}
