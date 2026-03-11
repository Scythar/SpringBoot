package com.self.designPattern.strategy.service;

import com.self.designPattern.strategy.strategy.DiscountStrategy;

public class PricingService {
    private DiscountStrategy strategy;
    public PricingService(DiscountStrategy strategy) {
        this.strategy = strategy;
    }
    public double calculate(double amount) {
        return strategy.apply(amount);
    }
}