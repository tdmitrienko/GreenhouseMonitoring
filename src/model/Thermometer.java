package model;

import javafx.scene.control.TextField;

public class Thermometer implements Observer {
    private int tt;
    private int kt;
    private TextField textField;

    public Thermometer(int tt, int kt, TextField textField) {
        this.tt = tt;
        this.kt = kt;
        this.textField = textField;
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

    public void setKt(int kt) {
        this.kt = kt;
    }


    @Override
    public void update(Event ev, Thermometer t) {
        textField.setText(""+this.getTt()+"C");
    }
}

