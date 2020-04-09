package model;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.util.List;


public class Event implements Observable {
    Timer timer;
    Thermometer t;
    int timeState;
    int delay;
    int period;
    List<Observer> observers = new LinkedList();

    public Event(Thermometer t){
        this.t=t;
        timeState=0;
        delay=1000;
        period=1000;
     timer=new Timer(1000, new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            timeState++;
            notifyAllObservers();
        }
    });}

    public void start() {
        this.timer.start();
    }

    public void stop() {
        this.timer.stop();
    }

    public void notifyAllObservers() {
        for(Observer observer : observers){
            observer.update(this,t);
        }
    }

    public void attach(Observer var1) {
        observers.add(var1);
    }

    public int getState(){
        return timeState;
    }

}
