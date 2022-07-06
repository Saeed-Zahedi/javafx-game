package ir.ac.kntu;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.*;
import java.nio.BufferUnderflowException;
import java.nio.charset.StandardCharsets;

public class SecondScene {
    public static Scene secondScene(Stage stage) throws IOException {
        BorderPane pane=new BorderPane();
        TextField textField=new TextField();
        textField.setMaxWidth(100);
        pane.setTop(textField);
        Scene scene=new Scene(pane,400,400);
        Button button=new Button("Done!");
        Button button1=new Button("Back!");
        //Writer writer=new BufferedWriter(new OutputStreamWriter(new FileOutputStream("C:\\Users\\np\\IdeaProjects\\project4\\src\\main\\resources\\file.txt",true)));

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
        pane.setBottom(button1);
        pane.setCenter(button);
        return scene;
    }
}
