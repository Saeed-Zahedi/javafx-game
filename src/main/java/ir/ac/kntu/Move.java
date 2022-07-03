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
    public Move(Pane pane,int i) {
        this.capsule=AllCapsules.capsules.get(i);
        leftImage=capsule.imageViewLeft;
        rightImage=capsule.imageViewRight;
        this.pane=pane;
        pane.getChildren().add(leftImage);
        pane.getChildren().add(rightImage);
        capsule.imageViewRight.setLayoutY(130);
        capsule.imageViewRight.setLayoutX(190);
        capsule.imageViewLeft.setLayoutY(130);
        capsule.imageViewLeft.setLayoutX(180);
    }

    @Override
    public void run() {
        if(GameLoop.CheckforDown(capsule)){
        capsule.imageViewRight.setLayoutY(capsule.imageViewRight.getLayoutY()+10);
        capsule.imageViewLeft.setLayoutY(capsule.imageViewLeft.getLayoutY()+10);
        }
        Matrix.seeMatrix();
        System.out.println();
        GameLoop.upDateTheMatrix(pane,GameLoop.move);
    }

}
