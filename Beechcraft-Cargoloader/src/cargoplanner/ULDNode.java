package cargoplanner;

import cargoplanner.dnd.DraggableNotFoundException;
import cargoplanner.dnd.PseudoDraggable;
import javafx.scene.Group;

/**
 * the container that is draggable (consists of both the ULD image and the ULD border)
 * @author Abhilshit Soni
 */
public class ULDNode extends PseudoDraggable {

    public ULDImageNode uldImage = new ULDImageNode();
    public ULDBorderNode uldBorder = new ULDBorderNode();
    public PseudoULDNode pseudoULDNode = null;
          
    Group group = new Group();
    
    public ULDNode(PseudoULDNode pseudoULDNode) throws DraggableNotFoundException {
        super(pseudoULDNode);
        this.pseudoULDNode = pseudoULDNode;
        uldImage.setTranslateX(5);
        uldImage.setTranslateY(5);
        group.getChildren().addAll(uldBorder,uldImage);
        getChildren().addAll(group);
        configure();
    }
    
    private void configure()
    {
        this.pseudoULDNode.uldNode = this;
    }
      
}
