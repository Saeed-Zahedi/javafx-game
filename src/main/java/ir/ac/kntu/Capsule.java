package ir.ac.kntu;

import javafx.scene.image.ImageView;

import java.io.FileInputStream;
import java.util.ArrayList;

public class Capsule {
    int leftNumber;
    int rightNumber;
    ImageView imageViewLeft;
    ImageView imageViewRight;

    public Capsule(int i) {
        int n=i%12;
        int m=(i+1)%12;
        imageViewLeft=AllCapsuleImages.imageViews.get(i);
        imageViewRight=AllCapsuleImages.imageViews.get(i+1);
        switch (n){
            case 0:
            case 1:
            case 4:
            case 10:
                leftNumber=2;
            break;
            case 2:
            case 5:
            case 6:
            case 7:
                    leftNumber=3;
            break;
            case 3:
            case 8:
            case 9:
            case 11:
                leftNumber=4;
            break;
        }
        switch (m){
            case 0:
            case 1:
            case 4:
            case 10:
                rightNumber=2;
                break;
            case 2:
            case 5:
            case 6:
            case 7:
                rightNumber=3;
                break;
            case 3:
            case 8:
            case 9:
            case 11:
                rightNumber=4;
                break;
        }
        imageViewRight.setFitHeight(10);
        imageViewRight.setFitWidth(10);
        imageViewLeft.setFitHeight(10);
        imageViewLeft.setFitWidth(10);
        AllCapsules.capsules.add(this);
    }
    public void gotToLeft(){
        imageViewLeft.setLayoutX(imageViewLeft.getLayoutX()-10);
        imageViewRight.setLayoutX(imageViewRight.getLayoutX()-10);
    }
    public void gotToRight(){
        imageViewLeft.setLayoutX(imageViewLeft.getLayoutX()+10);
        imageViewRight.setLayoutX(imageViewRight.getLayoutX()+10);
    }
    public void getDown(){
        imageViewLeft.setLayoutY(imageViewLeft.getLayoutY()+10);
        imageViewRight.setLayoutY(imageViewRight.getLayoutY()+10);
    }
}
