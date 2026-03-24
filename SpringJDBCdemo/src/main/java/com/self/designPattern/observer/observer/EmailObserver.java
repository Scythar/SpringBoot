package com.self.designPattern.observer.observer;

public class EmailObserver implements Observer {

    String name;

    public EmailObserver(String name){
        this.name = name;
    }

    @Override
    public void update(String message) {
        System.out.println(name+" received SMS notification: "+ message);
    }
}
