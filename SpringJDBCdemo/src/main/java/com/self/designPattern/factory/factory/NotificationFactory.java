package com.self.designPattern.factory.factory;

import com.self.designPattern.factory.notification.EmailNotification;

public class NotificationFactory {
   public void createNotification(String type){
       if(type.equalsIgnoreCase("email")){
           return new EmailNotification();
       }
       else return new SmsNotification();
   }
}