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
package cargoplanner;

import javafx.beans.binding.NumberBinding;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Side;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.PieChartBuilder;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.RectangleBuilder;

/**
 * the pie chart showing weight on each section of the main deck of the
 * aircraft.
 *
 * @author Abhilshit Soni
 */
public class WeightCoverageChart extends Parent {

    public Node anotherChart;
    public PlanData planData; 
    PieChart pie = PieChartBuilder.create().title("Weight Coverage").titleSide(Side.BOTTOM).scaleX(0.62).scaleY(0.65).translateX(Properties.startX-400).translateY(Properties.leftStartY+Properties.height+160).legendVisible(false).build();
    public static NumberBinding weightA = PlanData.weightAR.add(PlanData.weightAL);
    NumberBinding weightB = PlanData.weightBR.add(PlanData.weightBL);
    NumberBinding weightC = PlanData.weightCR.add(PlanData.weightCL);
    NumberBinding weightD = PlanData.weightDR.add(PlanData.weightDL);
    NumberBinding weightE = PlanData.weightER.add(PlanData.weightEL);
    NumberBinding weightF = PlanData.weightFR.add(PlanData.weightFL);
    NumberBinding weightG = PlanData.weightGR.add(PlanData.weightGL);
    NumberBinding weightH = PlanData.weightHR.add(PlanData.weightHL);
    NumberBinding weightI = PlanData.weightIR.add(PlanData.weightIL);
    ObservableList pieData = FXCollections.observableArrayList(
            new PieChart.Data("A", (weightA.doubleValue())),
            new PieChart.Data("B", (weightB.doubleValue())),
            new PieChart.Data("C", (weightC.doubleValue())),
            new PieChart.Data("D", (weightD.doubleValue())),
            new PieChart.Data("E", (weightE.doubleValue())),
            new PieChart.Data("F", (weightF.doubleValue())),
            new PieChart.Data("G", (weightG.doubleValue())),
            new PieChart.Data("H", (weightH.doubleValue())),
            new PieChart.Data("I", (weightI.doubleValue())),
            new PieChart.Data("Crew", PlanData.crewWeight),
            new PieChart.Data("Fuel", PlanData.fuelWeight));

    public WeightCoverageChart() {
        weightA.addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                pieData.set(0, new PieChart.Data("A " +weightA.doubleValue() +"kgs" , (weightA.doubleValue())));
            }
        });
        weightB.addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                pieData.set(1, new PieChart.Data("B", (weightB.doubleValue())));
            }
        });
        weightC.addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                pieData.set(2, new PieChart.Data("C", (weightC.doubleValue())));
            }
        });
        weightD.addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                pieData.set(3, new PieChart.Data("D", (weightD.doubleValue())));
            }
        });
        weightE.addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                pieData.set(4, new PieChart.Data("E", (weightE.doubleValue())));
            }
        });
        weightF.addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                pieData.set(5, new PieChart.Data("F", (weightF.doubleValue())));
            }
        });
        weightG.addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                pieData.set(6, new PieChart.Data("G", (weightG.doubleValue())));
            }
        });
        weightH.addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                pieData.set(7, new PieChart.Data("H", (weightH.doubleValue())));
            }
        });
        weightI.addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                pieData.set(8, new PieChart.Data("I", (weightI.doubleValue())));
            }
        });
        this.setCache(true);
        pie.setData(pieData);
        Rectangle pieBG = RectangleBuilder.create().cache(true).
                x(pie.getTranslateX() + 127).
                y(pie.getTranslateY() + 84).
                fill(Color.rgb(50, 50, 50)).
                id("envelopeBG").
                width(265).
                height(245).
                arcWidth(5).
                arcHeight(5).
                build();
        Group group = new Group();
        group.getChildren().addAll(pieBG,pie);
        getChildren().add(group);
    }
}

