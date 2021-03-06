package cargoplanner;

import cargoplanner.dnd.DraggableNode;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;

/**
 *
 * @author abhilshit
 */
public class PseudoULDNode extends DraggableNode {
    
    public ULDImageNode uldImage = new ULDImageNode();
    public ULDBorderNode uldBorder = new ULDBorderNode();
    
    public ULDNode uldNode = null;
    GridPane uldList = null;
    Group group = new Group();
    
    public PseudoULDNode(Object data, boolean dragAnimate) {
        removeOnRelease = true;
        super.setDataObject(data);
        super.setDragAnimate(dragAnimate);
        uldImage.setTranslateX(5);
        uldImage.setTranslateY(5);
        super.setDataObject(data);
        uldBorder.weightText.setText(((ULD)data).getWeight()+" lbs");
        uldImage.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                uldBorder.setBorderFill(AppProperties.uldHoverColor);
                //resetColor();
            }
        });
        uldImage.setOnMouseExited(new EventHandler<MouseEvent>() {
            
            @Override
            public void handle(MouseEvent event) {
                uldBorder.setBorderFill(AppProperties.uldColor);
               // resetColor();
                //toolTip.hide();
            }
        });
        uldBorder.setOnMouseDragged(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if (uldNode != null) {
                    if (uldNode.getParent() != null) {
                        uldList = (GridPane) uldNode.getParent();
                    }
                    if (uldList != null && uldList.getChildren().contains(uldNode)) {
                        uldList.getChildren().remove(uldNode);
                        uldList.requestLayout();
                    }
                }
                if (getDropIndicator()) {
                    uldBorder.setBorderFill(Color.GREEN);
                } else {
                    uldBorder.setBorderFill(Color.ORANGE);
                }
            }
        });
        
        uldBorder.setOnMouseReleased(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if (!getDropIndicator() || getIsDropped()) {
                    System.out.println("click count " + event.getClickCount());
                    if (getIsDropped() && event.getClickCount() < 2) {
                        return;
                    }
                    removeNode();
                }
                 group.requestLayout();
            }
           
        });
        
        group.getChildren().addAll(uldBorder,uldImage);
        getChildren().addAll(group);
    }
    
    public void removeNode() {
        if (uldList != null) {
            if (!uldList.getChildren().contains(uldNode)) {
                uldList.getChildren().add(uldNode);
                uldList.requestLayout();
                uldBorder.setBorderFill(AppProperties.uldColor);
            }
        }
        
    }
    public void resetColor() {
        for (Node node : uldList.getChildren()) {
            ULDNode currentULDNode = (ULDNode) node;
            if (!currentULDNode.equals(uldNode)) {
                currentULDNode.pseudoULDNode.uldBorder.setBorderFill(AppProperties.uldColor);
            }
        }
    }
}
