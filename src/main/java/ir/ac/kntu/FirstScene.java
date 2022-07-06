package ir.ac.kntu;

import javafx.collections.FXCollections;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FirstScene {
    public static Scene firstScene(Stage stage) throws FileNotFoundException {
        Pane pane=new Pane();
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
                stage.setScene(GameLoop.gameLoop(playerChoiceBox.getValue(),level.getValue(),speed.getValue(),stage));
            }
            catch (FileNotFoundException ex) {
                System.out.println("sorry the wrong number");
            }
        });
        FileInputStream fileInputStream=new FileInputStream("C:\\Users\\np\\IdeaProjects\\project4\\src\\main\\resources\\images\\SceneBack.PNG");
        Image image=new Image(fileInputStream);
        ImageView imageView=new ImageView(image);
        pane.getChildren().add(imageView);
        imageView.setFitWidth(400);
        imageView.setFitHeight(400);
        Text text=new Text();
        text.setText("Select player :");
        pane.getChildren().add(text);
        text.setLayoutX(100);
        text.setLayoutY(80);
        pane.getChildren().add(playerChoiceBox);
        playerChoiceBox.setLayoutY(100);
        playerChoiceBox.setLayoutX(100);
        Text text1=new Text();
        text1.setText("Select Speed :");
        pane.getChildren().add(text1);
        text1.setLayoutY(230);
        text1.setLayoutX(100);
        pane.getChildren().add(speed);
        speed.setLayoutX(100);
        speed.setLayoutY(250);
        pane.getChildren().add(button);
        button.setLayoutY(350);
        button.setLayoutX(100);
        pane.getChildren().add(button1);
        button1.setLayoutY(300);
        button1.setLayoutX(100);
        Text text2=new Text();
        text2.setText("Select level :");
        pane.getChildren().add(text2);
        text2.setLayoutY(150);
        text2.setLayoutX(100);
        pane.getChildren().add(level);
        level.setLayoutY(180);
        level.setLayoutX(100);
        Scene scene=new Scene(pane,400,400);
        stage.setTitle("Dr Mario");
        return scene;
    }
}
