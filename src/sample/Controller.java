package sample;

import javafx.event.ActionEvent;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import model.*;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    public TextField texttt;
    public TextField textkt;
    public TextField temp;
    private Thermometer termomrter;
    public Event event;
    public Canvas canvas;
    private Battery battery;
    private AirConditioning airCond;
    private GraphicsContext g;
    private Light light;
    int tt=10;
    int kt=10;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        g=canvas.getGraphicsContext2D();
        g.setLineWidth(5);

        g.strokePolygon(new double[] {60,90,150,240,360,450,510,540},
                new double[] {330,240,150,60,60,150,240,330},8);
        g.strokePolygon(new double[]{240,240,360,360},new double[]{60,90,90,60},4);
        g.strokePolygon(new double[]{60,90,120,120},new double[]{330,240,240,330},4);
        g.strokePolygon(new double[]{540,510,480,480},new double[]{330,240,240,330},4);

        //лампы
        g.setStroke(Color.BLACK);
        g.strokeLine(240,90,240,130);
        g.setFill(Color.YELLOW);
        g.fillOval(240-15,130,30,30);

        g.setStroke(Color.BLACK);
        g.strokeLine(360,90,360,130);
        g.setFill(Color.YELLOW);
        g.fillOval(360-15,130,30,30);

        //растение
        g.setStroke(Color.GREEN);
        g.strokePolyline(new double[]{300,310,315,325,330,336,349,359},new double[]{330,315,300,285,282,280,285,290},8);
        g.strokePolyline(new double[]{300,290,285,275,270,264,251,241},new double[]{330,315,300,285,282,280,285,290},8);
        g.strokePolyline(new double[]{300,305,306,309,316},new double[]{330,315,300,280,270},5);
        g.strokePolyline(new double[]{300,295,294,291,284},new double[]{330,315,300,280,270},5);
        g.setFill(Color.RED);
        g.fillOval(241-10,290,20,20);
        g.fillOval(359-10,290,20,20);
        g.fillOval(316-10,270,20,20);


    }

    public void zapusk(ActionEvent actionEvent) {

        tt=Integer.parseInt(texttt.getText());
        kt=Integer.parseInt(textkt.getText());


        termomrter=new Thermometer(tt,kt,temp);
        event=new Event();
        battery=new Battery(canvas.getGraphicsContext2D());
        light=new Light(canvas.getGraphicsContext2D());
        airCond=new AirConditioning(canvas.getGraphicsContext2D());
        event.attach(termomrter);
        event.attach(light);
        termomrter.attach(battery);
        termomrter.attach(airCond);

        temp.setText(termomrter.getTt() + "C");
    }


}
