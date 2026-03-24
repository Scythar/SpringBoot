package com.self.designPattern.strategy.strategy;

public class NoDiscount implements DiscountStrategy {
    public double applyDiscount(double price) {
        return price;
    }
}
