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

import java.text.DecimalFormat;
import javafx.scene.shape.Rectangle;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Parent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * @author Abhilshit Soni
 */
public final class DataPanel extends Parent {

    private static DoubleProperty cWeightProperty = new SimpleDoubleProperty() {
    };
    private static DoubleProperty cMomentProperty = new SimpleDoubleProperty();
    private static DoubleProperty tWeightProperty = new SimpleDoubleProperty();
    private static DoubleProperty tMomentProperty = new SimpleDoubleProperty();
    private static DoubleProperty cgProperty = new SimpleDoubleProperty();
    private static ObservableList<ParameterValues> paramValues = FXCollections.observableArrayList();
    private static DecimalFormat decimalFormat = new DecimalFormat("#.#######");
    
    TableView<ParameterValues> gridPanel = new TableView<ParameterValues>();
    private Rectangle gridBorder = null;
    private Rectangle gridBG = null;

    public DataPanel(double translateX, double translateY) {
        this();
        this.setTranslateX(translateX);
        this.setTranslateY(translateY);
    }

    public DataPanel() {
        updateParameters();
        gridPanel.setCache(true);
        gridPanel.setLayoutX(-16);
        gridPanel.setLayoutY(-31);
        gridPanel.setPrefHeight(390);
        gridPanel.setPrefWidth(285);
        gridPanel.setMouseTransparent(false);
        TableColumn parameterColumn = new TableColumn();
        parameterColumn.setText("Parameter");
        parameterColumn.setCellValueFactory(new PropertyValueFactory<ParameterValues, String>("parameter"));
        parameterColumn.setMinWidth(180);
        TableColumn valueColumn = new TableColumn();
        valueColumn.setText("Value");
        //valueColumn.setMinWidth(200);
        valueColumn.setCellValueFactory(new PropertyValueFactory<ParameterValues, String>("value"));
        gridPanel.getColumns().addAll(parameterColumn, valueColumn);
        gridPanel.setItems(paramValues);
//        gridBorder = RectangleBuilder.create().cache(true).
//                cacheHint(CacheHint.SCALE_AND_ROTATE).
//                x(gridPanel.translateXProperty().
//                doubleValue() - 15).
//                y(gridPanel.translateYProperty().
//                doubleValue() - 30).
//                fill(Color.CADETBLUE).
//                width(281).
//                height(367).
//                arcWidth(15).
//                arcHeight(15).
//                effect(GlowBuilder.create().level(1).
//                input(ShadowBuilder.create().width(5).
//                color(Color.CADETBLUE).
//                radius(15).
//                build()).
//                build()).
//                opacity(0.5).
//                build();
//        gridBG = RectangleBuilder.create().cache(true).
//                x(gridPanel.translateXProperty().
//                doubleValue() - 19).
//                y(gridPanel.translateYProperty().
//                doubleValue() - 34).
//                fill(Color.web("#0093ff")).
//                width(281).
//                height(372).
//                arcWidth(15).
//                arcHeight(15).
//                build();
        this.getChildren().
                addAll(gridPanel);

    }

    public static void updateParameters() {
        paramValues.clear();
        ParameterValues emptyAircraftWeight = new ParameterValues(
                "Empty Aircraft Weight", PlanData.basicOperatingWeight + " lbs");
        paramValues.add(emptyAircraftWeight);
        ParameterValues emptyAircraftMoment = new ParameterValues(
                "Empty Aircraft Moment",
                PlanData.basicOperatingMoment + " lb-in");
        paramValues.add(emptyAircraftMoment);
        ParameterValues emptyAircraftCG = new ParameterValues(
                "Empty Aircraft Center of Gravity", decimalFormat.format(PlanData.basicCG) + " in");
        paramValues.add(emptyAircraftCG);
        ParameterValues totalCargoWeight = new ParameterValues(
                "Total Cargo Weight", cWeightProperty.getValue() + " lbs");
        paramValues.add(totalCargoWeight);
        ParameterValues totalCargomoment = new ParameterValues(
                "Total Cargo Moment", cMomentProperty.getValue() + " lb-in");
        paramValues.add(totalCargomoment);
        ParameterValues totalAircraftWeight = new ParameterValues(
                "Total Aircraft Weight", tWeightProperty.getValue() + " lbs");
        paramValues.add(totalAircraftWeight);
        ParameterValues totalAircraftMoment = new ParameterValues(
                "Total Aircraft Moment", tMomentProperty.getValue() + " lb-in");
        paramValues.add(totalAircraftMoment);
        ParameterValues currentCG = new ParameterValues(
                "Current Center of Gravity", decimalFormat.format(cgProperty.getValue()) + " in");
        paramValues.add(currentCG);
        ParameterValues fuelVolume = new ParameterValues("Fuel Volume",
                PlanData.fuelVolume + " gls");
        paramValues.add(fuelVolume);
        ParameterValues fuelDensity = new ParameterValues("Fuel Density @ 25 C",
                PlanData.fuelDensity + " lb/gls");
        paramValues.add(fuelDensity);
        ParameterValues fuelWeight = new ParameterValues("Fuel Weight",
                PlanData.fuelWeight + " lbs");
        paramValues.add(fuelWeight);
        ParameterValues fuelMoment = new ParameterValues("Fuel Moment",
                PlanData.fuelVolume + " lb-in");
        paramValues.add(fuelMoment);
        ParameterValues crewMembers = new ParameterValues("Crew Members", "3");
        paramValues.add(crewMembers);
        ParameterValues totalCrewWeight = new ParameterValues(
                "Total Crew Weight", PlanData.crewWeight + "");
        paramValues.add(totalCrewWeight);
        ParameterValues totalCrewMoment = new ParameterValues(
                "Total Crew Moment", PlanData.crewMoment + "");
        paramValues.add(totalCrewMoment);
    }

    public static void setCMoment(double cMomentProperty) {
        DataPanel.cMomentProperty.setValue(cMomentProperty);
    }

    public static void setCWeight(double cWeightProperty) {
        DataPanel.cWeightProperty.setValue(cWeightProperty);
    }

    public static void setCg(double cgProperty) {
        DataPanel.cgProperty.setValue(cgProperty);
    }

    public static void setTMoment(double tMomentProperty) {
        DataPanel.tMomentProperty.setValue(tMomentProperty);
    }

    public static void setTWeight(double tWeightProperty) {
        DataPanel.tWeightProperty.setValue(tWeightProperty);
    }

    
}
