package cargoplanner;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.Cursor;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;
import javafx.scene.Parent;

/**
 * the image displayed on cargo containers
 * @author Abhilshit Soni
 */
public class ULDImageNode extends Parent {

    ImageView uldImage = new ImageView();

    public ULDImageNode() {
        Image image = new Image("/images/pallet.JPG", 53, 50, true, true);

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
        getChildren().addAll(uldImage);
    }
}
