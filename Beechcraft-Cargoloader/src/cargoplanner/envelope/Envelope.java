package cargoplanner.envelope;

import cargoplanner.PlanData;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Side;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

/**
 * the aircraft envelope of operational limits
 * @author Abhilshit Soni
 */
public class Envelope extends Parent {

    public static ObservableList<LineChart.Series> dataSeries = FXCollections.
            observableArrayList(
            new LineChart.Series("Take-Off Limit A", FXCollections.
            observableArrayList()),
            new LineChart.Series("Take-off Limit B", FXCollections.
            observableArrayList()),
            new LineChart.Series("Zero Fuel Limit", FXCollections.
            observableArrayList()),
            new LineChart.Series("Center of Gravity", FXCollections.observableArrayList(new LineChart.Data(0,0))));

    NumberAxis envelopeXAxis = null;
    NumberAxis envelopeYAxis = null;
    LineChart envelope = null;
    NumberAxis cgPlotXAxis = null;
    NumberAxis cgPlotYAxis = null;
    LineChart cgPlot = null;

    public Envelope() {
        DataUtil.populateTakeOffLimA();
        DataUtil.populateTakeOffLimB();
        DataUtil.populateZFLim();
       
        envelopeXAxis = new NumberAxis("Center of Gravity (inches from datum)",
                260, 320, 10);
        envelopeXAxis.setTickLabelGap(10);
        envelopeXAxis.setTickLabelFont(new Font(9));
        envelopeXAxis.setTickLabelGap(10);
        envelopeXAxis.setTickLength(10);
        envelopeXAxis.setTickLabelFill(Color.WHITE);

        envelopeYAxis = new NumberAxis("Weight x 100", 0, 180, 15);
        envelopeYAxis.setTickLabelGap(10);
        envelopeYAxis.setTickLabelFont(new Font(9));
        envelopeYAxis.setTickLabelGap(10);
        envelopeYAxis.setTickLength(10);
        envelopeYAxis.setTickLabelFill(Color.WHITE);

        envelope = new LineChart(envelopeXAxis, envelopeYAxis,
                Envelope.dataSeries);
        envelope.setCreateSymbols(true);
        envelope.setLegendSide(Side.BOTTOM);
        envelope.setLegendVisible(false);
        envelope.setHorizontalGridLinesVisible(true);
        envelope.setVerticalGridLinesVisible(true);
        envelope.setTitleSide(Side.BOTTOM);
        envelope.setPrefHeight(400);
        envelope.setPrefWidth(400);
        
         DataUtil.populateCGData(PlanData.initialTotalWeight / 100,
                PlanData.initialCG);
         
//        envelope.setCreateSymbols(false);
        envelope.setAnimated(true);


        Group group = new Group();
        group.getChildren().
                addAll(envelope);
        getChildren().
                add(group);
    }
}