package com.self.designpatterns;

import com.self.designpatterns.payment.service.PaymentService;
import com.self.designpatterns.pricing.strategy.DiscountStrategy;
import com.self.designpatterns.pricing.strategy.FestivalDiscount;
import com.self.designpatterns.order.dto.OrderResponse;

/*
ENTRY POINT
===========
This main method demonstrates all design patterns
from a single starting point.
*/
public class Application {

    public static void main(String[] args) {

        // ---------- FACTORY PATTERN ----------
        PaymentService paymentService = new PaymentService();
        paymentService.makePayment("CARD", 1000);
        paymentService.makePayment("UPI", 500);

        // ---------- STRATEGY PATTERN ----------
        DiscountStrategy discountStrategy = new FestivalDiscount();
        double finalAmount = discountStrategy.apply(1000);
        System.out.println("Discounted Amount: " + finalAmount);

        // ---------- BUILDER PATTERN ----------
        OrderResponse response = new OrderResponse.Builder()
                .orderId("ORD-1001")
                .status("SUCCESS")
                .amount(950)
                .build();

        System.out.println("OrderResponse built using Builder Pattern");
    }
}