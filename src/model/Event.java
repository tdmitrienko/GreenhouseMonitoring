package model;

import java.util.*;
import java.util.Observer;
import java.util.Observable;

public class Event extends Observable {

    private Timer timer;
    private int timeState;


    public Event(){
        super();
        timeState=0;
        timer=new Timer();
        TimerTask task=new TimerTask() {
            @Override
            public void run() {
                timeState++;
                notifyAllObservers();
            }
        };
        timer.schedule(task,0,1000);
    }


    public void notifyAllObservers() {
        super.setChanged();
        super.notifyObservers(timeState);
    }

    public void attach(Observer var1) {
        super.addObserver(var1);
    }
}
