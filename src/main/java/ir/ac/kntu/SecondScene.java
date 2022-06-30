package ir.ac.kntu;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class SecondScene {
    public static Scene secondScene(Stage stage){
        BorderPane pane=new BorderPane();
        TextField textField=new TextField();
        textField.setMaxWidth(100);
        pane.setTop(textField);
        Scene scene=new Scene(pane,400,400);
        Button button=new Button("Done!");
        Button button1=new Button("Back!");
        button1.addEventHandler(MouseEvent.MOUSE_CLICKED, e->{
            stage.setScene(FirstScene.firstScene(stage));
        });
        button.addEventHandler(MouseEvent.MOUSE_CLICKED,e->{
            new Player(textField.getText());
        });
        pane.setBottom(button1);
        pane.setCenter(button);
        return scene;
    }
}
