package com.self.designpatterns.payment.service;

import com.self.designpatterns.payment.config.PaymentProcessorFactory;
import com.self.designpatterns.payment.domain.PaymentProcessor;

/*
SERVICE LAYER
Uses Factory Pattern
*/
public class PaymentService {

    public void makePayment(String type, double amount) {
        PaymentProcessor processor =
                PaymentProcessorFactory.getProcessor(type);
        processor.pay(amount);
    }
}