package tasks;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class MessengerBoxs extends Application {
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Помогите");

        Parent ui = createInterface();
        primaryStage.setScene(new Scene(ui));

        primaryStage.show();
    }

    private Parent createInterface() {

        TextArea text = new TextArea();
        TextField message = new TextField();
        Button send = new Button("Послать");
        Label lab = new Label("Контакты");
        ListView<String> contacts = new ListView<>();

        HBox user = new HBox(message, send);
        VBox right = new VBox(text, user);
        VBox left = new VBox(lab, contacts);

        HBox main = new HBox(right, left);

        VBox.setVgrow(text, Priority.ALWAYS);
        HBox.setHgrow(message, Priority.ALWAYS);
        VBox.setVgrow(contacts, Priority.ALWAYS);
        HBox.setHgrow(right, Priority.ALWAYS);

        send.setPrefWidth(100);
        send.setMinWidth(100);
        contacts.setPrefWidth(150);
        contacts.setMinWidth(150);


        return main;
    }
}
