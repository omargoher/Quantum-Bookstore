package service;

import model.*;

public class ShippingService {
    public static void ship(Order order) {
        System.out.println("Order is Shipped to " + order.getEmail() + " in " + order.getAddress());
    }
}
