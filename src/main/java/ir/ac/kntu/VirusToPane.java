package ir.ac.kntu;

import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class VirusToPane implements Runnable {
    ImageView imageView;
    Pane pane;
    Virus virus;
    public VirusToPane(Pane pane,int i) {
        this.pane = pane;
        virus=AllVirus.virus.get(i);
        this.imageView=virus.imageView;
        pane.getChildren().add(imageView);
        int x=(int)(Math.random()*10+1);
        int y=(int)(Math.random()*21+3);
        this.imageView=virus.imageView;
        imageView.setLayoutY((y*10)+120);
        imageView.setLayoutX((x+14)*10);
        imageView.setFitWidth(10);
        imageView.setFitHeight(10);
    }

    @Override
    public void run() {

    }
}
