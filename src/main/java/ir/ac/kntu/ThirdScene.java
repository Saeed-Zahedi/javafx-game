package ir.ac.kntu;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class ThirdScene {
    public static Scene ThirdScene(Stage stage,Player player){
        BorderPane pane=new BorderPane();
        ChoiceBox<Integer>level=new ChoiceBox<>();
        for(int i=0;i<10;i++){
            level.getItems().add(i);
        }
        ChoiceBox<Speed>speed=new ChoiceBox<>();
        speed.getItems().add(Speed.HI);
        speed.getItems().add(Speed.MED);
        speed.getItems().add(Speed.LOW);
        ChoiceBox<Music>music=new ChoiceBox<>();
        music.getItems().add(Music.CHILL);
        music.getItems().add(Music.FEVER);
        music.getItems().add(Music.OFF);
        pane.setTop(level);
        pane.setCenter(speed);
        pane.setBottom(music);
        Button button=new Button("Start the Game!!!");
        button.addEventHandler(MouseEvent.MOUSE_CLICKED,e->{
            System.out.println(player);
        });
        pane.setRight(button);
        Scene scene=new Scene(pane);
        return scene;
    }
}
