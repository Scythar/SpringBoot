package com.self.designPattern.observer.subject;

import com.self.designPattern.observer.observer.Observer;

import java.util.ArrayList;
import java.util.List;

public class YoutubeChannel implements Subject{

    List<Observer> list = new  ArrayList<>();

    @Override
    public void addObserver(Observer o) {
        list.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        list.remove(o);
    }

    @Override
    public void notifyObservers() {
        for (Observer o : list) {
            o.update("new video uploaded");
        }
    }

    public void uploadVideo( int num){
        System.out.println("uploading video number "+ num);
        notifyObservers();
    }


}
