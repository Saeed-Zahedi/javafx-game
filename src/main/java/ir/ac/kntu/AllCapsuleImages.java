package ir.ac.kntu;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class AllCapsuleImages {
    public static ArrayList<ImageView>imageViews=new ArrayList<>();
    public static void fillThePicturesOfCapsules() throws FileNotFoundException {
        FileInputStream fileInputStream0=new FileInputStream("C:\\Users\\np\\IdeaProjects\\project4\\src\\main\\resources\\images\\Blue.PNG");
        FileInputStream fileInputStream=new FileInputStream("C:\\Users\\np\\IdeaProjects\\project4\\src\\main\\resources\\images\\Blue.PNG");
        FileInputStream fileInputStream3=new FileInputStream("C:\\Users\\np\\IdeaProjects\\project4\\src\\main\\resources\\images\\Blue.PNG");
        FileInputStream fileInputStream1=new FileInputStream("C:\\Users\\np\\IdeaProjects\\project4\\src\\main\\resources\\images\\Red.PNG");
        FileInputStream fileInputStream5=new FileInputStream("C:\\Users\\np\\IdeaProjects\\project4\\src\\main\\resources\\images\\Red.PNG");
        FileInputStream fileInputStream6=new FileInputStream("C:\\Users\\np\\IdeaProjects\\project4\\src\\main\\resources\\images\\Red.PNG");
        FileInputStream fileInputStream4=new FileInputStream("C:\\Users\\np\\IdeaProjects\\project4\\src\\main\\resources\\images\\Red.PNG");
        FileInputStream fileInputStream2=new FileInputStream("C:\\Users\\np\\IdeaProjects\\project4\\src\\main\\resources\\images\\Yellow.PNG");
        FileInputStream fileInputStream7=new FileInputStream("C:\\Users\\np\\IdeaProjects\\project4\\src\\main\\resources\\images\\Yellow.PNG");
        FileInputStream fileInputStream8=new FileInputStream("C:\\Users\\np\\IdeaProjects\\project4\\src\\main\\resources\\images\\Yellow.PNG");
        FileInputStream fileInputStream9=new FileInputStream("C:\\Users\\np\\IdeaProjects\\project4\\src\\main\\resources\\images\\Blue.PNG");
        FileInputStream fileInputStream10=new FileInputStream("C:\\Users\\np\\IdeaProjects\\project4\\src\\main\\resources\\images\\Yellow.PNG");
        Image image0=new Image(fileInputStream0);
        Image image=new Image(fileInputStream);
        Image image1=new Image(fileInputStream1);
        Image image2=new Image(fileInputStream2);
        Image image3=new Image(fileInputStream3);
        Image image4=new Image(fileInputStream4);
        Image image5=new Image(fileInputStream5);
        Image image6=new Image(fileInputStream6);
        Image image7=new Image(fileInputStream7);
        Image image8=new Image(fileInputStream8);
        Image image9=new Image(fileInputStream9);
        Image image10=new Image(fileInputStream10);
        ArrayList<Image>images=new ArrayList<>();
        images.add(image0);
        images.add(image);
        images.add(image1);
        images.add(image2);
        images.add(image3);
        images.add(image4);
        images.add(image5);
        images.add(image6);
        images.add(image7);
        images.add(image8);
        images.add(image9);
        images.add(image10);
        for(int i=0;i<100;i++){
            AllCapsuleImages.imageViews.add(new ImageView(images.get(i%12)));
        }

    }
}
