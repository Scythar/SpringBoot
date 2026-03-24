package com.self.designPattern.factory.notification;

public class EmailNotification implements Notification {

    @Override
    public void send() {
        System.out.println("Email Notification");
    }
}
