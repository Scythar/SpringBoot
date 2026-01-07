package com.self.designPattern.singleton;


import com.self.designPattern.singleton.config.AppConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SingletonMain {
    public static void main(String[] args) {

        ApplicationContext context = SpringApplication.run(SingletonMain.class, args);
        AppConfig a = AppConfig.getInstance();
        AppConfig b = AppConfig.getInstance();
        System.out.println(a == b);
    }
}