package model;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

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


    public void update(Event st,Thermometer t) {
        if (t.getTt()<=t.getKt()) {
            createBattery() ;
            if(st.getState() % 10==0){
                t.setTt(t.getTt()+1);
                System.out.println("Прибавили");
                deleteB();
            }
        }
    }
}
