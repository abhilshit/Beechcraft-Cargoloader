package cargoplanner;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.scene.Cursor;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextBuilder;

/**
 * the border that highlights on the mouse hover event on cargo containers or unit load devices (ULD)
 * @author Abhilshit Soni
 */
public class ULDBorderNode extends Parent {

    // private Tooltip toolTip = new Tooltip("ULD ID: 56746LX");
    private ObjectProperty<Color> borderFill = new SimpleObjectProperty<Color>(
            AppProperties.uldColor);
    private Rectangle uldBorder = new Rectangle(100, 97, borderFill.getValue());
    Group group = new Group();
    public Text weightText = TextBuilder.create().cache(true).
            font(new Font(12)).
            x(20).
            y(20).
            text("").
            fill(Color.WHITE).
            build();

    public ULDBorderNode() {
        borderFill.addListener(new ChangeListener<Color>() {

            @Override
            public void changed(ObservableValue<? extends Color> observable,
                    Color oldValue, Color newValue) {
                uldBorder.setFill(newValue);
            }
        });
        uldBorder.setArcHeight(5);
        uldBorder.setArcWidth(5);
        uldBorder.setOnMouseEntered(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {
                setBorderFill(AppProperties.uldHoverColor);
                uldBorder.setCursor(Cursor.HAND);
//                toolTip.show(new Popup());
                // toolTip.doAutoHide();
            }
        });
        uldBorder.setOnMouseExited(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {
                setBorderFill(AppProperties.uldColor);
                uldBorder.setCursor(Cursor.DEFAULT);
                //toolTip.hide();
            }
        });

        uldBorder.setOnMouseDragged(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {
                //toolTip.hide();
            }
        });
        group.getChildren().
                addAll(uldBorder, weightText);
        getChildren().
                addAll(group);
    }

    public ObjectProperty<Color> borderFillModel() {
        return borderFill;
    }

    public Color getBorderFill() {
        return borderFill.getValue();
    }

    public void setBorderFill(Color border) {
        borderFill.setValue(border);
    }
}
