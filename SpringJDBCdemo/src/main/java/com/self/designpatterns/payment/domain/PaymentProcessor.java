package com.self.designpatterns.payment.domain;

/*
DOMAIN INTERFACE
Used by Factory Pattern
*/
public interface PaymentProcessor {
    void pay(double amount);
}