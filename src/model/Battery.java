package model;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.util.Observable;
import java.util.Observer;

public class Battery implements Observer {
    private GraphicsContext gr;

    public Battery(GraphicsContext g){
        this.gr = g;
    }

    public void createBattery() {

        gr.setLineWidth(5);
        gr.setStroke(Color.RED);
        gr.strokePolygon(new double[]{150,180},new double[]{270,240},2);
        gr.strokePolygon(new double[]{150,180},new double[]{300,325},2);
        gr.strokePolygon(new double[]{450,420},new double[]{270,240},2);
        gr.strokePolygon(new double[]{450,420},new double[]{300,325},2);
    }

    public void deleteB(){
        gr.clearRect(125,240,60,85);
        gr.clearRect(415,240,60,85);
    }

    @Override
    public void update(Observable o, Object arg) {
        Thermometer t = (Thermometer) arg;
        if (t.getTt() < t.getKt()) {
            createBattery();
            try {
                Thread.currentThread().sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            t.setTt(t.getTt() + 1);
            System.out.println("Прибавили");
            deleteB();
        }
    }
}
