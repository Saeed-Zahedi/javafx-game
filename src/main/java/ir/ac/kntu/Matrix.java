package ir.ac.kntu;

public class Matrix {
    public static int [][]matrix=new int[23][11];

    public Matrix() {
    }
    public static void makeMatrix(){
        for(int i=0;i<11;i++){
            matrix[22][i]=1;
        }
        for(int i=0;i<23;i++){
            matrix[i][0]=1;
            matrix[i][10]=1;
        }
    }
    public static void seeMatrix(){
        for(int i=0;i<23;i++){
            for (int j = 0; j < 11; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
    }
}
