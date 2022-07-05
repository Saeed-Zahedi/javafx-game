package ir.ac.kntu;

import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

import java.util.ArrayList;

public class DrAnimation implements Runnable {
    ArrayList<ImageView>imageViews;
    Pane pane;
    int number;

    public DrAnimation(ArrayList<ImageView> imageViews, Pane pane, int number) {
        this.imageViews = imageViews;
        this.pane = pane;
        this.number = number;
    }

    @Override
    public void run() {
        pane.getChildren().add(imageViews.get(number%imageViews.size()));
    }
}
