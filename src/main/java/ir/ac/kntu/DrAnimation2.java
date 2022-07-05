package ir.ac.kntu;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

import java.util.ArrayList;

public class DrAnimation2 implements Runnable{
    ArrayList<ImageView>imageViews;
    Pane pane;
    int number;
    public DrAnimation2(ArrayList<ImageView> imageViews, Pane pane,int i) {
        this.imageViews = imageViews;
        this.pane = pane;
        number=i;
    }

    @Override
    public void run() {
        pane.getChildren().remove(imageViews.get(number%imageViews.size()));
    }
}
