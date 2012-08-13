package cargoplanner;

import java.util.Arrays;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradientBuilder;
import javafx.scene.paint.Paint;
import javafx.scene.paint.Stop;

/**
 *
 * @author abhilshit
 */
public class AppProperties {

    public static double width = 1024;
    public static double height = 700;
    private final static Stop[] sceneFillStops = {new Stop(0, Color.WHITE),
        new Stop(0.5, Color.web("#C8EBFE")), new Stop(1, Color.WHITE)};
    public static Paint sceneFill = LinearGradientBuilder.create().cycleMethod(CycleMethod.REFLECT).stops(Arrays.
            asList(sceneFillStops)).
            build();
    public static Color uldColor = Color.CADETBLUE;
    public static Color uldHoverColor = Color.ORANGE;
}
