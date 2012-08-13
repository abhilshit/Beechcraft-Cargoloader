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

import cargoplanner.dnd.DroppableNode;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.effect.DropShadowBuilder;
import javafx.scene.effect.InnerShadowBuilder;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.paint.CycleMethod;

/**
 * just a rectangle denoting a position on the aircrafts deck where a user can place cargo container.
 * @author Abhilshit Soni
 */
public class PositionNode extends DroppableNode {

    private PlanData planData = null;
    /**
     * distance to the centroid of this position from a reference point called datum (generally nose of aircraft)
     */
    private double fuselageStation;
    /**
     * moment = weight of the ULD placed on this position multiplied by fuselage station
     */
    private double moment;

    public PositionNode() {
        Rectangle rectangle = new Rectangle(Properties.width, Properties.height,
                new LinearGradient(0, 0, 0, 0, true, CycleMethod.NO_CYCLE,
                new Stop[]{new Stop(0, Color.RED), new Stop(1, Color.MAROON)}));
        rectangle.setCache(true);
        rectangle.setArcHeight(5);
        rectangle.setArcWidth(5);
        rectangle.setEffect(InnerShadowBuilder.create().offsetX(1).
                offsetY(1).
                radius(1).
                color(Color.rgb(0, 0, 0, 0.7)).
                input(DropShadowBuilder.create().offsetX(1).
                offsetY(1).
                radius(1).
                color(Color.RED).
                build()).
                build());
        getChildren().
                addAll(rectangle);
    }

    public double getFuselageStation() {
        return fuselageStation;
    }

    public void setFuselageStation(double fuselageStation) {
        this.fuselageStation = fuselageStation;
    }

    public double getMoment() {
        return moment;
    }

    public void setMoment(double moment) {
        this.moment = moment;
    }

    public PlanData getPlanData() {
        return planData;
    }

    public void setPlanData(PlanData planData) {
        this.planData = planData;
    }

    @Override
    public void onDrop() {
        System.out.println("updating");
        PlanData.update((DeckPanel) this.getParent());
    }

    @Override
    public void onRevert() {
        PlanData.update((DeckPanel) this.getParent());
    }
}
