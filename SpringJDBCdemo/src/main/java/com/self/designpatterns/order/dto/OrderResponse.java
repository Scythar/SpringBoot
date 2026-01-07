package com.self.designpatterns.order.dto;

/*
BUILDER PATTERN
Used for complex DTO creation
*/
public class OrderResponse {

    private final String orderId;
    private final String status;
    private final double amount;

    private OrderResponse(Builder builder) {
        this.orderId = builder.orderId;
        this.status = builder.status;
        this.amount = builder.amount;
    }

    public static class Builder {
        private String orderId;
        private String status;
        private double amount;

        public Builder orderId(String orderId) {
            this.orderId = orderId;
            return this;
        }

        public Builder status(String status) {
            this.status = status;
            return this;
        }

        public Builder amount(double amount) {
            this.amount = amount;
            return this;
        }

        public OrderResponse build() {
            return new OrderResponse(this);
        }
    }
}