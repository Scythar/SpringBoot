package com.self.designpatterns.order.event;

/*
OBSERVER PATTERN - Event
-----------------------
*/
public class OrderCreatedEvent {
    private final String orderId;

    public OrderCreatedEvent(String orderId) {
        this.orderId = orderId;
    }

    public String getOrderId() {
        return orderId;
    }
}