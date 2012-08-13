/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package cargoplanner.dnd;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 *
 * @author abhilshit
 */
public class SampleDroppableNode extends DroppableNode{

    Rectangle rectangle = new Rectangle(120, 100);
    public SampleDroppableNode() {
        rectangle.fillProperty().setValue(Color.RED);
        getChildren().add(rectangle);
    }

}
