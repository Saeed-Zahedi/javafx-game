package ir.ac.kntu;

import javafx.collections.FXCollections;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.FileNotFoundException;
import java.io.IOException;

public class FirstScene {
    public static Scene firstScene(Stage stage){
        BorderPane pane=new BorderPane();
        ChoiceBox<Player>playerChoiceBox=new ChoiceBox<>();
        for(Player p:AllPlayers.AllPlayers){
            playerChoiceBox.getItems().add(p);
        }
        ChoiceBox<Integer>level=new ChoiceBox<>();
        for(int i=0;i<10;i++){
            level.getItems().add(i);
        }
        ChoiceBox<Speed>speed=new ChoiceBox<>();
        speed.getItems().add(Speed.HI);
        speed.getItems().add(Speed.MED);
        speed.getItems().add(Speed.LOW);
        Button button=new Button("Make new player");
        button.addEventHandler(MouseEvent.MOUSE_CLICKED,e->{
            try {
                stage.setScene(SecondScene.secondScene(stage));
            } catch (IOException ex) {

            }
        });
        Button button1=new Button("Start!");
        button1.addEventHandler(MouseEvent.MOUSE_CLICKED,e->{
            try {
                stage.setScene(GameLoop.gameLoop(playerChoiceBox.getValue(),level.getValue(),speed.getValue()));
            }
            catch (FileNotFoundException ex) {
                System.out.println("sorry the wrong number");
            }
        });
        pane.setTop(playerChoiceBox);
        pane.setCenter(button);
        pane.setBottom(button1);
        pane.setRight(level);
        pane.setLeft(speed);
        Scene scene=new Scene(pane,400,400);
        return scene;
    }
}
