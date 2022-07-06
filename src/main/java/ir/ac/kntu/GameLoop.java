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
import javafx.stage.Stage;

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
    static Text text1=new Text();
    public static Scene gameLoop(Player player, int level, Speed speed, Stage stage) throws FileNotFoundException {
        AllVirus.makeVirus(level*4);
        Pane pane=new Pane();
        FileInputStream fileInputStream=new FileInputStream("C:\\Users\\np\\IdeaProjects\\project4\\src\\main\\resources\\images\\MainScene2.png");
        Image image=new Image(fileInputStream);
        ImageView imageView=new ImageView(image);
        imageView.setFitHeight(400);
        imageView.setFitWidth(400);
        FileInputStream fileInputStreamGameOver=new FileInputStream("C:\\Users\\np\\IdeaProjects\\project4\\src\\main\\resources\\images\\GameOver.png");
        Image imageGameOver=new Image(fileInputStreamGameOver);
        ImageView imageViewGameOver=new ImageView(imageGameOver);
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
            imageViews.get(i).setLayoutX(75);
            imageViews.get(i).setLayoutY(250);
            imageViews.get(i).setFitHeight(30);
            imageViews.get(i).setFitWidth(30);
        }
        FileInputStream fileInputStream12=new FileInputStream("C:\\Users\\np\\IdeaProjects\\project4\\src\\main\\resources\\images\\FirstRVirus.PNG");
        FileInputStream fileInputStream22=new FileInputStream("C:\\Users\\np\\IdeaProjects\\project4\\src\\main\\resources\\images\\SecondRVirus.PNG");
        FileInputStream fileInputStream32=new FileInputStream("C:\\Users\\np\\IdeaProjects\\project4\\src\\main\\resources\\images\\ThirdRVirus.PNG");
        FileInputStream fileInputStream42=new FileInputStream("C:\\Users\\np\\IdeaProjects\\project4\\src\\main\\resources\\images\\FourthRVirus.PNG");
        FileInputStream fileInputStream52=new FileInputStream("C:\\Users\\np\\IdeaProjects\\project4\\src\\main\\resources\\images\\FiveRVirus.PNG");
        FileInputStream fileInputStream62=new FileInputStream("C:\\Users\\np\\IdeaProjects\\project4\\src\\main\\resources\\images\\SixRVirus.PNG");
        Image image12=new Image(fileInputStream12);
        Image image22=new Image(fileInputStream22);
        Image image32=new Image(fileInputStream32);
        Image image42=new Image(fileInputStream42);
        Image image52=new Image(fileInputStream52);
        Image image62=new Image(fileInputStream62);
        ImageView imageView12=new ImageView(image12);
        ImageView imageView22=new ImageView(image22);
        ImageView imageView32=new ImageView(image32);
        ImageView imageView42=new ImageView(image42);
        ImageView imageView52=new ImageView(image52);
        ImageView imageView62=new ImageView(image62);
        ArrayList<ImageView>imageViews2=new ArrayList<>();
        imageViews2.add(imageView12);
        imageViews2.add(imageView22);
        imageViews2.add(imageView32);
        imageViews2.add(imageView42);
        imageViews2.add(imageView52);
        imageViews2.add(imageView62);
        for (int i = 0; i < imageViews2.size(); i++) {
            imageViews2.get(i).setLayoutX(30);
            imageViews2.get(i).setLayoutY(250);
            imageViews2.get(i).setFitHeight(30);
            imageViews2.get(i).setFitWidth(30);
        }
        FileInputStream fileInputStreamDr1=new FileInputStream("C:\\Users\\np\\IdeaProjects\\project4\\src\\main\\resources\\images\\FirstDr.PNG");
        Image imageDr1=new Image(fileInputStreamDr1);
        ImageView imageViewDr1=new ImageView(imageDr1);
        imageViewDr1.setLayoutY(130);
        imageViewDr1.setLayoutX(300);
        FileInputStream fileInputStreamDr2=new FileInputStream("C:\\Users\\np\\IdeaProjects\\project4\\src\\main\\resources\\images\\SecondDr.PNG");
        Image imageDr2=new Image(fileInputStreamDr2);
        ImageView imageViewDr2=new ImageView(imageDr2);
        imageViewDr2.setLayoutY(130);
        imageViewDr2.setLayoutX(300);
        FileInputStream fileInputStreamDr3=new FileInputStream("C:\\Users\\np\\IdeaProjects\\project4\\src\\main\\resources\\images\\ThirdDr.PNG");
        Image imageDr3=new Image(fileInputStreamDr3);
        ImageView imageViewDr3=new ImageView(imageDr3);
        imageViewDr3.setLayoutY(130);
        imageViewDr3.setLayoutX(300);
        ArrayList<ImageView>Dr=new ArrayList<>();
        Dr.add(imageViewDr1);
        Dr.add(imageViewDr2);
        Dr.add(imageViewDr3);
        FileInputStream fileInputStream13=new FileInputStream("C:\\Users\\np\\IdeaProjects\\project4\\src\\main\\resources\\images\\FirstBVirus.PNG");
        FileInputStream fileInputStream23=new FileInputStream("C:\\Users\\np\\IdeaProjects\\project4\\src\\main\\resources\\images\\SecondBVirus.PNG");
        FileInputStream fileInputStream33=new FileInputStream("C:\\Users\\np\\IdeaProjects\\project4\\src\\main\\resources\\images\\ThirdBVirus.PNG");
        FileInputStream fileInputStream43=new FileInputStream("C:\\Users\\np\\IdeaProjects\\project4\\src\\main\\resources\\images\\FourthBVirus.PNG");
        FileInputStream fileInputStream53=new FileInputStream("C:\\Users\\np\\IdeaProjects\\project4\\src\\main\\resources\\images\\FiveBVirus.PNG");
        FileInputStream fileInputStream63=new FileInputStream("C:\\Users\\np\\IdeaProjects\\project4\\src\\main\\resources\\images\\First1BVirus.PNG");
        Image image13=new Image(fileInputStream13);
        Image image23=new Image(fileInputStream23);
        Image image33=new Image(fileInputStream33);
        Image image43=new Image(fileInputStream43);
        Image image53=new Image(fileInputStream53);
        Image image63=new Image(fileInputStream63);
        ImageView imageView13=new ImageView(image13);
        ImageView imageView23=new ImageView(image23);
        ImageView imageView33=new ImageView(image33);
        ImageView imageView43=new ImageView(image43);
        ImageView imageView53=new ImageView(image53);
        ImageView imageView63=new ImageView(image63);
        ArrayList<ImageView>imageViews3=new ArrayList<>();
        imageViews3.add(imageView13);
        imageViews3.add(imageView23);
        imageViews3.add(imageView33);
        imageViews3.add(imageView43);
        imageViews3.add(imageView53);
        imageViews3.add(imageView63);
        for (int i = 0; i < imageViews2.size(); i++) {
            imageViews3.get(i).setLayoutX(50);
            imageViews3.get(i).setLayoutY(300);
            imageViews3.get(i).setFitHeight(30);
            imageViews3.get(i).setFitWidth(30);
        }
        Text text=new Text();
        text.setText("Score :");
        text.setLayoutX(30);
        text.setLayoutY(100);
        text.setStroke(Color.DARKORANGE);
        text.setStrokeWidth(2);
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
                n = j;
                if(!GameStatusUpDator.GameStatusCheckerForGameOver()) {
                    for (int i = 0; i < 23; i++) {
                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException t) {

                        }
                        Platform.runLater(move.get(j));
                    }
                }else {
                    break;
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
        Thread virusThread2=new Thread(()->{
            try {
                Thread.sleep(2000);
            }
            catch (InterruptedException e){

            }
            for(int i=0;i<10000;i++){
                Platform.runLater(new VisrusAnimataion(imageViews2,pane,i));
                try {
                    Thread.sleep(100);
                }catch (InterruptedException ex){

                }
                Platform.runLater(new VirusAnimation2(imageViews2,pane,i));
                try {
                    Thread.sleep(100);
                }catch (InterruptedException ex){

                }
            }
        });
        Thread virusThread3=new Thread(()->{
            try {
                Thread.sleep(2000);
            }
            catch (InterruptedException e){

            }
            for(int i=0;i<10000;i++){
                Platform.runLater(new VisrusAnimataion(imageViews3,pane,i));
                try {
                    Thread.sleep(100);
                }catch (InterruptedException ex){

                }
                Platform.runLater(new VirusAnimation2(imageViews3,pane,i));
                try {
                    Thread.sleep(100);
                }catch (InterruptedException ex){

                }
            }
        });
        Thread DrThread=new Thread(()->{
            try {
                Thread.sleep(2000);
            }
            catch (InterruptedException e){

            }
            for(int i=0;i<10000;i++){
                Platform.runLater(new DrAnimation(Dr,pane,i));
                if(i%3==0){
                    try {
                        Thread.sleep(12000);
                    } catch (InterruptedException e) {

                    }
                }
                try {
                    Thread.sleep(100);
                }catch (InterruptedException ex){

                }
                Platform.runLater(new DrAnimation2(Dr,pane,i));
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
        virusThread2.start();
        virusThread3.start();
        DrThread.start();

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
        text1.setText(""+player.score);
        text1.setLayoutY(120);
        text1.setLayoutX(50);
        try {
            pane.getChildren().remove(text1);
        }catch (Exception e){

        }
        pane.getChildren().add(text1);
    }
}
