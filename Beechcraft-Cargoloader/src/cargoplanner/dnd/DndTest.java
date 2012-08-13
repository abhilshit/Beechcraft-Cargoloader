/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cargoplanner.dnd;

import cargoplanner.ULDNode;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author abhilshit
 */
public class DndTest extends Application {

    ObservableList<DraggableNode> allDraggables = FXCollections.observableArrayList();
    ObservableList<DroppableNode> allDroppables = FXCollections.observableArrayList();

    public static void main(String[] args) {
        Application.launch(DndTest.class, args);
    }

    @Override
    public void start(Stage stage) {
        stage.setResizable(false);
        stage.setTitle("Beechcraft Cargoloader - 1.1");
        final Group root = new Group();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        ObservableList<Node> nodes = root.getChildren();
        
       
       final SampleDraggableNode draggable1 = new SampleDraggableNode(20,20);
        draggable1.setDragAnimate(true);
        draggable1.setDataObject(12);
        

        SampleDroppableNode droppable1 = new SampleDroppableNode();
        droppable1.setTranslateX(200);
        droppable1.setTranslateY(200);

//        ULDNode uLDNode = new ULDNode(100, 100,null,true);
//        uLDNode.setDragAnimate(true);
//        uLDNode.setDataObject(12);
        
        SampleDroppableNode droppable2 = new SampleDroppableNode();
        droppable2.setTranslateX(400);
        droppable2.setTranslateY(400);

        SampleDroppableNode droppable3 = new SampleDroppableNode();
        droppable3.setTranslateX(100);
        droppable3.setTranslateY(400);


        nodes.add(draggable1);
       // nodes.add(uLDNode);
        nodes.add(droppable1);
        nodes.add(droppable2);
        nodes.add(droppable3);
        addDraggablesDroppables(scene);
        stage.show();
    }

    
    private void addDraggablesDroppables(Scene scene)
    {
        for (Node node : scene.getRoot().getChildrenUnmodifiable()) {
            if (node instanceof DraggableNode) {
                allDraggables.add((DraggableNode) node);
            }
            else if(node instanceof DroppableNode) {
                allDroppables.add((DroppableNode) node);
            }
        }
        for(DraggableNode draggableNode:allDraggables)
        {
            draggableNode.allDraggables.addAll(allDraggables);
            draggableNode.allDroppables.addAll(allDroppables);
        }
    }

}
