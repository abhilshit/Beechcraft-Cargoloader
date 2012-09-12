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
       
        try {
            this.addColumn(0,new ULDNode(new PseudoULDNode(new ULD(400), true)),
                    new ULDNode(new PseudoULDNode(new ULD(200), true)),
                    new ULDNode(new PseudoULDNode(new ULD(100), true)),
                    new ULDNode(new PseudoULDNode(new ULD(426), true)),
                    new ULDNode(new PseudoULDNode(new ULD(120), true)),
                    new ULDNode(new PseudoULDNode(new ULD(240), true)),
                    new ULDNode(new PseudoULDNode(new ULD(357), true)),
                    new ULDNode(new PseudoULDNode(new ULD(470), true)),
                    new ULDNode(new PseudoULDNode(new ULD(229), true)));
            this.addColumn(1,new ULDNode(new PseudoULDNode(new ULD(285), true)),
                    new ULDNode(new PseudoULDNode(new ULD(323), true)),
                    new ULDNode(new PseudoULDNode(new ULD(233), true)),
                    new ULDNode(new PseudoULDNode(new ULD(250), true)),
                    new ULDNode(new PseudoULDNode(new ULD(370), true)),
                    new ULDNode(new PseudoULDNode(new ULD(210), true)),
                    new ULDNode(new PseudoULDNode(new ULD(110), true)),
                    new ULDNode(new PseudoULDNode(new ULD(250), true)),
                    new ULDNode(new PseudoULDNode(new ULD(218), true)));
//            this.getChildren().
//                    addAll(
//                    );
        } catch (DraggableNotFoundException ex) {
            Logger.getLogger(ULDList.class.getName()).
                    log(Level.SEVERE, null, ex);
        }
    }
}
