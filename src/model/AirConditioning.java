package model;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class AirConditioning implements Observer{
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


    public void update(Event st,Thermometer t) {
        if (t.getTt()>=t.getKt())
           createAirConditioning();
        if (t.getTt()>t.getKt()) {
            if(st.getState()%10==0){
                t.setTt(t.getTt()-1);
                System.out.println("Отняли");
                deleteB();
        }
    }

    }
}
