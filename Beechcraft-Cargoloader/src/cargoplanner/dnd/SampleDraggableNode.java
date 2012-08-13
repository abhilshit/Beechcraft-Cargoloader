/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package cargoplanner.dnd;

import javafx.scene.shape.Rectangle;

/**
 *
 * @author abhilshit
 */
public class SampleDraggableNode extends DraggableNode{

    Rectangle rectangle= new Rectangle(110,90);
    public SampleDraggableNode(double x,double y) {
       // super(x,y);
            getChildren().add(rectangle);
    }

}
