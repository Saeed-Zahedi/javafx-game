package ir.ac.kntu;

import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

import java.util.ArrayList;

public class VisrusAnimataion  implements Runnable{
    ArrayList<ImageView>imageViews=new ArrayList<>();
    Pane pane;
    int number;

    public VisrusAnimataion(ArrayList<ImageView> imageViews, Pane pane,int number) {
        this.imageViews = imageViews;
        this.pane = pane;
        this.number=number;
    }

    @Override
    public void run() {
        int n=number%imageViews.size();
        pane.getChildren().add(imageViews.get(n));

    }
}
