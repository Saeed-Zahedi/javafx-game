package ir.ac.kntu;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.*;
import java.nio.BufferUnderflowException;
import java.nio.charset.StandardCharsets;

public class SecondScene {
    public static Scene secondScene(Stage stage) throws IOException {
        Pane pane=new Pane();
        FileInputStream fileInputStream=new FileInputStream("C:\\Users\\np\\IdeaProjects\\project4\\src\\main\\resources\\images\\SceneBack.PNG");
        Image image=new Image(fileInputStream);
        ImageView imageView=new ImageView(image);
        pane.getChildren().add(imageView);
        imageView.setFitWidth(400);
        imageView.setFitHeight(400);
        Text text=new Text();
        text.setText("Enter the New Player Name :");
        pane.getChildren().add(text);
        text.setLayoutX(130);
        text.setLayoutY(80);
        TextField textField=new TextField();
        textField.setMaxWidth(100);
        pane.getChildren().add(textField);
        textField.setLayoutX(150);
        textField.setLayoutY(100);
        Scene scene=new Scene(pane,400,400);
        Button button=new Button("Done!");
        Button button1=new Button("Back!");
        button1.addEventHandler(MouseEvent.MOUSE_CLICKED, e->{
            try {
                stage.setScene(FirstScene.firstScene(stage));
            } catch (FileNotFoundException ex) {

            }
        });
        button.addEventHandler(MouseEvent.MOUSE_CLICKED,e->{
            new Player(textField.getText());
            try {
              BufferedWriter outPut= new BufferedWriter(new FileWriter("C:\\Users\\np\\IdeaProjects\\project4\\src\\main\\resources\\file.txt",true));
              outPut.newLine();
              outPut.append(textField.getText());
               outPut.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }


        });
        pane.getChildren().add(button1);
        button1.setLayoutX(150);
        button1.setLayoutY(300);
        pane.getChildren().add(button);
        button.setLayoutX(150);
        button.setLayoutY(200);
        return scene;
    }
}
