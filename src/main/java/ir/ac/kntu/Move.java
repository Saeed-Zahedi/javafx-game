package ir.ac.kntu;

import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Shape;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Move implements Runnable{
    Capsule capsule;
    ImageView leftImage;
    ImageView rightImage;
    Pane pane;
    Player player;
    public Move(Pane pane,int i,Player player) {
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
    }

    @Override
    public void run() {
        if(GameLoop.CheckforDown(capsule)){
        capsule.imageViewRight.setLayoutY(capsule.imageViewRight.getLayoutY()+10);
        capsule.imageViewLeft.setLayoutY(capsule.imageViewLeft.getLayoutY()+10);
        }
        Matrix.seeMatrix();
        System.out.println();
        GameLoop.upDateTheMatrixX(pane,GameLoop.move,player);
        GameLoop.upDateTheMatrixY(pane,GameLoop.move,player);
        GameLoop.upDateTheScore(pane,player);
    }

}
