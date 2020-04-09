package model;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observer;
import java.util.Observable;

public class Event extends Observable {

    private Timer timer;
    private int timeState;
    private int delay;
    private int period;

    public Event(){
        super();
        timeState=0;
        delay=1000;
        period=1000;
        timer=new Timer(1000, new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            timeState++;
            notifyAllObservers();
        }
        });
    }

    public void start() {
        this.timer.start();
    }

    public void notifyAllObservers() {
        super.setChanged();
        super.notifyObservers(timeState);
    }

    public void attach(Observer var1) {
        super.addObserver(var1);
    }


}
