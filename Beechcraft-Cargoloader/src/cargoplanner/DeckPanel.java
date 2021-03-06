package cargoplanner;

import javafx.scene.Group;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;
import javafx.scene.shape.LineBuilder;

/**
 * the panel that contains horizontal crosssection view of the aircraft where
 * there are positions to place cargo containers.
 *
 * @author Abhilshit Soni
 */
public class DeckPanel extends Pane {

    public DeckPanel() {

        PositionNode irPos = new PositionNodeBuilder().id("IR").
                fuselageStation(465).
                translateX(Properties.startX).
                translateY(Properties.startY).
                build();
        PositionNode hrPos = new PositionNodeBuilder().id("HR").
                fuselageStation(435).
                translateX(Properties.startX + Properties.width + 5).
                translateY(Properties.startY).
                build();
        PositionNode grPos = new PositionNodeBuilder().id("GR").
                fuselageStation(405).
                translateX(Properties.startX + ((Properties.width + 5) * 2)).
                translateY(Properties.startY).
                build();
        PositionNode frPos = new PositionNodeBuilder().id("FR").
                fuselageStation(375).
                translateX(Properties.startX + ((Properties.width + 5) * 3)).
                translateY(Properties.startY).
                build();
        PositionNode erPos = new PositionNodeBuilder().id("ER").
                fuselageStation(345).
                translateX(Properties.startX + ((Properties.width + 5) * 4)).
                translateY(Properties.startY).
                build();
        PositionNode drPos = new PositionNodeBuilder().id("DR").
                fuselageStation(315).
                translateX(Properties.startX + ((Properties.width + 5) * 5)).
                translateY(Properties.startY).
                build();
        PositionNode crPos = new PositionNodeBuilder().id("CR").
                fuselageStation(285).
                translateX(Properties.startX + ((Properties.width + 5) * 6)).
                translateY(Properties.startY).
                build();
        PositionNode brPos = new PositionNodeBuilder().id("BR").
                fuselageStation(255).
                translateX(Properties.startX + ((Properties.width + 5) * 7)).
                translateY(Properties.startY).
                build();
        PositionNode arPos = new PositionNodeBuilder().id("AR").
                fuselageStation(225).
                translateX(Properties.startX + ((Properties.width + 5) * 8)).
                translateY(Properties.startY).
                build();


        PositionNode ilPos = new PositionNodeBuilder().id("IL").
                fuselageStation(465).
                translateX(Properties.startX).
                translateY(Properties.leftStartY).
                build();
        PositionNode hlPos = new PositionNodeBuilder().id("HL").
                fuselageStation(435).
                translateX(Properties.startX + Properties.width + 5).
                translateY(Properties.leftStartY).
                build();
        PositionNode glPos = new PositionNodeBuilder().id("GL").
                fuselageStation(405).
                translateX(Properties.startX + ((Properties.width + 5) * 2)).
                translateY(Properties.leftStartY).
                build();
        PositionNode flPos = new PositionNodeBuilder().id("FL").
                fuselageStation(375).
                translateX(Properties.startX + ((Properties.width + 5) * 3)).
                translateY(Properties.leftStartY).
                build();
        PositionNode elPos = new PositionNodeBuilder().id("EL").
                fuselageStation(345).
                translateX(Properties.startX + ((Properties.width + 5) * 4)).
                translateY(Properties.leftStartY).
                build();
        PositionNode dlPos = new PositionNodeBuilder().id("DL").
                fuselageStation(315).
                translateX(Properties.startX + ((Properties.width + 5) * 5)).
                translateY(Properties.leftStartY).
                build();
        PositionNode clPos = new PositionNodeBuilder().id("CL").
                fuselageStation(285).
                translateX(Properties.startX + ((Properties.width + 5) * 6)).
                translateY(Properties.leftStartY).
                build();
        PositionNode blPos = new PositionNodeBuilder().id("BL").
                fuselageStation(255).
                translateX(Properties.startX + ((Properties.width + 5) * 7)).
                translateY(Properties.leftStartY).
                build();
        PositionNode alPos = new PositionNodeBuilder().id("AL").
                fuselageStation(225).
                translateX(Properties.startX + ((Properties.width + 5) * 8)).
                translateY(Properties.leftStartY).
                build();

        setId("draggableContainer");
        this.setManaged(true);
        Group bgScalegroup = new Group();
        for(double i=(Properties.startX-5);i<(((Properties.width+10)*12)+5);i=i+5)
        {
            Line verticalBGLine = LineBuilder.create().startX(i).opacity(0.3).startY(Properties.startY-50).endX(i).endY((Properties.startY+Properties.height*2)+90).strokeWidth(0.5).build(); 
            bgScalegroup.getChildren().add(verticalBGLine);
        }
        for(double i=(Properties.startY-50);i<(((Properties.height)*4)-10);i=i+5)
        {
            Line horizontalBGLine = LineBuilder.create().startX(Properties.startX-5).opacity(0.3).startY(i).endX((Properties.startX+Properties.width*9)+90).endY(i).strokeWidth(0.5).build(); 
            bgScalegroup.getChildren().add(horizontalBGLine);
        }
        this.getChildren().
                addAll(bgScalegroup,irPos, hrPos, grPos, frPos, erPos, drPos, crPos, brPos,
                arPos, ilPos, hlPos, glPos, flPos, elPos, dlPos, clPos, blPos,
                alPos);

    }
}
