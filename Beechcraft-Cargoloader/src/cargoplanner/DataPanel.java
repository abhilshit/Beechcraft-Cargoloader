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
        gridPanel.setLayoutX(-25);
        gridPanel.setLayoutY(-31);
        gridPanel.setPrefHeight(390);
        gridPanel.setPrefWidth(325);
        gridPanel.setMouseTransparent(false);
        TableColumn parameterColumn = new TableColumn();
        parameterColumn.setText("Parameter");
        parameterColumn.setCellValueFactory(new PropertyValueFactory<ParameterValues, String>("parameter"));
        parameterColumn.setMinWidth(170);
        TableColumn valueColumn = new TableColumn();
        valueColumn.setText("Value");
        valueColumn.setMinWidth(150);
        valueColumn.setCellValueFactory(new PropertyValueFactory<ParameterValues, String>("value"));
        gridPanel.getColumns().addAll(parameterColumn, valueColumn);
        gridPanel.setItems(paramValues);
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
