package com.self.designPattern.strategy.strategy;

public class MemberDiscount implements DiscountStrategy {
    public double applyDiscount(double price) {
        return price * 0.70; // 30% off
    }
}