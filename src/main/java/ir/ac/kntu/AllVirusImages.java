package ir.ac.kntu;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class AllVirusImages {
    public static ArrayList<ImageView>imageViews=new ArrayList<>();
    public static void fillTheVirusImages() throws FileNotFoundException {
        FileInputStream fileInputStream1=new FileInputStream("C:\\Users\\np\\IdeaProjects\\project4\\src\\main\\resources\\images\\BlueVirus.PNG");
        FileInputStream fileInputStream2=new FileInputStream("C:\\Users\\np\\IdeaProjects\\project4\\src\\main\\resources\\images\\RedVirus.PNG");
        FileInputStream fileInputStream3=new FileInputStream("C:\\Users\\np\\IdeaProjects\\project4\\src\\main\\resources\\images\\YellowVirus.PNG");
        Image image1=new Image(fileInputStream1);
        Image image2=new Image(fileInputStream2);
        Image image3=new Image(fileInputStream3);
        ImageView imageView1=new ImageView(image1);
        ImageView imageView2=new ImageView(image2);
        ImageView imageView3=new ImageView(image3);
        AllVirusImages.imageViews.add(imageView1);
        AllVirusImages.imageViews.add(imageView2);
        AllVirusImages.imageViews.add(imageView3);
    }
}
