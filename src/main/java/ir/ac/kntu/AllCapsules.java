package ir.ac.kntu;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class AllCapsules {
    public static ArrayList<Capsule>capsules=new ArrayList<>();
    public static void makeCapsule(int n){
        for(int i=0;i<n;i+=2){
            new Capsule(i);
        }
    }
}
