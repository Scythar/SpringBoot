package factory.factory;

import factory.payment.CardPayment;
import factory.payment.UpiPayment;
import factory.payment.PaymentProcessor;

public class PaymentFactory {
    public static PaymentProcessor getProcessor(String type) {
        if ("CARD".equalsIgnoreCase(type)) return new CardPayment();
        if ("UPI".equalsIgnoreCase(type)) return new UpiPayment();
        throw new IllegalArgumentException("Invalid payment type");
    }
}