package com.self.designpatterns.payment.config;

import com.self.designpatterns.payment.domain.PaymentProcessor;
import com.self.designpatterns.payment.impl.CardPaymentProcessor;
import com.self.designpatterns.payment.impl.UpiPaymentProcessor;

/*
FACTORY DESIGN PATTERN
Centralized object creation
*/
public class PaymentProcessorFactory {

    public static PaymentProcessor getProcessor(String type) {

        if ("CARD".equalsIgnoreCase(type)) {
            return new CardPaymentProcessor();
        }
        if ("UPI".equalsIgnoreCase(type)) {
            return new UpiPaymentProcessor();
        }
        throw new IllegalArgumentException("Unsupported payment type");
    }
}