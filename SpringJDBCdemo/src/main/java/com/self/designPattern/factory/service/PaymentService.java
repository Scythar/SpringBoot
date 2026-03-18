package com.self.designPattern.factory.service;

import com.self.designPattern.factory.factory.PaymentFactory;
import com.self.designPattern.factory.payment.PaymentProcessor;

public class PaymentService {
    public void makePayment(String type, double amount) {
        PaymentProcessor processor = PaymentFactory.getProcessor(type);
        processor.pay(amount);
    }
}