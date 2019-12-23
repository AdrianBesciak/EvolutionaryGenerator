package gui;


import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.util.Pair;

import java.util.ArrayList;

public class GUILabelAndTextField {
    static ArrayList<Pair<String, Integer>> textFields = new ArrayList<>();
    public static VBox AddLabelAndTextField(String name, int value)
    {
        textFields.add(new Pair<>(name, value));
        VBox vbox = new VBox();

        Label label = new Label(name);
        TextField field = new TextField((new Integer(value)).toString());

        vbox.getChildren().addAll(label, field);

        return vbox;
    }
}
