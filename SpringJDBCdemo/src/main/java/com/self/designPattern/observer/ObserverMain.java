package com.self.designPattern.observer;

import com.self.designPattern.observer.observer.EmailObserver;
import com.self.designPattern.observer.observer.Observer;
import com.self.designPattern.observer.subject.YoutubeChannel;

public class ObserverMain {
    public static void main(String[] args) {
        YoutubeChannel yt  = new  YoutubeChannel();

        Observer ob1 = new EmailObserver("Nitesh");
        Observer ob2 = new EmailObserver("Sitesh");

        yt.addObserver(ob1);
        yt.addObserver(ob2);
        yt.uploadVideo();
    }
}