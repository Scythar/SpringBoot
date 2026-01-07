package com.self.designpatterns.payment.impl;

import com.self.designpatterns.payment.domain.PaymentProcessor;

/*
FACTORY PATTERN - Concrete Implementation
*/
public class CardPaymentProcessor implements PaymentProcessor {

    @Override
    public void pay(double amount) {
        System.out.println("CARD payment of Rs " + amount);
    }
}