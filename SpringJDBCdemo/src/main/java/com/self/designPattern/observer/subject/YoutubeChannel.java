package com.self.designPattern.observer.subject;

import com.self.designPattern.observer.observer.Observer;

import java.util.ArrayList;
import java.util.List;

public class YoutubeChannel implements Subject{

    List<Observer>  list = new ArrayList<>();

    @Override
    public void addObserver(Observer o) {
        list.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        list.remove(o);
    }

    public void uploadVideo(){
        System.out.print("new video uploaded");
        notifyObservers();
    }

    @Override
    public void notifyObservers() {
        for(Observer o:list){
            o.update("new video updated" + o);
        }
    }


}
