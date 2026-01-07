package com.self.designpatterns.pricing.strategy;

/*
STRATEGY INTERFACE
*/
public interface DiscountStrategy {
    double apply(double amount);
}