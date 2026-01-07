package com.self.designPattern.builder;

import com.self.designPattern.builder.DTO.User;

public class BuilderMain {
    public static void main(String[] args) {
        User user = new User.Builder("Nitesh")
                .age(25)
                .email("nitesh@gmail.com")
                .build();
        System.out.println("Builder Pattern executed");
    }
}