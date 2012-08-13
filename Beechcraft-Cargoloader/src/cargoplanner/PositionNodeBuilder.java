
package cargoplanner;

/**
 *
 * @author abhilshit
 */
public class PositionNodeBuilder {
    private String id =null;
    private double fuselageStation = -1;
    private double translateX = 0;
    private double translateY = 0;
    public PositionNodeBuilder id(String id)
    {
        this.id=id;
        return this;
    }
    public PositionNodeBuilder fuselageStation(double fuselageStation)
    {
        this.fuselageStation= fuselageStation;
        return this;
    }
    public PositionNodeBuilder translateX(double translateX)
    {
        this.translateX=translateX;
        return this;
    }
    public PositionNodeBuilder translateY(double translateY)
    {
        this.translateY=translateY;
        return this;
    }
    public PositionNode build()
    {
        PositionNode position = new PositionNode();
        position.setId(this.id);
        position.setFuselageStation(this.fuselageStation);
        position.setTranslateX(this.translateX);
        position.setTranslateY(this.translateY);
        return position;
    }
}
