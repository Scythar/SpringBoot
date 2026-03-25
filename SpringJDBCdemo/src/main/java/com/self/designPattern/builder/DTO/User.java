package com.self.designPattern.builder.DTO;

public class User {
    private final String name;
    private final int age;
    private final String email;

    private User(Builder builder) {
        this.name = builder.name;
        this.age = builder.age;
        this.email = builder.email;
    }

    public static class Builder {
        private  String name;
        private int age;
        private String email;

        public Builder name(String name) {
            this.name = name;
            return this;        // return this means return same builder object
        }

        public Builder age(int age) {
            this.age = age;
            return this;        // return this means return same builder object
        }

        public Builder email(String email) {
            this.email = email;
            return this;        // return this means return same builder object
        }

        public User build() {
            return new User(this);      // return this means return same builder object to new User
        }
    }
}