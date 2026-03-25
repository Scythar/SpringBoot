package com.self.designPattern.factory;

import com.self.designPattern.factory.factory.NotificationFactory;
import com.self.designPattern.factory.notification.Notification;

public class FactoryMain {

    //    public static NotificationFactory notificationFactory;
    public static void main(String[] args) {
        Notification notification =
                NotificationFactory.createNotification("email");

        notification.send();
    }
}