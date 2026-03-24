package com.self.designPattern.strategy.strategy;

public class SeasonalDiscount implements DiscountStrategy {
    public double applyDiscount(double price) {
        return price * 0.80; // 20% off
    }
}
