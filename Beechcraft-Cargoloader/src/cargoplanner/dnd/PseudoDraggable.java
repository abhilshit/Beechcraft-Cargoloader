/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cargoplanner.dnd;

import javafx.event.EventHandler;
import javafx.geometry.Point2D;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.input.MouseEvent;

/**
 *
 * @author abhilshit
 */
public class PseudoDraggable extends Parent {

    public static boolean canDrag = true;
    private DraggableNode draggable = null;

    public PseudoDraggable(DraggableNode draggableNode) throws
            DraggableNotFoundException {
        draggable = draggableNode;
        if (draggable == null) {
            throw new DraggableNotFoundException();
        }
        this.setOnMouseEntered(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent t) {

                onMouseEntered(t);
            }
        });

        this.setOnMouseExited(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent t) {

                onMouseOut(t);
            }
        });
    }

    private void onMouseOut(MouseEvent e) {
    }

    private void onMouseEntered(MouseEvent e) {
        if (canDrag) {
            Group root = (Group) this.getScene().
                    getRoot();
            PseudoDraggable source = ((PseudoDraggable) e.getSource());
            if (!root.getChildren().
                    contains(draggable)) {
                Point2D point = source.localToScene(source.getBoundsInLocal().
                        getMinX(), source.getBoundsInLocal().
                        getMinY());
                draggable.setTranslateX(point.getX());
                draggable.setTranslateY(point.getY());
                root.getChildren().
                        add(draggable);
            }
        }
    }
}
