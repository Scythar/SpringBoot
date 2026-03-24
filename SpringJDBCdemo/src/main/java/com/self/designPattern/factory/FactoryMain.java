package com.self.designPattern.factory;

import com.self.designPattern.factory.factory.NotificationFactory;

public class FactoryMain {
    public static void main(String[] args) {
        NotificationFactory notificationFactory = new NotificationFactory();
        notificationFactory.createNotification("email");
        notificationFactory.createNotification("sms");
    }
}