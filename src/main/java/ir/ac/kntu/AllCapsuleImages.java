package ir.ac.kntu;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class AllCapsuleImages {
    public static ArrayList<ImageView>imageViews=new ArrayList<>();
    public static void fillThePicturesOfCapsules() throws FileNotFoundException {
        FileInputStream fileInputStream=new FileInputStream("C:\\Users\\np\\IdeaProjects\\project4\\src\\main\\resources\\images\\Blue.PNG");
        FileInputStream fileInputStream1=new FileInputStream("C:\\Users\\np\\IdeaProjects\\project4\\src\\main\\resources\\images\\Red.PNG");
        FileInputStream fileInputStream2=new FileInputStream("C:\\Users\\np\\IdeaProjects\\project4\\src\\main\\resources\\images\\Yellow.PNG");
        Image image=new Image(fileInputStream);
        Image image1=new Image(fileInputStream1);
        Image image2=new Image(fileInputStream2);
        ArrayList<Image>images=new ArrayList<>();
        images.add(image);
        images.add(image1);
        images.add(image2);
        for(int i=0;i<100;i++){
            AllCapsuleImages.imageViews.add(new ImageView(images.get(i%3)));
        }

    }
}
