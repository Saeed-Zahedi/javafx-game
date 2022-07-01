package ir.ac.kntu;

import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Shape;

import java.io.FileNotFoundException;

public class Move implements Runnable{
    ImageView imageView;
    Pane pane;
    int color;
    public Move(Pane pane) throws FileNotFoundException {
        int i=(int)(Math.random()*3);
        color=i+2;
        this.imageView = ChoseCapsule.getCapules(i);
        this.pane=pane;
        pane.getChildren().add(imageView);
        imageView.setLayoutY(120);
        imageView.setLayoutX(190);
    }

    @Override
    public void run() {
        if(GameLoop.CheckforDown(imageView,color)){
        imageView.setLayoutY(imageView.getLayoutY()+10);
            System.out.println(imageView.getLayoutY());
            Matrix.seeMatrix();
        }
    }

    public ImageView getImageView() {
        return imageView;
    }
}
