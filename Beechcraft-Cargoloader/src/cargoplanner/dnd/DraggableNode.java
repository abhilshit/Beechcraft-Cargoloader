package cargoplanner.dnd;

import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.util.Duration;

/**
 *
 * @author abhilshit
 */
public class DraggableNode extends Parent {

    /**
     * The data object owned by this draggable
     */
    private Object dataObject = null;
    /**
     * the reference to the droppable node
     */
    public DroppableNode droppableNode;
    public BooleanProperty dragAnimate = new SimpleBooleanProperty(true);
    public DoubleProperty initialTransX = new SimpleDoubleProperty();
    public DoubleProperty initialTransY = new SimpleDoubleProperty();
    public DoubleProperty currTransX = new SimpleDoubleProperty();
    public DoubleProperty currTransY = new SimpleDoubleProperty();
    public BooleanProperty dropIndicator = new SimpleBooleanProperty(false);
    public BooleanProperty isDragged = new SimpleBooleanProperty(false);
    public BooleanProperty isDropped = new SimpleBooleanProperty(false);
    public BooleanProperty isReleased = new SimpleBooleanProperty(true);
    public boolean otherNodesDraggable = true;
    public static ObservableList<DroppableNode> allDroppables = FXCollections.observableArrayList();
    public static ObservableList<DraggableNode> allDraggables = FXCollections.observableArrayList();
    public Timeline comeBack = new Timeline();
    public double onDragScalePercentage = 25;
    public boolean removeOnRelease = false;
    //public ScaleTransition scaleTransition =  null;

    public final DraggableNode getThis() {
        return this;
    }

    public DraggableNode() {
        // scaleTransition = ScaleTransitionBuilder.create().node(getThis()).byX(-25).byY(-25).delay(new Duration(5000)).build();
        EventHandler onScaleTransitionFinished = new EventHandler() {

            @Override
            public void handle(Event t) {

                getThis().
                        setLayoutX(currTransX.doubleValue());
                getThis().
                        setLayoutY(currTransY.doubleValue());
                getThis().
                        setVisible(true);

                ((Node) t.getSource()).setVisible(false);

            }
        };
//        this.scaleTransition.onFinishedProperty().setValue(onScaleTransitionFinished);
//        
//        EventHandler onFrame1Finished = new EventHandler() {
//
//            public void handle(Event t) {
//                blockMouseActions();
//            }
//        };
        EventHandler onFrame2Finished = new EventHandler() {

            @Override
            public void handle(Event t) {
                resumeMouseActions();
            }
        };
//        this.setTranslateX(x);
        //      this.setTranslateY(y);
        initialTransX.setValue(this.getTranslateX());
        initialTransY.setValue(this.getTranslateY());

        comeBack.getKeyFrames().
                addAll(new KeyFrame(Duration.valueOf("200ms"), onFrame2Finished,
                                new KeyValue(translateXProperty(), initialTransX.getValue(),
                                        Interpolator.EASE_BOTH),
                                new KeyValue(translateYProperty(), initialTransY.getValue(),
                                        Interpolator.EASE_BOTH)));

        this.setOnMouseDragged(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent t) {

                onNodeMouseDragged(t);
            }
        });

        this.setOnMouseReleased(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent t) {
                onNodeMouseReleased(t);
            }
        });

        this.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent t) {
                if (t.getClickCount() == 2) {
                    revertBack();
                }
            }
        });

        this.setOnMouseExited(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent arg0) {
                if (!isDragged.getValue() && !isDropped.getValue() && isReleased.getValue()) {
                    if (isReleased.getValue()) {
                        removeFromRoot();
                    }
                }
            }
        });
    }

    private void blockMouseActions() {
        PseudoDraggable.canDrag = false;
        for (DraggableNode draggable : allDraggables) {

            if (!draggable.equals(this)) {
                draggable.setMouseTransparent(true);
            }
        }
        otherNodesDraggable = false;
    }

    private void resumeMouseActions() {
        PseudoDraggable.canDrag = true;
        isReleased.setValue(true);
        for (DraggableNode draggable : allDraggables) {

            if (!draggable.equals(this)) {
                draggable.setMouseTransparent(false);
            }
        }
        otherNodesDraggable = false;
    }

    private void updateVariables(Double transX, Double transY, final MouseEvent e) {
        dropIndicator.setValue(false);
        currTransX.setValue(transX);
        currTransY.setValue(transY);
        if (allDroppables.isEmpty()) {
            Thread draggableCountUpdater = new Thread() {

                @Override
                public void run() {
                    addDraggablesDroppables(((Parent) e.getSource()).getScene());
                }
            };
            draggableCountUpdater.start();
        }
        for (DroppableNode i : allDroppables) {
            if ((i.getBoundsInParent().
                    contains(e.getSceneX(), e.getSceneY()))) {
                if (i.getDataObject() == null) {
                    droppableNode = i;
                    dropIndicator.setValue(true);
                    break;
                }
            }
        }
    }

    private void addDraggablesDroppables(Scene scene) {
        if (scene != null) {
            for (Node node : scene.getRoot().
                    getChildrenUnmodifiable()) {
                addDraggablesDroppables(node);
            }
        } else {
            System.out.println("hi");
        }
    }

    private void addDraggablesDroppables(Node node) {
        if (node instanceof DraggableNode) {
            allDraggables.add((DraggableNode) node);
        } else if (node instanceof DroppableNode) {
            allDroppables.add((DroppableNode) node);
        }
        if (node instanceof Parent) {
            Parent parent = (Parent) node;
            for (Node child : parent.getChildrenUnmodifiable()) {
                addDraggablesDroppables(child);
            }
        }
    }

    private void onNodeMouseDragged(MouseEvent e) {
        if (isDropped.getValue()) {
            this.setDataObject(droppableNode.getDataObject());
            droppableNode.setDataObject(null);
            isDropped.setValue(false);
        }
        if (otherNodesDraggable) {
            blockMouseActions();
        }
        setIsDragged(true);
        toFront();
        setTranslateX(e.getSceneX() - (this.getLayoutBounds().
                getWidth() / 2));
        setTranslateY(e.getSceneY() - (this.getLayoutBounds().
                getHeight() / 2));
        this.setOpacity(0.5);
        isReleased.setValue(false);
        updateVariables(getTranslateX(), getTranslateY(), e);
    }

    private void onNodeMouseReleased(MouseEvent e) {
        if (dropIndicator.getValue()) {
            setTranslateX(droppableNode.getTranslateX());
            setTranslateY(droppableNode.getTranslateY());
            droppableNode.setDataObject(this.dataObject);
            //this.dataObject = null;
            droppableNode.onDrop();
            isDropped.setValue(true);
        } else {
            if (isDragged.getValue()) {
                if (isDropped.getValue()) {
                    // println("revert");
                    revert();
                } else {
                    // println("reset");
                    reset();
                    if (droppableNode != null) {
                        droppableNode.onRevert();
                    }
                }
            }
        }
        isDragged.setValue(false);
        setOpacity(1);
        resumeMouseActions();
    }

    /**
     * performs the revert action.
     */
    protected void revert() {
        this.setDataObject(droppableNode.getDataObject());
        droppableNode.setDataObject(null);
        droppableNode.onRevert();
        reset();
    }

    public void reset() {
        dropIndicator.setValue(false);
        if (dragAnimate.getValue()) {
            if (removeOnRelease) {
                comeBack.setOnFinished(new EventHandler<ActionEvent>() {

                    @Override
                    public void handle(ActionEvent event) {
                        removeFromRoot();
                    }
                });
            }
            //comeBack.evaluateKeyValues();
            comeBack.playFromStart();

        } else {
            if (removeOnRelease) {

                removeFromRoot();
            }
        }
        //setTranslateX(initialTransX.getValue());
        //setTranslateY(initialTransY.getValue());
    }

    public void removeFromRoot() {
        if (this.getScene() != null) {
            Group root = (Group) this.getScene().
                    getRoot();
            if (root.getChildren().
                    contains(this)) {
                try {
                    root.getChildren().
                            remove(this);
                } catch (IndexOutOfBoundsException e) {
                    Logger.getLogger(this.getClass().getName()).info("Element was already removed");
                }
            }
        }
    }

    public void revertBack() {
        if (dropIndicator.getValue()) {
            isDropped.setValue(false);
            revert();
        }
    }

    public BooleanProperty isDroppedModel() {
        return isDropped;
    }

    public boolean getIsDropped() {
        return isDropped.getValue();
    }

    public void setIsDropped(boolean value) {
        isDropped.setValue(value);
    }

    public BooleanProperty isDraggedModel() {
        return isDragged;
    }

    public boolean getIsDragged() {
        return isDragged.getValue();
    }

    public void setIsDragged(boolean value) {
        isDragged.setValue(value);
    }

    public DoubleProperty currTransYModel() {
        return currTransY;
    }

    public double getCurrTransY() {
        return currTransY.getValue();
    }

    public void setCurrTransY(double value) {
        currTransY.setValue(value);
    }

    public DoubleProperty currTransXModel() {
        return currTransX;
    }

    public double getCurrTransX() {
        return currTransX.getValue();
    }

    public void setCurrTransX(double value) {
        currTransX.setValue(value);
    }

    public DoubleProperty initialTransYModel() {
        return initialTransY;
    }

    public double getInitialTransY() {
        return initialTransY.getValue();
    }

    public void setInitialTransY(double value) {
        initialTransY.setValue(value);
    }

    public DoubleProperty initialTransXModel() {
        return initialTransX;
    }

    public double getInitialTransX() {
        return initialTransX.getValue();
    }

    public void setInitialTransX(double value) {
        initialTransX.setValue(value);
    }

    public BooleanProperty dragAnimateModel() {
        return dragAnimate;
    }

    public boolean getDragAnimate() {
        return dragAnimate.getValue();
    }

    public void setDragAnimate(boolean value) {
        dragAnimate.setValue(value);
    }

    public BooleanProperty dropIndicatorModel() {

        return dropIndicator;
    }

    public boolean getDropIndicator() {
        return dropIndicator.getValue();
    }

    public void setDropIndicator(boolean value) {
        dropIndicator.setValue(value);
    }

    public Object getDataObject() {
        return dataObject;
    }

    public void setDataObject(Object dataObject) {
        this.dataObject = dataObject;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
