package ir.ac.kntu;

import javafx.scene.image.ImageView;
import javafx.scene.shape.Shape;

public class Move implements Runnable{
    ImageView imageView

    public Move(ImageView imageView) {
        this.imageView = imageView;
    }

    @Override
    public void run() {
        imageView.setLayoutY(imageView.getLayoutY()+10);
    }
}
