package ir.ac.kntu;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;


/**
 * @author Sina Rostami
 */
public class Main extends Application {

    public static void main(String[] args) {
        launch(args);

    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        File file=new File("C:\\Users\\np\\IdeaProjects\\project4\\src\\main\\resources\\file.txt");
        BufferedReader bufferedReader=new BufferedReader(new FileReader(file));
        String st;
         while ((st=bufferedReader.readLine())!=null){
             new Player(st);
         }
        AllVirusImages.fillTheVirusImages();
        AllCapsuleImages.fillThePicturesOfCapsules();
        AllCapsules.makeCapsule(100);
        Matrix.makeMatrix();
        Stage stage=new Stage();
        stage.setScene(FirstScene.firstScene(stage));
        stage.show();
    }

}