package com.self.designPattern.strategy;

import com.self.SpringJDBCdemo.SpringJdbcDemoApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import com.self.designPattern.strategy.service.PricingService;
import com.self.designPattern.strategy.strategy.DiscountStrategy;
import com.self.designPattern.strategy.strategy.FestivalDiscount;

@SpringBootApplication
public class StrategyMain {
    public static void main(String[] args) {

        ApplicationContext context = SpringApplication.run(StrategyMain.class, args);
        PricingService service = new PricingService((DiscountStrategy) new FestivalDiscount());
        System.out.println(service.calculate(1000));
    }
}