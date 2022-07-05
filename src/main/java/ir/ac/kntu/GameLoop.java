package ir.ac.kntu;

import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.scene.web.WebHistory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class GameLoop {
    public static int speedType(Speed speed){
        int n=1000;
        switch (speed){
            case HI : n=500;
            break;
            case LOW:n=1000;
            break;
            case MED:n=700;
            break;
        }
        return n;
    }
    static int n=0;
    static boolean re=false;
    static ArrayList<Move>move=new ArrayList<>();
    static ArrayList<VirusToPane>virusToPane=new ArrayList<>();
    public static Scene gameLoop(Player player,int level,Speed speed) throws FileNotFoundException {
        AllVirus.makeVirus(level*4);
        Pane pane=new Pane();
        FileInputStream fileInputStream=new FileInputStream("C:\\Users\\np\\IdeaProjects\\project4\\src\\main\\resources\\images\\MainScene.png");
        Image image=new Image(fileInputStream);
        ImageView imageView=new ImageView(image);
        imageView.setFitHeight(400);
        imageView.setFitWidth(400);
        FileInputStream fileInputStream1=new FileInputStream("C:\\Users\\np\\IdeaProjects\\project4\\src\\main\\resources\\images\\firstYvirus.PNG");
        FileInputStream fileInputStream2=new FileInputStream("C:\\Users\\np\\IdeaProjects\\project4\\src\\main\\resources\\images\\secondYvirus.PNG");
        FileInputStream fileInputStream3=new FileInputStream("C:\\Users\\np\\IdeaProjects\\project4\\src\\main\\resources\\images\\ThirdYvirus.PNG");
        FileInputStream fileInputStream4=new FileInputStream("C:\\Users\\np\\IdeaProjects\\project4\\src\\main\\resources\\images\\fourthYvirus.PNG");
        FileInputStream fileInputStream5=new FileInputStream("C:\\Users\\np\\IdeaProjects\\project4\\src\\main\\resources\\images\\fithYvirus.PNG");
        Image image1=new Image(fileInputStream1);
        Image image2=new Image(fileInputStream2);
        Image image3=new Image(fileInputStream3);
        Image image4=new Image(fileInputStream4);
        Image image5=new Image(fileInputStream5);
        ImageView imageView1=new ImageView(image1);
        ImageView imageView2=new ImageView(image2);
        ImageView imageView3=new ImageView(image3);
        ImageView imageView4=new ImageView(image4);
        ImageView imageView5=new ImageView(image5);
        ArrayList<ImageView>imageViews=new ArrayList<>();
        imageViews.add(imageView1);
        imageViews.add(imageView2);
        imageViews.add(imageView3);
        imageViews.add(imageView4);
        imageViews.add(imageView5);
        for (int i = 0; i < imageViews.size(); i++) {
            imageViews.get(i).setLayoutX(100);
            imageViews.get(i).setLayoutY(200);
        }

        Text text=new Text();
        text.setText("Score :");
        text.setLayoutX(30);
        text.setLayoutY(100);
        text.setStroke(Color.DARKORANGE);
        text.setStrokeWidth(2);
       // Text text1=new Text();
       // text1.setText(""+player.score);
        //text1.setLayoutX(50);
        //text1.setLayoutY(120);
        Text text2=new Text();
        text2.setText("Player : "+player.name);
        text2.setLayoutY(80);
        text2.setLayoutX(30);
        Text text3=new Text();
        text3.setText("level :");
        Text text4=new Text();
        text4.setText(""+level);
        text4.setLayoutX(330);
        text4.setLayoutY(250);
        text3.setLayoutX(290);
        text3.setLayoutY(250);
        Text text5=new Text();
        text5.setText("Speed :");
        text5.setLayoutY(300);
        text5.setLayoutX(290);
        Text text6=new Text();
        text6.setText(speed.name());
        text6.setLayoutX(330);
        text6.setLayoutY(300);
        pane.getChildren().add(imageView);
        pane.getChildren().add(text);
        //pane.getChildren().add(text1);
        pane.getChildren().add(text2);
        pane.getChildren().add(text3);
        pane.getChildren().add(text4);
        pane.getChildren().add(text5);
        pane.getChildren().add(text6);
        Scene scene=new Scene(pane,400,400);
        boolean flag=true;
        for(int i=0;i<50;i++){
            move.add(new Move(pane,i,player));
        }
        for (int i = 0; i < level*4; i++) {
            virusToPane.add(new VirusToPane(pane,i));
        }
        Thread virusMakerThread=new Thread(()->{
            try {
                Thread.sleep(2000);
            }catch (InterruptedException e){

            }
            for(int i=0;i<level*4;i++){
                Platform.runLater(virusToPane.get(i));
            }
        });
        Thread mainThread=new Thread(()->{
            try {
                Thread.sleep(2000);
            }
            catch (InterruptedException e){

            }
            for (int j = 0; j < 50; j++) {
                n=j;
                for (int i = 0; i < 23; i++) {

                    try {
                        Thread.sleep(GameLoop.speedType(speed));
                    } catch (InterruptedException t) {

                    }
                    Platform.runLater(move.get(j));
                    }
                    GameLoop.updateTheImages();
                }
        });
        Thread virusThread=new Thread(()->{
            try {
                Thread.sleep(2000);
            }
            catch (InterruptedException e){

            }
            for(int i=0;i<10000;i++){
                 Platform.runLater(new VisrusAnimataion(imageViews,pane,i));
                try {
                    Thread.sleep(100);
                }catch (InterruptedException ex){

                }
                Platform.runLater(new VirusAnimation2(imageViews,pane,i));
                try {
                    Thread.sleep(100);
                }catch (InterruptedException ex){

                }
            }
        });
       scene.addEventHandler(KeyEvent.KEY_PRESSED, t->{
            if(t.getCode()==KeyCode.RIGHT){
                if(checktheplaceForRight(move.get(n).capsule)){
                    move.get(n).capsule.gotToRight();

                }
            }
            if(t.getCode()==KeyCode.LEFT){
                if(checkforLeft(move.get(n).capsule)){
                    move.get(n).capsule.gotToLeft();
                }
            }
            if(t.getCode()==KeyCode.DOWN){
                if(CheckforDown(move.get(n).capsule)){
                    move.get(n).capsule.getDown();
                }
            }
            if(t.getCode()==KeyCode.A){
               CheckForChangingPosition(move.get(n));
            }
        });
       virusMakerThread.start();
        mainThread.start();
        virusThread.start();

        return scene;
    }
        public static boolean checktheplaceForRight(Capsule capsule) {
            boolean re = true;
            int x = (int) (capsule.imageViewLeft.getLayoutX() / 10) - 14;
            int y = (int) (capsule.imageViewLeft.getLayoutY() - 120) / 10;
            switch (capsule.capsulPosition) {
                case X:
            if (Matrix.matrix[y][x + 2] != 0) {
                re = false;
            } else {
                Matrix.matrix[y][x] = 0;
                Matrix.matrix[y][x + 1] = capsule.leftNumber;
                Matrix.matrix[y][x + 2] = capsule.rightNumber;
            }
            break;
                case Y:
                    if(Matrix.matrix[y][x+1]!=0||Matrix.matrix[y-1][x+1]!=0){
                        re=false;
                    }
                    else {
                        Matrix.matrix[y][x+1]=capsule.leftNumber;
                        Matrix.matrix[y-1][x+1]= capsule.rightNumber;
                        Matrix.matrix[y][x]=0;
                        Matrix.matrix[y-1][x]=0;
                    }
                    break;

        }
        return re;
    }
    public static boolean CheckforDown(Capsule capsule){
        boolean re=true;
        int x = (int) (capsule.imageViewLeft.getLayoutX() / 10) - 14;
        int y = (int) (capsule.imageViewLeft.getLayoutY() - 120) / 10;
        switch (capsule.capsulPosition) {
            case X :
            if (Matrix.matrix[y + 1][x] != 0 || Matrix.matrix[y + 1][x + 1] != 0) {
                re = false;
            } else {
                Matrix.matrix[y][x] = 0;
                Matrix.matrix[y][x + 1] = 0;
                Matrix.matrix[y + 1][x] = capsule.leftNumber;
                Matrix.matrix[y + 1][x + 1] = capsule.rightNumber;
            }
            break;
            case Y:
                if(Matrix.matrix[y+1][x]!=0){
                re=false;
            }else {
                    Matrix.matrix[y+1][x]= capsule.leftNumber;
                    Matrix.matrix[y][x]= capsule.rightNumber;
                    Matrix.matrix[y-1][x]=0;
                }
                break;

        }
        return re;
    }
    public static boolean checkforLeft(Capsule capsule){
        boolean re=true;
        int x=(int)(capsule.imageViewLeft.getLayoutX()/10)-14;
        int y=(int)(capsule.imageViewLeft.getLayoutY()-120)/10;
        switch (capsule.capsulPosition){
            case X:
        if(Matrix.matrix[y][x-1]!=0){
            re=false;
        }
        else {
            Matrix.matrix[y][x+1]=0;
            Matrix.matrix[y][x-1]=capsule.leftNumber;
            Matrix.matrix[y][x]=capsule.rightNumber;

        }
        break;
            case Y:
                if(Matrix.matrix[y][x-1]!=0||Matrix.matrix[y-1][x-1]!=0){
                    re=false;
                }
                else {
                    Matrix.matrix[y][x-1]= capsule.leftNumber;
                    Matrix.matrix[y-1][x-1]= capsule.rightNumber;
                    Matrix.matrix[y][x]= 0;
                    Matrix.matrix[y-1][x]=0;
                }
                break;
        }
        return re;
    }
    public static void upDateTheMatrixX(Pane pane,ArrayList<Move>move,Player player){
        for(int i=0;i<24;i++){
            for (int j = 1; j <8 ; j++) {
                int n=Matrix.matrix[i][j];
                if(Matrix.matrix[i][j+1]==n&&Matrix.matrix[i][j+2]==n&&Matrix.matrix[i][j+3]==n&&n!=0){
                    int flag1=Matrix.matrix[i][j+3];
                    int index=0;
                    for (int k = 1; k < 7; k++) {
                        try {
                            if(Matrix.matrix[i][j+3+k]==n&&flag1==Matrix.matrix[i][j+3+k]){
                                flag1=Matrix.matrix[i][j+3+k];
                                index=k;
                            }
                            else {
                                break;
                            }
                        }catch (Exception e){

                        }

                    }
                    for (int k = 0; k < 4+index; k++) {
                        Matrix.matrix[i][j+k]=0;
                        for(Move m:move){
                            if((m.rightImage.getLayoutY()-120)/10==i&&(m.rightImage.getLayoutX()/10)-14==j+k){
                                pane.getChildren().remove(m.rightImage);
                            }
                            if((m.leftImage.getLayoutY()-120)/10==i&&(m.leftImage.getLayoutX()/10)-14==j+k){
                                pane.getChildren().remove(m.leftImage);
                            }
                        }
                        for (Virus virus : AllVirus.virus) {
                            if ((virus.imageView.getLayoutY()-120) / 10 ==i && virus.imageView.getLayoutX() / 10 - 14 ==j+k) {
                                player.score++;
                                virus.number = 0;
                                pane.getChildren().remove(virus.imageView);
                            }
                        }
                    }
                }
            }
        }
    }
    public static void upDateTheMatrixY(Pane pane,ArrayList<Move>move,Player player){
        for (int i = 1; i <11; i++) {
            for (int j = 0; j < 22; j++) {
                int n=Matrix.matrix[j][i];
                if(Matrix.matrix[j+1][i]==n&&Matrix.matrix[j+2][i]==n&&Matrix.matrix[j+3][i]==n&&n!=0){
                    int flag1=Matrix.matrix[j+3][i];
                    int index=0;
                    for (int k = 1; k <4 ; k++) {
                        try {
                            if(flag1==Matrix.matrix[j+3+k][i]&&Matrix.matrix[j+3+k][i]==n){
                                index=k;
                            }else {
                                break;
                            }

                        }catch (Exception e){

                        }
                    }
                    for (int k = 0; k < index+4; k++) {
                        Matrix.matrix[j + k][i] = 0;
                        for (Move m : move) {
                            if ((m.rightImage.getLayoutY() - 120) / 10 == j + k && (m.rightImage.getLayoutX() / 10) - 14 == i) {
                                m.capsule.rightNumber = 0;
                                pane.getChildren().remove(m.rightImage);
                            }
                            if ((m.leftImage.getLayoutY() - 120) / 10 == j + k && (m.leftImage.getLayoutX() / 10) - 14 == i) {
                                m.capsule.leftNumber = 0;
                                pane.getChildren().remove(m.leftImage);
                            }
                        }
                        for (Virus virus : AllVirus.virus) {
                            if ((virus.imageView.getLayoutY() - 120) / 10 == j + k && virus.imageView.getLayoutX() / 10 - 14 == i) {
                                player.score++;
                                virus.number = 0;
                                pane.getChildren().remove(virus.imageView);
                            }
                        }
                    }
                }

            }
        }

    }
    public static void CheckForChangingPosition(Move move){
        int y = (int) (move.leftImage.getLayoutY() - 120) / 10;
        int x = (int) move.leftImage.getLayoutX() / 10 - 14;
        switch (move.capsule.capsulPosition) {
            case X :
            if (Matrix.matrix[y + 1][x] == 0) {
                move.rightImage.setLayoutY(move.rightImage.getLayoutY() - 10);
                move.rightImage.setLayoutX(move.rightImage.getLayoutX() - 10);
                move.capsule.capsulPosition=CapsulPosition.Y;
                Matrix.matrix[y-1][x]=move.capsule.rightNumber;
                Matrix.matrix[y][x+1]=0;

            }
            break;
            case Y:
               if(Matrix.matrix[y ][x+1] == 0){
                   move.rightImage.setLayoutY(move.rightImage.getLayoutY() + 10);
                   move.rightImage.setLayoutX(move.rightImage.getLayoutX() + 10);
                   move.capsule.capsulPosition=CapsulPosition.X;
                   Matrix.matrix[y-1][x]=0;
                   Matrix.matrix[y][x+1]=move.capsule.rightNumber;
               }
        }
    }
    public static void updateTheImages(){
        for(Move m:move) {
            if (m.capsule.leftNumber == 0 && m.capsule.rightNumber != 0) {
                int index = 0;
                int y = (int) (m.rightImage.getLayoutY() - 120) / 10;
                int x = (int) (m.rightImage.getLayoutX() / 10 - 14);
                for (int i = 1; i < 22; i++) {
                    try {
                        if (Matrix.matrix[y + i][x] == 0) {
                            index++;
                        }
                    }catch (Exception e){

                    }
                }
                m.rightImage.setLayoutY(m.rightImage.getLayoutY()+(10*index));
            }
            if (m.capsule.leftNumber != 0 && m.capsule.rightNumber == 0) {
                int index = 0;
                int y = (int) (m.leftImage.getLayoutY() - 120) / 10;
                int x = (int) (m.leftImage.getLayoutX() / 10 - 14);
                for (int i = 1; i < 22; i++) {
                    try {
                        if (Matrix.matrix[y + i][x] == 0) {
                            index++;
                        }
                    }catch (Exception e){

                    }
                }
                m.leftImage.setLayoutY(m.leftImage.getLayoutY()+(10*index));
            }

        }
    }
    public static void upDateTheScore(Pane pane,Player player){
        Text text=new Text();
        text.setText(""+player.score);
        text.setLayoutY(120);
        text.setLayoutX(50);
        pane.getChildren().add(text);
        System.out.println(player.score);
    }
}
