package LeetcodeDailyStreaks;

import java.util.Scanner;

public class SpiralMatrixII {
    int[][] spiralMatrix;
    public int[][] generateMatrix(int n) {
        spiralMatrix=new int[n][n];
        int count=0, total=n*n, element=1, sr=0, sc=0, er=n-1, ec=n-1;
        while(count<total){
            //Starting row..
            for(int index=sc;(count<total && index<=ec);index++){
                spiralMatrix[sr][index]=element;
                element++; count++;
            }
            //Ending column..
            for(int index=sr;(count<total && index<=er);index++){
                if(index==sr)
                    continue;
                spiralMatrix[index][ec]=element;
                element++; count++;
            }
            //Ending row..
            for(int index=ec;(count<total && index>=sc);index--){
                if(index==ec)
                    continue;
                spiralMatrix[er][index]=element;
                element++; count++;
            }
            //Starting column..
            for(int index=er;(count<total && index>=sr);index--){
                if(index==er || index==sr)
                    continue;
                spiralMatrix[index][sc]=element;
                element++; count++;
            }
            sr++; sc++; er--; ec--;
        }
        return spiralMatrix;
    }
    public static void main(String[] args){
        Scanner sc;        
        try{
            sc=new Scanner(System.in);
            System.out.println("Enter N value : ");
            int n=sc.nextInt();
            System.out.println(new SpiralMatrixII().generateMatrix(n));
        }
        catch(Exception e){
            System.out.println("Exception occurred : "+e.getMessage());
            e.printStackTrace();
        }
    }
}
