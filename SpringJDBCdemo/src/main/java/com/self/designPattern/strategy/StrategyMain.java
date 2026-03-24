package com.self.designPattern.strategy;

import com.self.designPattern.strategy.context.ShoppingCart;
import com.self.designPattern.strategy.strategy.NoDiscount;
import com.self.designPattern.strategy.strategy.SeasonalDiscount;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class StrategyMain {
    public static void main(String[] args) {

        ApplicationContext context = SpringApplication.run(StrategyMain.class, args);


        ShoppingCart cart = new ShoppingCart(new NoDiscount());
        cart.checkout(1000);

        cart.setDiscountStrategy(new SeasonalDiscount());
        cart.checkout(1000);   // ₹800.0
    }
}