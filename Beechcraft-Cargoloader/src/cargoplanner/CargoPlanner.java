package cargoplanner;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author abhilshit
 */
public class CargoPlanner extends Application {


    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Application.launch(CargoPlanner.class, args);
    }

    @Override
    public void start(Stage primaryStage) {
        AppRoot root = new AppRoot();
        Scene scene = new Scene(root, AppProperties.width, AppProperties.height, AppProperties.sceneFill);
        scene.getStylesheets().add("cargoplanner.css");

        primaryStage.setScene(scene);
        primaryStage.show();
    }
   
}
