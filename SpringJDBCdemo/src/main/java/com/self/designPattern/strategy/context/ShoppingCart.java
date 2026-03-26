package com.self.designPattern.strategy.context;

import com.self.designPattern.strategy.strategy.DiscountStrategy;

public class ShoppingCart {
    private DiscountStrategy discountStrategy;

    public ShoppingCart(DiscountStrategy discountStrategy) {
        this.discountStrategy = discountStrategy;
    }

    public DiscountStrategy setDiscountStrategy(DiscountStrategy discountStrategy) {
        this.discountStrategy = discountStrategy;
        return discountStrategy;
    }

    public double checkout(double price){
        double finalPrice = discountStrategy.applyDiscount(price);
        System.out.println("Final Price: ₹" + finalPrice);
        return finalPrice;
    }


}
