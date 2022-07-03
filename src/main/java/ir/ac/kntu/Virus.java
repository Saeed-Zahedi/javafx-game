package ir.ac.kntu;

import javafx.scene.image.ImageView;

public class Virus {
    ImageView imageView;
    int number;
    public Virus(int input) {
        int n=input%3;
       this.imageView=AllVirusImages.imageViews.get(input);
        switch (n){
            case 0:number=2;
            break;
            case 1:number=3;
            break;
            case 2:number=4;
            break;
        }
        AllVirus.virus.add(this);
    }
}
