package ir.ac.kntu;

import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class GameStatusUpDator {

    public GameStatusUpDator() {

    }

    public static boolean GameStatusCheckerForGameOver() {
        boolean first=false;
        boolean second=false;
        for (int i = 1; i <24 ; i++) {
            if(Matrix.matrix[i][5]==0){
                first=true;
            }
            if(Matrix.matrix[i][6]==0){
                second=true;
            }
        }
        if(second==false&&first==false){
            return true;
        }else {
            return false;
        }
    }
    public static boolean GameStatusForStageClear(int level,int killed){
        if(level*4==killed){
            return true;
        }
        else {
            return  false;
        }
    }
}
