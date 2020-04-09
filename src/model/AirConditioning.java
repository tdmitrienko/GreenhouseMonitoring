package model;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.util.Observable;
import java.util.Observer;

public class AirConditioning implements Observer {
    private GraphicsContext gr;

    public AirConditioning(GraphicsContext g){
        this.gr = g;
    }

    public void createAirConditioning() {
        gr.setLineWidth(5);
        gr.setStroke(Color.BLUE);
        gr.strokeLine(270,95,250,110);
        gr.strokeLine(300,95,300,120);
        gr.strokeLine(330,95,350,110);
    }

    public void deleteB(){
        gr.clearRect(245,95,110,30);
    }

    @Override
    public void update(Observable o, Object arg) {
        Thermometer t = (Thermometer) arg;
        if (t.getTt() >= t.getKt()) {
            createAirConditioning();
            try {
                Thread.currentThread().sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            t.setTt(t.getTt() - 1);
            System.out.println("Отняли");
            deleteB();
        }
    }
}
