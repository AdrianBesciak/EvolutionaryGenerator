package gui;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class SimulationView extends Application {

    @Override
    public void start(Stage primaryStage) {

        StackPane root = new StackPane();
        //root.getChildren().add(btnRunSimulation);

        Scene scene = new Scene(root, 600, 400);

        primaryStage.setScene(scene);
        primaryStage.setTitle("Evolutionary Generator");
        primaryStage.show();
    }
}
