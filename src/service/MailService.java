package service;

import model.*;

public class MailService {
    public static void send(Order order) {
        System.out.println("Book is sent via Email to " + order.getEmail());
    }
}
