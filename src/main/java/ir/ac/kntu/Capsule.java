package ir.ac.kntu;

import javafx.scene.image.ImageView;

import java.io.FileInputStream;

public class Capsule {
    int leftNumber;
    int rightNumber;
    ImageView imageViewLeft;
    ImageView imageViewRight;

    public Capsule(int i) {
        int n=(int)(Math.random()*100);
        imageViewLeft=AllCapsuleImages.imageViews.get(i);
        int m=(int)(Math.random()*100);
        imageViewRight=AllCapsuleImages.imageViews.get(i+1);
        switch (n){
            case 0:leftNumber=2;
            break;
            case 1:leftNumber=3;
            break;
            case 2:leftNumber=4;
            break;
        }
        switch (m){
            case 0:rightNumber=2;
                break;
            case 1:rightNumber=3;
                break;
            case 2:rightNumber=4;
                break;
        }
        imageViewRight.setFitHeight(10);
        imageViewRight.setFitWidth(10);
        imageViewLeft.setFitHeight(10);
        imageViewLeft.setFitWidth(10);
        AllCapsules.capsules.add(this);
    }
}
