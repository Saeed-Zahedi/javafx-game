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
    public static Scene gameLoop(Player player,int level,Speed speed) throws FileNotFoundException {
        Pane pane=new Pane();
        /*for (int i=0;i<AllCapsules.capsules.size();i++){
            pane.getChildren().add(AllCapsules.capsules.get(i).imageViewLeft);
            pane.getChildren().add(AllCapsules.capsules.get(i).imageViewRight);
        }*/
       // Circle circle=new Circle(200,120,10,Color.RED);
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
        text.setText("Score:");
        text.setLayoutX(30);
        text.setLayoutY(80);
        text.setStroke(Color.RED);
        text.setStrokeWidth(2);
        pane.getChildren().add(imageView);
        pane.getChildren().add(text);
       // pane.getChildren().add(circle);
        Scene scene=new Scene(pane,400,400);
        boolean flag=true;
        ArrayList<Move>move=new ArrayList<>();
        for(int i=0;i<50;i++){
            move.add(new Move(pane,i));
        }

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
        });
        mainThread.start();
        //virusThread.start();
        return scene;
    }
        public static boolean checktheplaceForRight(Capsule capsule){
        boolean re=true;
        int x=(int)(capsule.imageViewLeft.getLayoutX()/10)-14;
        int y=(int)(capsule.imageViewLeft.getLayoutY()-120)/10;
        if(Matrix.matrix[y][x+2]!=0){
            re=false;
       }
        else {
            Matrix.matrix[y][x]=0;
            Matrix.matrix[y][x+1]= capsule.leftNumber;
            Matrix.matrix[y][x+2]= capsule.rightNumber;
        }
        return re;
    }
    public static boolean CheckforDown(Capsule capsule){
        boolean re=true;
        int x=(int)(capsule.imageViewLeft.getLayoutX()/10)-14;
        int y=(int)(capsule.imageViewLeft.getLayoutY()-120)/10;
        if(Matrix.matrix[y+1][x]!=0||Matrix.matrix[y+1][x+1]!=0){
            re=false;
        }
        else {
            Matrix.matrix[y][x]=0;
            Matrix.matrix[y][x+1]=0;
            Matrix.matrix[y+1][x]= capsule.leftNumber;
            Matrix.matrix[y+1][x+1]=capsule.rightNumber;
        }
        return re;
    }
    public static boolean checkforLeft(Capsule capsule){
        boolean re=true;
        int x=(int)(capsule.imageViewLeft.getLayoutX()/10)-14;
        int y=(int)(capsule.imageViewLeft.getLayoutY()-120)/10;

        if(Matrix.matrix[y][x-1]!=0){
            re=false;
        }
        else {
            Matrix.matrix[y][x+1]=0;
            Matrix.matrix[y][x-1]=capsule.leftNumber;
            Matrix.matrix[y][x]=capsule.rightNumber;

        }
        return re;
    }
    /*public static ArrayList<Move> upDateForMatrix(ArrayList<Move>moves,Pane pane){
        ArrayList<Move>re=new ArrayList<>();
        for(int i=0;i<re.size();i++){
            re.remove(i);
        }
        for(int i=0;i<24;i++){
            for (int j=1;j<=7;j++){
                    int n=Matrix.matrix[i][j];
                    if(Matrix.matrix[i][j+1]==n&&Matrix.matrix[i][j+2]==n&&Matrix.matrix[i][j+3]==n&&n!=0){
                          //  for (int k = 0; k < 4; k++) {
                             for(Move m:moves){
                                 if((m.getImageView().getLayoutY()-120)/10==i){
                                     if((m.getImageView().getLayoutX()/10)-14==j){
                                         re.add(m);
                                     }
                                  }
                                 }
                        for(Move m1:moves){
                            if((m1.getImageView().getLayoutY()-120)/10==i){
                                if((m1.getImageView().getLayoutX()/10)-14==j+2){
                                    System.out.println("happend2");
                                    re.add(m1);

                                }
                            }
                        }
                           // }
                    }
            }
        }
        for (int i = 1; i < 11; i++) {
            for(int j=0;j<22;j++){
                int n=Matrix.matrix[j][i];
                if(Matrix.matrix[j+1][i]==n&&Matrix.matrix[j+2][i]==n&&Matrix.matrix[j+3][i]==n&&n!=0) {
                    for (int k = 0; k < 4; k++) {
                     for(Move m:moves){
                         if((m.getImageView().getLayoutX()/10)-14==i){
                             if((m.getImageView().getLayoutY()-120)/10==j){
                                 pane.getChildren().remove(m);
                             }
                         }
                     }
                    }
                }
            }
        }
        return re;
    }
    public static boolean CheckupDateForMatrix(ArrayList<Move>moves,Pane pane){
        boolean re=false;
        for(int i=0;i<24;i++){
            for (int j=1;j<=7;j++){
                int n=Matrix.matrix[i][j];
                if(Matrix.matrix[i][j+1]==n&&Matrix.matrix[i][j+2]==n&&Matrix.matrix[i][j+3]==n&&n!=0){
                    System.out.println("happend1");
                    for (int k = 0; k < 4; k++) {
                        for(Move m:moves){
                            if((m.getImageView().getLayoutY()-120)/10==i){
                                if((m.getImageView().getLayoutX()/10)-14==j){
                                   // System.out.println("happend2");
                                    // pane.getChildren().remove(m.getImageView());
                                    re=true;

                                }
                            }
                        }
                    }
                }
            }
        }
        for (int i = 1; i < 11; i++) {
            for(int j=0;j<22;j++){
                int n=Matrix.matrix[j][i];
                if(Matrix.matrix[j+1][i]==n&&Matrix.matrix[j+2][i]==n&&Matrix.matrix[j+3][i]==n&&n!=0) {
                    for (int k = 0; k < 4; k++) {
                        for(Move m:moves){
                            if((m.getImageView().getLayoutX()/10)-14==i){
                                if((m.getImageView().getLayoutY()-120)/10==j){
                                    pane.getChildren().remove(m);
                                }
                            }
                        }
                    }
                }
            }
        }
      //  return re;
    }*/
}
