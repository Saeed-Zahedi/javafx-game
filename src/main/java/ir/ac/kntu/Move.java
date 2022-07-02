package ir.ac.kntu;

import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Shape;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Move implements Runnable{
    ImageView imageView;
    Pane pane;
    int color;
    ArrayList<Move>move=new ArrayList<>();
    public Move(ArrayList<Move>move, Pane pane) throws FileNotFoundException {
        int i=(int)(Math.random()*3);
        color=i+2;
        this.imageView = ChoseCapsule.getCapules(i);
        this.pane=pane;
        pane.getChildren().add(imageView);
        this.move=move;
        imageView.setLayoutY(120);
        imageView.setLayoutX(190);
    }

    @Override
    public void run() {
        if(GameLoop.CheckforDown(imageView,color)){
        imageView.setLayoutY(imageView.getLayoutY()+10);
            if(GameLoop.CheckupDateForMatrix(move,pane)){
                int Y=(int)(GameLoop.upDateForMatrix(move,pane).get(0).getImageView().getLayoutY()-120)/10;
                int X=(int)(GameLoop.upDateForMatrix(move,pane).get(0).getImageView().getLayoutX()/10)-14;
                pane.getChildren().remove(GameLoop.upDateForMatrix(move,pane).get(0).getImageView());
                pane.getChildren().remove(GameLoop.upDateForMatrix(move,pane).get(1).getImageView());
                for(int i=0;i<4;i++){
                    Matrix.matrix[Y][X+i]=0;
                }

            }
        Matrix.seeMatrix();
        }
    }

    public ImageView getImageView() {
        return imageView;
    }
}
