package com.self.designPattern.strategy.strategy;

public class FestivalDiscount implements DiscountStrategy {
    public double applyDiscount(double amount) {
        return amount * 0.9;
    }
}