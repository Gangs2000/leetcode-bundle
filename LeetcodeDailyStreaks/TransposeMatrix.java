package LeetcodeDailyStreaks;

import java.util.Scanner;

public class TransposeMatrix {
    int[][] transposedMatrix;
    public int[][] transpose(int[][] matrix) {
        transposedMatrix=new int[matrix[0].length][matrix.length];
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[i].length;j++)
                transposedMatrix[j][i]=matrix[i][j];
        }
        return transposedMatrix;
    }
    public static void main(String[] args){
        Scanner sc;
        int[][] matrix;
        try{
            sc=new Scanner(System.in);
            System.out.println("Enter M and N values : ");
            int m=sc.nextInt();
            int n=sc.nextInt();
            matrix=new int[m][n];
            for(int i=0;i<m;i++){
                for(int j=0;j<n;j++){
                    matrix[i][j]=sc.nextInt();
                }
            }
            System.out.println(new TransposeMatrix().transpose(matrix));
        }
        catch(Exception e){
            System.out.println("Exception occurred : "+e.getMessage());
            e.printStackTrace();
        }
    }
}
