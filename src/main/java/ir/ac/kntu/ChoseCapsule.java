package ir.ac.kntu;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class ChoseCapsule {
    public static ArrayList<ImageView>capsules=new ArrayList<>();

    public ChoseCapsule() {
    }
    public static ImageView getCapules(int input) throws FileNotFoundException {
        int re=0;
        ArrayList<ImageView>imageViews=new ArrayList<>();
        FileInputStream fileInputStream=new FileInputStream("C:\\Users\\np\\IdeaProjects\\project4\\src\\main\\resources\\images\\DBlueCapsule.PNG");
        FileInputStream fileInputStream1=new FileInputStream("C:\\Users\\np\\IdeaProjects\\project4\\src\\main\\resources\\images\\DRedCapsule.PNG");
        FileInputStream fileInputStream2=new FileInputStream("C:\\Users\\np\\IdeaProjects\\project4\\src\\main\\resources\\images\\DYellowCapsule.PNG");
        Image image=new Image(fileInputStream);
        Image image1=new Image(fileInputStream1);
        Image image2=new Image(fileInputStream2);
        ImageView imageView=new ImageView(image);
        ImageView imageView1=new ImageView(image1);
        ImageView imageView2=new ImageView(image2);
        imageViews.add(imageView);
        imageViews.add(imageView1);
        imageViews.add(imageView2);
        for (int i = 0; i < imageViews.size(); i++) {
            imageViews.get(i).setFitWidth(20);
            imageViews.get(i).setFitHeight(10);
        }
        return imageViews.get(input);
    }
}
