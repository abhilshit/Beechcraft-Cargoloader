/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 *
 * @author abhilshit
 */
public class ResetChartTest extends Application {
    private static  int i = 0;
    public static ObservableList<LineChart.Series> lineChartData = FXCollections.observableArrayList(
            new LineChart.Series("Series 1", FXCollections.observableArrayList(
                new LineChart.Data(0.0, 1.0),
                new LineChart.Data(1.2, 1.4),
                new LineChart.Data(2.2, 1.9),
                new LineChart.Data(2.7, 2.3),
                new LineChart.Data(2.9, 0.5)
            )),
            new LineChart.Series("Series 2", FXCollections.observableArrayList(
                new LineChart.Data(2.0, 2.2)
            ))
        );
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Application.launch(ResetChartTest.class, args);
    }
    
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Reset");
        Group root = new Group();
        Scene scene = new Scene(root, 500, 450, Color.LIGHTGREEN);
        
        NumberAxis xAxis = new NumberAxis("X-Axis", 0, 3, 1);
        NumberAxis yAxis = new NumberAxis("Y-Axis", 0, 3, 1);
       
        LineChart chart = new LineChart(xAxis, yAxis, lineChartData);
        
        //disable this line to make it work
        chart.setCreateSymbols(false);
        
        Button resetButton = new Button();
        resetButton.setText("Reset");
        resetButton.setLayoutX(400);
        resetButton.setLayoutY(350);
        resetButton.setOnAction(new EventHandler<ActionEvent>() {

            public void handle(ActionEvent event) {
               
                 lineChartData.get(1).getData().set(0, new LineChart.Data(3*Math.random(), 3*Math.random()));
                
            }
        });
        root.getChildren().
                addAll(chart,resetButton);        
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
