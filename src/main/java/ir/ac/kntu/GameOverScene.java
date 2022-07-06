package ir.ac.kntu;

import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class GameOverScene {
    Pane pane=new Pane();
    FileInputStream fileInputStreamGameOver=new FileInputStream("C:\\Users\\np\\IdeaProjects\\project4\\src\\main\\resources\\images\\GameOver.png");
    Image imageGameOver=new Image(fileInputStreamGameOver);
    ImageView imageViewGameOver=new ImageView(imageGameOver);

    public GameOverScene() throws FileNotFoundException {
    }
    public Scene GameOver(){
        Scene scene=new Scene(pane);
        pane.getChildren().add(imageViewGameOver);
        return  scene;
    }
}
