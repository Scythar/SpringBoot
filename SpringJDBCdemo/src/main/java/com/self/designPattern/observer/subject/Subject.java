package com.self.designPattern.observer.subject;

import com.self.designPattern.observer.observer.Observer;

public interface Subject {

    void addObserver(Observer o);
    void removeObserver(Observer o);
    void notifyObservers();
}
