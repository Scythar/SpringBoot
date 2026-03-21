package com.self.designPattern.observer.observer;

public class SMSObserver implements Observer {

    String name;

    public SMSObserver(String s){
        this.name = s;
    }

    @Override
    public void update(String message) {
        System.out.println(name + "received email notification: " + message);
    }
}
