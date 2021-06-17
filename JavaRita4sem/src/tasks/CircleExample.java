package tasks;

import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.event.ActionEvent;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class CircleExample extends Application {

    private Slider slider ;
    private ColorPicker circleColor;
    private ColorPicker backColor;
    private Circle circle;
    private Pane canvas;

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Кружок");

        Parent ui = createInterface();
        primaryStage.setScene(new Scene(ui, 640, 480));

        primaryStage.show();
        initInteraction();
    }


    private void initInteraction() {
        circle.radiusProperty().bind(slider.valueProperty());
        circle.centerXProperty().bind(Bindings.createDoubleBinding(
                () -> canvas.getWidth()/2,
                canvas.widthProperty()
        ));
        circle.centerYProperty().bind(Bindings.createDoubleBinding(
                () -> canvas.getHeight()/2,
                canvas.heightProperty()
        ));
        circle.fillProperty().bind(circleColor.valueProperty());
        backColor.addEventHandler(ActionEvent.ACTION, e ->
                canvas.setStyle("-fx-background-color: " + backColor.getValue().toString().substring(2,8)));
    }

    private Parent createInterface() {

        Label labRad = new Label("Радиус");
        Label labColorCircle = new Label("Цвет круга");
        Label labBackColor = new Label("Цвет фона");

        slider = new Slider();
        circleColor = new ColorPicker();
        backColor = new ColorPicker();

        VBox left = new VBox(labRad, slider, labColorCircle, circleColor, labBackColor, backColor);
        left.setPrefWidth(100);

        circle = new Circle();
        canvas = new Pane(circle);
        HBox main = new HBox(left, canvas);
        HBox.setHgrow(canvas, Priority.ALWAYS);

        return main;
    }
}
