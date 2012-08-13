package cargoplanner.dnd;

import javafx.scene.Parent;

/**
 *
 * @author abhilshit
 */
public class DroppableNode extends Parent {

    private Object dataObject = null;

    public Object getDataObject() {
        return dataObject;
    }

    public void setDataObject(Object dataObject) {
        this.dataObject = dataObject;
    }

    public void onDrop() {
    }

    public void onRevert() {
    }
}
