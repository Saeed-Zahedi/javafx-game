package ir.ac.kntu;

public class Matrix {
    public static int [][]matrix=new int[25][12];

    public Matrix() {
    }
    public static void makeMatrix(){
        for(int i=0;i<12;i++){
            matrix[24][i]=1;
        }
        for(int i=0;i<25;i++){
            matrix[i][0]=1;
            matrix[i][11]=1;
        }
    }
    public static void seeMatrix(){
        for(int i=0;i<25;i++){
            for (int j = 0; j <12; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
    }
}
