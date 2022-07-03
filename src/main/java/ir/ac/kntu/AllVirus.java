package ir.ac.kntu;

import java.util.ArrayList;

public class AllVirus {
    public static ArrayList<Virus>virus=new ArrayList<>();
    public static void makeVirus(int number){
        for (int i = 0; i < number; i++) {
            new Virus(i);
        }
    }
}
