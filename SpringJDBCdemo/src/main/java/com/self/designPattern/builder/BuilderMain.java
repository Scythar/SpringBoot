package com.self.designPattern.builder;

import com.self.designPattern.builder.DTO.User;

public class BuilderMain {
    public static void main(String[] args) {
        User user = new User.Builder().name("Nitesh")
                .age(25)
                .email("nitesh@gmail.com")
                .build();
        System.out.println("Builder Pattern executed");

        //if any field like "age" is not set using builder pattern, its value will be set to default if primitive datatype, null if object.
    }
}