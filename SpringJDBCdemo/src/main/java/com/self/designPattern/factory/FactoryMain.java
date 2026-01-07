package com.self.designPattern.factory;

import factory.service.PaymentService;

public class FactoryMain {
    public static void main(String[] args) {
        PaymentService service = new PaymentService();
        service.makePayment("CARD", 1000);
        service.makePayment("UPI", 500);
    }
}