package factory.service;

import factory.factory.PaymentFactory;
import factory.payment.PaymentProcessor;

public class PaymentService {
    public void makePayment(String type, double amount) {
        PaymentProcessor processor = PaymentFactory.getProcessor(type);
        processor.pay(amount);
    }
}