package tasks;

import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import java.util.Random;

public class StroopFactory {
    private final Random a = new Random();
    private final String[] names;
    private final Color[] colors;

    StroopFactory(String[] list1, Color[] list2) {
        this.names = list1;
        this.colors = list2;
    }

    public Pane getElement() {
        Pane el;
        int i = a.nextInt(8);
        int j = a.nextInt(8);
        if (a.nextBoolean()) {
            Label lab = new Label(this.names[i]);
            lab.setStyle("-fx-font-weight: bold; -fx-font-size: x-large");
            lab.setTextFill(this.colors[j]);
            el = new Pane(lab);
        }
        else {
            Rectangle rec = new Rectangle(60, 15);
            rec.setFill(this.colors[j]);
            rec.setStroke(Color.BLACK);
            el = new Pane(rec);
        }
        return el;
    }
}