package gui;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class SimulationWindow extends Application {
    private static final int TILE_SIZE = 40;
    private static final int HEIGHT = 800;
    private static final int WIDTH = 600;

    private static final int X_TILES = WIDTH / TILE_SIZE;
    private static final int Y_TILES = HEIGHT / TILE_SIZE;



    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Button btnRunSimulation = new Button("Run Simulation");
        btnRunSimulation.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                System.out.println("start the simulation");
            }
        });
        StackPane root = new StackPane();
        root.getChildren().add(btnRunSimulation);

        Scene scene = new Scene(root, 600, 400);

        primaryStage.setScene(scene);
        primaryStage.setTitle("Evolutionary Generator");
        primaryStage.show();
    }

    private Parent createContent()
    {
        Pane root = new Pane();
        root.setPrefSize(WIDTH,HEIGHT);

        return root;
    }
}
