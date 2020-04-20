package model;

import javafx.scene.control.TextField;

import java.util.Observable;
import java.util.Observer;

public class Thermometer extends Observable implements Observer {
    private int tt;
    private int kt;
    private TextField textField;

    public Thermometer(int tt, int kt, TextField textField) {
        super();
        this.tt = tt;
        this.kt = kt;
        this.textField = textField;
    }

    public void notifyAllObservers() {
        super.setChanged();
        super.notifyObservers(this);
    }

    public void attach(Observer var1) {
        super.addObserver(var1);
    }

    public int getTt() {
        return tt;
    }

    public void setTt(int tt) {
        this.tt = tt;
    }

    public int getKt() {
        return kt;
    }


    @Override
    public void update(Observable o, Object arg) {
        int timeState = (int) arg;
        if (timeState % 5 == 0) {
            notifyAllObservers();
            textField.setText(this.getTt() + "C");
        }
    }
}

