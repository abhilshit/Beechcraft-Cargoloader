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

import cargoplanner.envelope.DataUtil;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.Node;

/**
 * the load plan data objects which keeps the information of updated weight on
 * each position where a user can place cargo container.
 *
 * @author Abhilshit Soni
 */
public class PlanData {

    public static final double basicOperatingWeight = 9005;
    public static final double basicOperatingMoment = 2593400;
    public static final double basicCG = basicOperatingMoment / basicOperatingWeight;
    public static final double crewWeight = 340;
    public static final double crewMoment = 43900;
    public static final double fuelVolume = 385;
    public static final double burnOffFuelVolume = 380;
    public static final double fuelDensity = 6.8;
    public static final double fuelWeight = 2633;
    public static final double burnOffFuelWeight = 256800;
    public static final double burnOffFuelMoment = 7722;
    public static final double fuelMoment = 7866;
    public static final double initialTotalMoment = basicOperatingMoment + fuelMoment + crewMoment;
    public static final double initialTotalWeight = basicOperatingWeight + fuelWeight + crewWeight;
    public static final double initialCG = (initialTotalMoment - fuelMoment) / (initialTotalWeight - fuelWeight);
    public static double currentPlanWeight;
    public static double currentPlanMoment;
    public static double totalWeight;
    public static double totalMoment;
    /**
     * zero fuel center of gravity
     */
    public static double centerOfGravity;
    /**
     * take off center of gravity
     */
    public static double takeOffCG;
    /**
     * landing center of gravity
     */
    public static double landingCG;
    public static ObservableList<PositionNode> loadedPositions = FXCollections.observableArrayList();
    public static DoubleProperty weightAR = new SimpleDoubleProperty(0);
    public static DoubleProperty weightBR = new SimpleDoubleProperty(0);
    public static DoubleProperty weightCR = new SimpleDoubleProperty(0);
    public static DoubleProperty weightDR = new SimpleDoubleProperty(0);
    public static DoubleProperty weightER = new SimpleDoubleProperty(0);
    public static DoubleProperty weightFR = new SimpleDoubleProperty(0);
    public static DoubleProperty weightGR = new SimpleDoubleProperty(0);
    public static DoubleProperty weightHR = new SimpleDoubleProperty(0);
    public static DoubleProperty weightIR = new SimpleDoubleProperty(0);
    public static DoubleProperty weightAL = new SimpleDoubleProperty(0);
    public static DoubleProperty weightBL = new SimpleDoubleProperty(0);
    public static DoubleProperty weightCL = new SimpleDoubleProperty(0);
    public static DoubleProperty weightDL = new SimpleDoubleProperty(0);
    public static DoubleProperty weightEL = new SimpleDoubleProperty(0);
    public static DoubleProperty weightFL = new SimpleDoubleProperty(0);
    public static DoubleProperty weightGL = new SimpleDoubleProperty(0);
    public static DoubleProperty weightHL = new SimpleDoubleProperty(0);
    public static DoubleProperty weightIL = new SimpleDoubleProperty(0);

    public PlanData() {
        DataPanel.setCWeight(0);
        DataPanel.setCMoment(0);
        DataPanel.setTMoment(initialTotalMoment);
        DataPanel.setTWeight(initialTotalWeight);
        DataPanel.setCg(initialCG);
    }

    public static void update(DeckPanel deck) {
        double tempPlanWeight = 0;
        double tempPlanMoment = 0;
        loadedPositions.clear();
        for (Node i : deck.getChildren()) {
            if (i instanceof PositionNode) {
                        PositionNode position = (PositionNode) i;
                        Object obj = position.getDataObject();
                        position.setMoment(0);
                        if (obj != null) {
                            ULD uld = (ULD) obj;
                            position.setMoment(uld.getWeight() * position.getFuselageStation());
                            loadedPositions.add(position);
                            setPositionWeight(position.getId(), uld.getWeight());
                            // println("{i.id} has {uld.weight} kgs");
                            tempPlanWeight = tempPlanWeight + uld.getWeight();
                            tempPlanMoment = tempPlanMoment + position.getMoment();
                        } else {
                            setPositionWeight(position.getId(), 0);
                        }
                    }
        }
        currentPlanWeight = tempPlanWeight;
        currentPlanMoment = tempPlanMoment;
        totalWeight = currentPlanWeight + basicOperatingWeight + crewWeight + fuelWeight;
        totalMoment = currentPlanMoment + basicOperatingMoment + crewMoment + fuelMoment;
        centerOfGravity = (totalMoment - fuelMoment) / (totalWeight - fuelWeight);
        takeOffCG = totalMoment / totalWeight;
        landingCG = (totalMoment - burnOffFuelMoment) / (totalWeight - burnOffFuelWeight);
        DataPanel.setCMoment(currentPlanMoment);
        DataPanel.setCWeight(currentPlanWeight);
        DataPanel.setTMoment(totalMoment);
        DataPanel.setTWeight(totalWeight);
        DataPanel.setCg(centerOfGravity);
        DataPanel.updateParameters();
        DataUtil.populateCGData(totalWeight / 100, centerOfGravity);
        System.out.println(WeightCoverageChart.weightA.getValue());
    }

    public static void setPositionWeight(String positionID, double weight) {
        switch (positionID) {
            case "AR":
                weightAR.setValue(weight);
                break;
            case "AL":
                weightAL.setValue(weight);
                break;
            case "BR":
                weightBR.setValue(weight);
                break;
            case "BL":
                weightBL.setValue(weight);
                break;
            case "CR":
                weightCR.setValue(weight);
                break;
            case "CL":
                weightCL.setValue(weight);
                break;
            case "DR":
                weightDR.setValue(weight);
                break;
            case "DL":
                weightDL.setValue(weight);
                break;
            case "ER":
                weightER.setValue(weight);
                break;
            case "EL":
                weightEL.setValue(weight);
                break;
            case "FR":
                weightFR.setValue(weight);
                break;
            case "FL":
                weightFL.setValue(weight);
                break;
            case "GR":
                weightGR.setValue(weight);
                break;
            case "GL":
                weightGL.setValue(weight);
                break;
            case "HR":
                weightHR.setValue(weight);
                break;
            case "HL":
                weightHL.setValue(weight);
                break;
            case "IR":
                weightIR.setValue(weight);
                break;
            case "IL":
                weightIL.setValue(weight);
                break;
        }
    }
}
