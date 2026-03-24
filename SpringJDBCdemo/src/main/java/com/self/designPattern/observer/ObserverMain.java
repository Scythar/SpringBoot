package com.self.designPattern.observer;

import com.self.designPattern.observer.observer.EmailObserver;
import com.self.designPattern.observer.observer.Observer;
import com.self.designPattern.observer.observer.SMSObserver;
import com.self.designPattern.observer.subject.YoutubeChannel;

public class ObserverMain {
    public static void main(String[] args) {
       YoutubeChannel youtubeChannel = new YoutubeChannel();
       Observer ob1 = new EmailObserver("Nitesh");
       Observer ob2 = new SMSObserver("Sitesh");

       youtubeChannel.addObserver(ob1);
       youtubeChannel.addObserver(ob2);
       youtubeChannel.uploadVideo(23);

    }
}