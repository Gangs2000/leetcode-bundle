package ZOHOQuestions;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class BeautifulMatrix {
    List<Integer> storeEachRowSum;
    int minOperationCount, maxRowSum, maxColSum;
    public BeautifulMatrix(){
        storeEachRowSum=new LinkedList<>();
        minOperationCount=0;
        maxRowSum=Integer.MIN_VALUE;
        maxColSum=Integer.MIN_VALUE;
    }
    public int returnMinOperationToMakeMatrixBeautiful(int[][] grid){
        for(int i=0;i<grid.length;i++){
            int rowSum=0;
            for(int j=0;j<grid.length;j++)
                rowSum+=grid[i][j];
            maxRowSum=Math.max(maxRowSum, rowSum);
            storeEachRowSum.add(rowSum);
            int colSum=0;
            for(int k=0;k<grid.length;k++)
                colSum+=grid[k][i];
            maxColSum=Math.max(maxColSum, colSum);
        }        
        int maxSum=Math.max(maxRowSum, maxColSum);
        for(int i=0;i<storeEachRowSum.size();i++)
            minOperationCount+=(maxSum-storeEachRowSum.get(i));
        return minOperationCount;
    }
    public static void main(String[] args){
        Scanner sc;
        int[][] grid;
        try{
            sc=new Scanner(System.in);
            System.out.println("Enter N value : ");
            int n=sc.nextInt();
            grid=new int[n][n];
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    grid[i][j]=sc.nextInt();
                }
            }
            System.out.println(new BeautifulMatrix().returnMinOperationToMakeMatrixBeautiful(grid));
        }
        catch(Exception e){
            System.out.println("Exception occurred : "+e.getMessage());
            e.printStackTrace();
        }
    }
}
