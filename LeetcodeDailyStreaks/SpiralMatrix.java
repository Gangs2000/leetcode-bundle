package LeetcodeDailyStreaks;

import java.util.Scanner;
import java.util.LinkedList;
import java.util.List;

public class SpiralMatrix {
    List<Integer> list;
    public SpiralMatrix(){
        list=new LinkedList<>();
    }
    public List<Integer> spiralOrder(int[][] matrix) {
        int count=0, total=matrix.length*matrix[0].length, sr=0, sc=0, er=matrix.length-1, ec=matrix[0].length-1;
        while(count<total){
            //Starting row..
            for(int index=sc;(count<total && index<=ec);index++){
                list.add(matrix[sr][index]);
                count++;
            }
            //Ending column..
            for(int index=sr;(count<total && index<=er);index++){
                if(index==sr)
                    continue ;
                list.add(matrix[index][ec]);
                count++;
            }
            //Ending row..
            for(int index=ec;(count<total && index>=sc);index--){
                if(index==ec)
                    continue;
                list.add(matrix[er][index]);
                count++;
            }
            //Starting column..
            for(int index=er;(count<total && index>=sr);index--){
                if(index==er || index==sr)
                    continue;
                list.add(matrix[index][sc]);
                count++;
            }
            sr++; sc++; er--; ec--;
        }
        return list;
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
            System.out.println(new SpiralMatrix().spiralOrder(matrix));
        }   
        catch(Exception e){
            System.out.println("Exception occurred : "+e.getMessage());
            e.printStackTrace();
        }     
    }
}
