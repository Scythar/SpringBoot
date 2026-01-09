package com.self.SpringJDBCdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

//Annotations in Java:
//Do NOT guarantee order
//Are NOT evaluated top-to-bottom
//Are NOT executed in the order they appear in your code

@SpringBootApplication
public class SpringJdbcDemoApplication {


	public static void main(String[] args) {

        ApplicationContext context = SpringApplication.run(SpringJdbcDemoApplication.class, args);


	}

}
