package com.self.designPattern.observer;

import observer.observer.OrderObserver;
import observer.subject.OrderService;
import observer.observer.EmailObserver;

public class ObserverMain {
    public static void main(String[] args) {
        OrderService service = new OrderService();
        service.register((OrderObserver) new EmailObserver());
        service.placeOrder("ORD-1");
    }
}