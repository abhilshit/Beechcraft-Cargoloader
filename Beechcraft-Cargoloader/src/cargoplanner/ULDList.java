/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cargoplanner;

import cargoplanner.dnd.DraggableNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.geometry.Pos;
import javafx.scene.layout.GridPane;

/**
 *
 * @author abhilshit
 */
public class ULDList extends GridPane {

    private static final double uldSpacing = 3;

    public ULDList() {
        this.setHgap(uldSpacing);
        this.setVgap(uldSpacing);
        this.setAlignment(Pos.CENTER);
        this.setId("uld-list");
        boolean dragAnimate = AppProperties.dragAnimate;
        try {

            this.addColumn(0, new ULDNode(new PseudoULDNode(new ULD(400), dragAnimate)),
                    new ULDNode(new PseudoULDNode(new ULD(200), dragAnimate)),
                    new ULDNode(new PseudoULDNode(new ULD(100), dragAnimate)),
                    new ULDNode(new PseudoULDNode(new ULD(426), dragAnimate)),
                    new ULDNode(new PseudoULDNode(new ULD(120), dragAnimate)),
                    new ULDNode(new PseudoULDNode(new ULD(240), dragAnimate)),
                    new ULDNode(new PseudoULDNode(new ULD(357), dragAnimate)),
                    new ULDNode(new PseudoULDNode(new ULD(470), dragAnimate)),
                    new ULDNode(new PseudoULDNode(new ULD(229), dragAnimate)));
            this.addColumn(1, new ULDNode(new PseudoULDNode(new ULD(285), dragAnimate)),
                    new ULDNode(new PseudoULDNode(new ULD(323), dragAnimate)),
                    new ULDNode(new PseudoULDNode(new ULD(233), dragAnimate)),
                    new ULDNode(new PseudoULDNode(new ULD(250), dragAnimate)),
                    new ULDNode(new PseudoULDNode(new ULD(370), dragAnimate)),
                    new ULDNode(new PseudoULDNode(new ULD(210), dragAnimate)),
                    new ULDNode(new PseudoULDNode(new ULD(110), dragAnimate)),
                    new ULDNode(new PseudoULDNode(new ULD(250), dragAnimate)),
                    new ULDNode(new PseudoULDNode(new ULD(218), dragAnimate)));
            this.addColumn(2, new ULDNode(new PseudoULDNode(new ULD(285), dragAnimate)),
                    new ULDNode(new PseudoULDNode(new ULD(323), dragAnimate)),
                    new ULDNode(new PseudoULDNode(new ULD(233), dragAnimate)),
                    new ULDNode(new PseudoULDNode(new ULD(250), dragAnimate)),
                    new ULDNode(new PseudoULDNode(new ULD(370), dragAnimate)),
                    new ULDNode(new PseudoULDNode(new ULD(210), dragAnimate)),
                    new ULDNode(new PseudoULDNode(new ULD(110), dragAnimate)),
                    new ULDNode(new PseudoULDNode(new ULD(250), dragAnimate)),
                    new ULDNode(new PseudoULDNode(new ULD(218), dragAnimate)));
//            this.getChildren().
//                    addAll(
//                    );
        } catch (DraggableNotFoundException ex) {
            Logger.getLogger(ULDList.class.getName()).
                    log(Level.SEVERE, null, ex);
        }
    }
}
