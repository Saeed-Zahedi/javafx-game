package ir.ac.kntu;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Shape;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Move implements Runnable{
    Capsule capsule;
    ImageView leftImage;
    ImageView rightImage;
    Pane pane;
    Player player;
    ImageView GameOver;
    public Move(Pane pane,int i,Player player) throws FileNotFoundException {
        this.player=player;
        this.capsule=AllCapsules.capsules.get(i);
        leftImage=capsule.imageViewLeft;
        rightImage=capsule.imageViewRight;
        this.pane=pane;
        pane.getChildren().add(leftImage);
        pane.getChildren().add(rightImage);
        capsule.imageViewRight.setLayoutY(120);
        capsule.imageViewRight.setLayoutX(200);
        capsule.imageViewLeft.setLayoutY(120);
        capsule.imageViewLeft.setLayoutX(190);
        FileInputStream fileInputStreamGameOver=new FileInputStream("C:\\Users\\np\\IdeaProjects\\project4\\src\\main\\resources\\images\\GameOver.png");
        Image imageGameOver=new Image(fileInputStreamGameOver);
        ImageView imageViewGameOver=new ImageView(imageGameOver);
        imageViewGameOver.setLayoutY(200);
        imageViewGameOver.setLayoutX(100);
        this.GameOver=imageViewGameOver;
    }

    @Override
    public void run() {
        if(GameLoop.CheckforDown(capsule)){
        capsule.imageViewRight.setLayoutY(capsule.imageViewRight.getLayoutY()+10);
        capsule.imageViewLeft.setLayoutY(capsule.imageViewLeft.getLayoutY()+10);
        }
        GameLoop.upDateTheMatrixX(pane,GameLoop.move,player);
        GameLoop.upDateTheMatrixY(pane,GameLoop.move,player);
        GameLoop.upDateTheScore(pane,player);
        if(GameStatusUpDator.GameStatusCheckerForGameOver()){
            try {
                pane.getChildren().add(GameOver);
            }catch (Exception e){

            }

        }
    }

}
