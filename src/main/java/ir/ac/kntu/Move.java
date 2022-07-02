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
        System.out.println("1");
        pane.getChildren().add(rightImage);
        System.out.println("2");
        capsule.imageViewRight.setLayoutY(110);
        capsule.imageViewRight.setLayoutX(190);
        capsule.imageViewLeft.setLayoutY(110);
        capsule.imageViewLeft.setLayoutX(180);
    }

    @Override
    public void run() {
        capsule.imageViewRight.setLayoutY(capsule.imageViewRight.getLayoutY()+10);
        capsule.imageViewLeft.setLayoutY(capsule.imageViewLeft.getLayoutY()+10);
    }

}
