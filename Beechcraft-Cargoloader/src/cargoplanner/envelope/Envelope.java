 /*
 * Copyright (c) 2008-2010, JFXtras Group
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 * 1. Redistributions of source code must retain the above copyright notice,
 *    this list of conditions and the following disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright notice,
 *    this list of conditions and the following disclaimer in the documentation
 *    and/or other materials provided with the distribution.
 * 3. Neither the name of JFXtras nor the names of its contributors may be used
 *    to endorse or promote products derived from this software without
 *    specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
 * POSSIBILITY OF SUCH DAMAGE.
 */
package cargoplanner.envelope;

import cargoplanner.PlanData;
import javafx.scene.text.Font;
import javafx.scene.chart.LineChart;
import javafx.scene.Group;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Side;
import javafx.scene.Parent;
import javafx.scene.chart.NumberAxis;
import javafx.scene.paint.Color;

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
        DataUtil.populateCGData(PlanData.initialTotalWeight / 100,
                PlanData.initialCG);
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
        envelope.setTranslateX(10);
        envelope.setTranslateY(35);
        envelope.setCreateSymbols(true);
        envelope.setLegendSide(Side.BOTTOM);
        envelope.setLegendVisible(false);
        envelope.setHorizontalGridLinesVisible(true);
        envelope.setVerticalGridLinesVisible(true);
        envelope.setTitleSide(Side.BOTTOM);
        envelope.setPrefHeight(400);
        envelope.setPrefWidth(400);


        Group group = new Group();
        group.getChildren().
                addAll(envelope);
        getChildren().
                add(group);
    }
}