package com.self.designPattern.strategy;

import com.self.SpringJDBCdemo.SpringJdbcDemoApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import strategy.service.PricingService;
import strategy.strategy.DiscountStrategy;
import strategy.strategy.FestivalDiscount;
@SpringBootApplication
public class StrategyMain {
    public static void main(String[] args) {

        ApplicationContext context = SpringApplication.run(StrategyMain.class, args);
        PricingService service = new PricingService((DiscountStrategy) new FestivalDiscount());
        System.out.println(service.calculate(1000));
    }
}