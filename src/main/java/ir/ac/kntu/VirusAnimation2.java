package ir.ac.kntu;

import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

import java.util.ArrayList;

public class VirusAnimation2 implements Runnable {
    ArrayList<ImageView> imageViews=new ArrayList<>();
    Pane pane;
    int number;

    public VirusAnimation2(ArrayList<ImageView> imageViews, Pane pane,int number) {
        this.imageViews = imageViews;
        this.pane = pane;
        this.number=number;
    }

    @Override
    public void run() {
        int n=number%imageViews.size();
        pane.getChildren().remove(imageViews.get(n));
    }
}
