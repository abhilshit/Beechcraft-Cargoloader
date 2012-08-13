
package cargoplanner.envelope;

import javafx.scene.chart.LineChart;

/**
 *
 * @author abhilshit
 */
public class DataUtil {

    public static void populateTakeOffLimA() {

        Envelope.dataSeries.get(0).getData().
                add(new LineChart.Data(274, 0));
        Envelope.dataSeries.get(0).getData().
                add(new LineChart.Data(270, 115));
        Envelope.dataSeries.get(0).getData().
                add(new LineChart.Data(279, 165));
        Envelope.dataSeries.get(0).getData().
                add(new LineChart.Data(310, 165));
        Envelope.dataSeries.get(0).getData().
                add(new LineChart.Data(300, 0));

    }

    public static void populateZFLim() {

        Envelope.dataSeries.get(2).getData().
                add(new LineChart.Data(274, 0));
        Envelope.dataSeries.get(2).getData().
                add(new LineChart.Data(270, 115));
        Envelope.dataSeries.get(2).getData().
                add(new LineChart.Data(275, 140));
        Envelope.dataSeries.get(2).getData().
                add(new LineChart.Data(308, 140));
        Envelope.dataSeries.get(2).getData().
                add(new LineChart.Data(300, 0));

    }

    public static void populateTakeOffLimB() {

        Envelope.dataSeries.get(1).getData().
                add(new LineChart.Data(292, 0));
        Envelope.dataSeries.get(1).getData().
                add(new LineChart.Data(294, 147));
        Envelope.dataSeries.get(1).getData().
                add(new LineChart.Data(230, 147));

    }

    public static void populateCGData(double weight, double cg) {
        if(Envelope.dataSeries.get(3).getData().isEmpty())
        {
        
            Envelope.dataSeries.get(3).getData().
                set(0, new LineChart.Data(Double.valueOf(cg), Double.valueOf(
                weight)));    
        }
        else
        {
                Envelope.dataSeries.get(3).getData().
                set(0,new LineChart.Data(Double.valueOf(cg), Double.valueOf(
                weight)));
            
        }
        
    }
}
