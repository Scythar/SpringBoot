package com.self.designPattern.factory.factory;

import com.self.designPattern.factory.notification.EmailNotification;
import com.self.designPattern.factory.notification.Notification;
import com.self.designPattern.factory.notification.SmsNotification;

public class NotificationFactory {
    /* remember to declare method createNotification as static type

    Static methods are perfect for utility classes that just perform operations.

    Make a method static when it does NOT depend on object state (instance variables)
    — regardless of whether other instance variables exist in the class or not.
    */
   public static Notification createNotification(String type){
       if(type.equalsIgnoreCase("email")){
           return new EmailNotification();
       }
       else return new SmsNotification();
   }
}