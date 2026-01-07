package com.self.designpatterns.pricing.strategy;

/*
STRATEGY IMPLEMENTATION
*/
public class FestivalDiscount implements DiscountStrategy {

    @Override
    public double apply(double amount) {
        return amount * 0.95;
    }
}