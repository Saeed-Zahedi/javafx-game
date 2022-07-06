package ir.ac.kntu;

import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class ChangeGamePlay {
    Pane pane;
    ImageView imageView;

    public ChangeGamePlay(Pane pane, ImageView imageView) {
        this.pane = pane;
        this.imageView = imageView;
        imageView.setFitHeight(400);
        imageView.setFitWidth(400);
    }
    public void GameOver(){
        pane.getChildren().add(imageView);
    }

}
