package gui;

import Maps.Vector2d;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.VPos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import json.StartValues;
import simulation.Simulation;

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
        HBox border = new HBox();
        border.getChildren().addAll(addInitialValues(), addGridPane());


      //  Scene scene = new Scene(border, 1024, 720);
        Scene scene = new Scene(border);

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

    public VBox addInitialValues()
    {
        VBox vbox = new VBox();
        vbox.setPadding( new Insets(10));
        vbox.setSpacing(8);

        Text title = new Text("Setup beginning of the simulation");
        title.setFont(Font.font("Arial", FontWeight.BOLD, 14));
        vbox.getChildren().add(title);

        StartValues values = new StartValues();

        vbox.getChildren().add(GUILabelAndTextField.AddLabelAndTextField("Map width", values.getMapWidth()));
        vbox.getChildren().add(GUILabelAndTextField.AddLabelAndTextField("Map height", values.getMapHeight()));
        vbox.getChildren().add(GUILabelAndTextField.AddLabelAndTextField("Jungle relation to map (%)", values.getJungleRelationToMap()));
        vbox.getChildren().add(GUILabelAndTextField.AddLabelAndTextField("Animal energy on start", values.getEnergyOnStart()));
        vbox.getChildren().add(GUILabelAndTextField.AddLabelAndTextField("Energy used to move", values.getDailyUsedEnergy()));
        vbox.getChildren().add(GUILabelAndTextField.AddLabelAndTextField("Energy from tree", values.getEnergyOfTree()));
        vbox.getChildren().add(GUILabelAndTextField.AddLabelAndTextField("Animals at the beginning of simulation", values.getAnimalsOnStart()));

        Button btnRunSimulation = new Button("Run Simulation");
        btnRunSimulation.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                System.out.println("start the simulation");

            }
        });

        vbox.getChildren().add(btnRunSimulation);

        return vbox;
    }

    public GridPane addGridPane()
    {
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10,10,0,10));
        grid.setVgap(5);
        grid.setHgap(5);
        grid.setGridLinesVisible(false);


        Simulation sim = new Simulation();


        for (int x = 0; x < StartValues.getMapWidth(); x++)
            for (int y = 0; y < StartValues.getMapHeight(); y++)
            {
                Button placeButton;
                if (sim.map.listOfObjectsAt(new Vector2d(x,y)) == null || sim.map.listOfObjectsAt(new Vector2d(x,y)).size() == 0)
                    placeButton = new Button("  ");
                else
                    placeButton = new Button(sim.map.listOfObjectsAt(new Vector2d(x, y)).get(0).toString());
                if ((new Vector2d(x,y)).precedes(sim.map.getJungleHigherCorner()) && (new Vector2d(x,y)).follows(sim.map.getJungleLowerCorner()))
                    placeButton.setStyle("-fx-background-color: #00AA00;");

                placeButton.setMinSize(40,30);
                grid.add(placeButton, y + 5, x);
            }
        return grid;
    }





}
