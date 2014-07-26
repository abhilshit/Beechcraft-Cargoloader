package cargoplanner;

import cargoplanner.dnd.DroppableNode;
import javafx.scene.effect.DropShadowBuilder;
import javafx.scene.effect.InnerShadowBuilder;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.Rectangle;

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
                new Stop[]{new Stop(0, Color.BLACK), new Stop(1, Color.BLACK)}));
        rectangle.setCache(true);
        rectangle.setArcHeight(5);
        rectangle.setArcWidth(5);
        rectangle.setOpacity(0.4);
        
//        rectangle.setEffect(InnerShadowBuilder.create().offsetX(1).
//                offsetY(1).
//                radius(1).
//                color(Color.rgb(0, 0, 0, 0.)).
//                input(DropShadowBuilder.create().offsetX(1).
//                offsetY(1).
//                radius(1).
//                color(Color.RED).
//                build()).
//                build());
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
