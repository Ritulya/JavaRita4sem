package tasks;


import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.net.MalformedURLException;
import java.nio.file.Paths;


public class ButtonExample extends Application {
    private VBox vb;
    private Button b;
    private Label lab;
    private ImageView img;
    private Integer counter = 0;


    @Override
    public void start(Stage primaryStage) throws MalformedURLException {
        primaryStage.setTitle("Пример кнопки");

        Parent ui = createInterface();
        primaryStage.setScene(new Scene(ui, 500, 280));

        primaryStage.show();
        initInteraction();
    }


    private void initInteraction() {
        b.setOnAction(e -> {
            switch (counter) {
                case 0 -> lab.setText("...");
                case 1 -> lab.setText("АЙ!");
                case 2 -> lab.setText("Стой!");
                case 3 -> lab.setText("Не нажимай меня...");
                case 4 -> lab.setText("Больно же...");
                case 5 -> lab.setText("ХВАТИТ!");
                case 6 -> lab.setText("ПОЖАЛУЙСТА...");
                case 7 -> {
                    vb.getChildren().clear();
                    vb.getChildren().add(img);
                }
            }
            counter++;
        });
    }


    private Parent createInterface() throws MalformedURLException {
        vb = new VBox();
        b = new Button("Я кнопка.");
        b.setPrefSize(500, 100);
        lab = new Label();
        img = new ImageView(new Image(Paths.get("gif.gif").toUri().toURL().toString()));
        vb.getChildren().addAll(b, lab);
        vb.setAlignment(Pos.CENTER);
        return vb;
    }
}

