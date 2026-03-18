package com.self.designPattern.factory.factory;

import com.self.designPattern.factory.payment.CardPayment;
import com.self.designPattern.factory.payment.UpiPayment;
import com.self.designPattern.factory.payment.PaymentProcessor;

public class PaymentFactory {
    public static PaymentProcessor getProcessor(String type) {
        if ("CARD".equalsIgnoreCase(type)) return new CardPayment();
        if ("UPI".equalsIgnoreCase(type)) return new UpiPayment();
        throw new IllegalArgumentException("Invalid payment type");
    }
}