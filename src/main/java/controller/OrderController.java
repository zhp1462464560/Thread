package controller;

import service.OrderServcie;

public class OrderController {

    public static void main(String[] args) {

        OrderServcie orderServcie = new OrderServcie();
        try {
            orderServcie.test();
        } catch (Exception e) {

        }
    }
}
