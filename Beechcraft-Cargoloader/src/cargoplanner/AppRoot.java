/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cargoplanner;

import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.VPos;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.control.ScrollPane;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;

/**
 *
 * @author abhilshit
 */
public class AppRoot extends Group {

    private static DataPanel dataPanel = new DataPanel(270, 320);
    private static PlanData planData = new PlanData();
    private static DeckPanel deckPanel = getDeckPanel();
    private static GraphPanel graphPanel = new GraphPanel("graph");
    public static WeightCoverageChart weightCoverageChart = new WeightCoverageChart();
    private static  ScrollPane uldScrollPane = new ScrollPane();
    
    public AppRoot() {
        super();
        GridPane grid1 = new GridPane();
        grid1.setHgap(4);
        grid1.setVgap(6);

        grid1.setPadding(new Insets(18, 18, 18, 18));
        grid1.setGridLinesVisible(true);//set to false to erase grid lines
        ObservableList content = grid1.getChildren();

        ULDList uldList = new ULDList();
        uldScrollPane.setId("uld-list-scrollbar");
        uldScrollPane.setContent(uldList);
        uldScrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        uldScrollPane.setFocusTraversable(true);
        uldScrollPane.requestFocus();
        uldScrollPane.setPrefWidth(230);
        uldScrollPane.setPrefHeight(650);

        uldScrollPane.setOnKeyPressed(new EventHandler<KeyEvent>() {

            @Override
            public void handle(KeyEvent event) {
                if(event.getCode()==KeyCode.DOWN)
                {
                    uldScrollPane.setVvalue(uldScrollPane.getVvalue()+1);
                }
                if(event.getCode()==KeyCode.UP)
                {
                    uldScrollPane.setVvalue(uldScrollPane.getVvalue()-1);
                }
            }

           
        });


        GridPane.setConstraints(uldList, 6, 6);
        GridPane.setValignment(uldList, VPos.TOP);
        content.add(uldScrollPane);

        this.getChildren().addAll(dataPanel,graphPanel,weightCoverageChart,deckPanel, grid1);

    }

    private static DeckPanel getDeckPanel() {
        DeckPanel deck = new DeckPanel();
        deck.setId("deck");
        for (Node positionNode : deck.getChildren()) {
            PositionNode position = (PositionNode) positionNode;
            position.setPlanData(planData);
        }
        return deck;
    }
}
