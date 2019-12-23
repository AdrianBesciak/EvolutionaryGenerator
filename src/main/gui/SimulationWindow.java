package gui;

import Maps.Vector2d;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
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
import javafx.util.Duration;
import json.StartValues;
import simulation.Simulation;

import java.awt.*;
import java.util.Timer;
import java.util.TimerTask;

public class SimulationWindow extends Application {

    private Stage window;
    private Scene initialScene;
    private Scene visualizationScene;
    private Simulation sim;
    private boolean play;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        window = primaryStage;

        initialScene = new Scene(addInitialValues());

        primaryStage.setScene(initialScene);
        primaryStage.setTitle("Evolutionary Generator");
        primaryStage.show();
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
                sim = new Simulation();
                visualizationScene = new Scene(addGridPane(sim));
                window.setScene(visualizationScene);
                window.show();
                play = true;

                new Timeline(new KeyFrame(
                        Duration.millis(500),
                        ae -> getNextFrame()))
                        .play();

            }
        });

        vbox.getChildren().add(btnRunSimulation);

        return vbox;
    }



    public GridPane addGridPane(Simulation sim)
    {
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10,10,10,10));
        grid.setVgap(5);
        grid.setHgap(5);
        grid.setGridLinesVisible(false);



        for (int x = 0; x < StartValues.getMapWidth(); x++)
            for (int y = 0; y < StartValues.getMapHeight(); y++)
            {
                Button placeButton;
                if (sim.map.listOfObjectsAt(new Vector2d(x,y)) == null || sim.map.listOfObjectsAt(new Vector2d(x,y)).size() == 0 || sim.map.listOfObjectsAt(new Vector2d(x,y)).get(0) == null)
                    placeButton = new Button("  ");
                else
                {
                    try
                    {
                        placeButton = new Button(sim.map.listOfObjectsAt(new Vector2d(x, y)).get(0).toString());
                    }
                    catch (NullPointerException ex)
                    {
                        placeButton = new Button("  ");
                    }
                    if (sim.map.listOfObjectsAt(new Vector2d(x, y)).size() > 1)
                        placeButton.setStyle("-fx-background-color: #000000;");
                }
                if ((new Vector2d(x,y)).precedes(sim.map.getJungleHigherCorner()) && (new Vector2d(x,y)).follows(sim.map.getJungleLowerCorner()))
                    placeButton.setStyle("-fx-background-color: #00AA00;");

                placeButton.setMinSize(40,30);
                grid.add(placeButton, y + 5, x);
            }
        Button pauseButton = new Button("Pause Simulation");
        Button playButton = new Button("Play Simulation");
        pauseButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                play = false;
                pauseButton.setVisible(false);
                playButton.setVisible(true);
            }
        });
        grid.add(pauseButton, StartValues.getMapHeight()/2 - 4, StartValues.getMapHeight() + 5, 4, 1);
        playButton.setVisible(false);
        playButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                play = true;
                playButton.setVisible(false);
                pauseButton.setVisible(true);
                getNextFrame();
            }
        });
        grid.add(playButton, StartValues.getMapHeight()/2 - 4, StartValues.getMapHeight() + 5, 4, 1);
        return grid;
    }

    public void getNextFrame() {
        if (play)
        {
            sim.nextDay();
            Scene nextVisualizationScene = new Scene(addGridPane(sim));
            window.setScene(nextVisualizationScene);
            window.show();
            new Timeline(new KeyFrame(
                    Duration.millis(500),
                    ae -> getNextFrame()))
                    .play();
        }

    };



}
