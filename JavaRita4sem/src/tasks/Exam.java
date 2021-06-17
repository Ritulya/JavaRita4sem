package tasks;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import java.util.ArrayList;

public class Exam extends Application {
    private final Color[] colors = new Color[] {Color.RED, Color.ORANGE, Color.YELLOW,
            Color.GREEN, Color.SKYBLUE, Color.BLUE, Color.PURPLE, Color.BLACK};
    private final String[] name = new String[] {"Красный", "Оранжевый", "Жёлтый",
            "Зелёный", "Голубой", "Синий", "Фиолетовый", "Чёрный"};

    private final ArrayList<Pane> elements = new ArrayList<>();

    private final VBox left = new VBox();
    private Button b;
    private final StroopFactory a = new StroopFactory(name, colors);

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Господи помоги");

        Parent ui = createInterface();
        primaryStage.setScene(new Scene(ui, 400, 400));

        primaryStage.show();
        initInteraction();
    }

    private void initInteraction() {
       b.setOnAction(e -> {
           if (elements.size() >= 10) {
               elements.remove(0);
           }
           elements.add(a.getElement());
           left.getChildren().clear();
           left.getChildren().addAll(elements);
       });
    }


    private Parent createInterface() {

        /*Label lab1 = new Label("Синий");
        lab1.setStyle("-fx-text-fill: purple; -fx-font-weight: bold; -fx-font-size: large");
        elements.add(new Pane(lab1));

        Label lab2 = new Label("Жёлтый");
        lab2.setStyle("-fx-text-fill: green; -fx-font-weight: bold; -fx-font-size: large");
        elements.add(new Pane(lab2));

        Label lab3 = new Label("Фиолетовый");
        lab3.setStyle("-fx-text-fill: orange; -fx-font-weight: bold; -fx-font-size: large");
        elements.add(new Pane(lab3));

        Rectangle rec1 = new Rectangle(50, 10);
        rec1.setFill(Color.BLUE);
        elements.add(new Pane(rec1));

        Label lab4 = new Label("Чёрный");
        lab4.setTextFill(Color.RED);
        lab4.setStyle("-fx-font-weight: bold; -fx-font-size: large");
        elements.add(new Pane(lab4));

        Rectangle rec2 = new Rectangle(50, 10);
        rec2.setFill(Color.PURPLE);
        elements.add(new Pane(rec2));*/

        for (int i = 0; i < 6; i++) {
            elements.add(a.getElement());
        }

        b = new Button("Добавить");
        b.setStyle("-fx-font-size: x-large");

        left.setAlignment(Pos.CENTER);
        left.getChildren().addAll(elements);
        HBox main = new HBox(left, b);

        b.setMinWidth(100);
        left.setSpacing(20);
        HBox.setHgrow(left, Priority.ALWAYS);
        //господи помогите
        //я не смогла сделать выравнивание, извините :(


        return main;
    }
}

