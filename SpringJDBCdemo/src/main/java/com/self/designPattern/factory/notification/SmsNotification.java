package com.self.designPattern.factory.notification;

public class SmsNotification implements Notification {

    @Override
    public void send() {
        System.out.println("SMS Notification");
    }
}
