package cargoplanner;

import java.io.InputStream;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.Cursor;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;
import javafx.scene.Parent;

/**
 * the image displayed on cargo containers
 *
 * @author Abhilshit Soni
 */
public class ULDImageNode extends Parent {

    ImageView uldImage = new ImageView();

    public ULDImageNode() {
        InputStream in = getClass().getResourceAsStream("images/pallet.png");
        Image image = new Image(in, 53, 50, true, true);
        this.setMouseTransparent(true);
        uldImage.setCache(true);
        uldImage.setImage(image);

        uldImage.setOnMouseEntered(new EventHandler<MouseEvent>() {
            public void handle(MouseEvent event) {
                uldImage.setCursor(Cursor.HAND);
            }
        });

        uldImage.setOnMouseExited(new EventHandler<MouseEvent>() {
            public void handle(MouseEvent event) {
                uldImage.setCursor(Cursor.DEFAULT);
            }
        });

        uldImage.setOnMouseReleased(new EventHandler<MouseEvent>() {
            public void handle(MouseEvent event) {
//                if (event.getClickCount() >= 2) {
//                 
//                    Node parent = uldImage.getParent().getParent().getParent();
//                    if(parent instanceof PseudoULDNode)
//                    {
//                        PseudoULDNode puldn = (PseudoULDNode)parent;
//                        puldn.removeNode();
//                    }
//                }
            }
        });
        getChildren().addAll(uldImage);
    }
}
