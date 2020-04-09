package model;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Light implements Observer {
    private GraphicsContext gr;

    public Light(GraphicsContext gr) {
        this.gr = gr;
    }

    public void createLight() {

        gr.setLineWidth(5);
        gr.setStroke(Color.BLACK);
        gr.strokeLine(240,90,240,130);
        gr.setFill(Color.YELLOW);
        gr.fillOval(240-15,130,30,30);
        gr.setStroke(Color.BLACK);
        gr.strokeLine(360,90,360,130);
        gr.setFill(Color.YELLOW);
        gr.fillOval(360-15,130,30,30);
    }

    public void deleteL(){
        gr.setLineWidth(5);
        gr.setStroke(Color.BLACK);
        gr.strokeLine(240,90,240,130);
        gr.setFill(Color.BLACK);
        gr.fillOval(240-15,130,30,30);
        gr.setStroke(Color.BLACK);
        gr.strokeLine(360,90,360,130);
        gr.setFill(Color.BLACK);
        gr.fillOval(360-15,130,30,30);
    }


    @Override
    public void update(Event ev, Thermometer t) {
            if(ev.getState() % 18==0){
                deleteL();
            }
            else if(ev.getState() % 24==0){
                createLight();
            }
        }

    }

