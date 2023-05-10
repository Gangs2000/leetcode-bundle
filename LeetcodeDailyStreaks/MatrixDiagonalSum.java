package LeetcodeDailyStreaks;

import java.util.Scanner;

public class MatrixDiagonalSum {
    int diagonalSum=0;
    public int diagonalSum(int[][] mat) {
        int rp1=0, lp1=0, rp2=0, lp2=mat[0].length-1;
        while(rp1<mat.length && rp2<mat.length){
            diagonalSum+=mat[rp1][lp1]+mat[rp2][lp2];
            rp1++; lp1++;
            rp2++; lp2--;
        }
        return (mat.length%2==0)?(diagonalSum):(diagonalSum-mat[mat.length/2][mat.length/2]);
    }
    public static void main(String[] args){
        Scanner sc;
        int[][] grid;
        try{    
            sc=new Scanner(System.in);
            System.out.println("Enter Rows and Columns value : ");
            int n=sc.nextInt();
            grid=new int[n][n];
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    grid[i][j]=sc.nextInt();
                }
            }
            System.out.println(new MatrixDiagonalSum().diagonalSum(grid));
        }
        catch(Exception e){
            System.out.println("Exception occurred : "+e.getMessage());
            e.printStackTrace();
        }
    }
}
