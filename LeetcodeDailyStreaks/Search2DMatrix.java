package LeetcodeDailyStreaks;

import java.util.Scanner;

public class Search2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        //Binary search column wise..
        int start=0, end=matrix.length-1;            
        while(start<=end){
            int middle=start+((end-start))/2;
            if(matrix[middle][0]==target)
                return true;
            else if(matrix[middle][0]>target)
                end=middle-1;
            else if(matrix[middle][0]<target)
                start=middle+1;
        }
        if(end>=0){
            int[] row=matrix[end];
            //Binary search row wise..
            start=0; end=matrix[0].length-1;
            while(start<=end){
                int middle=start+((end-start))/2;
                if(row[middle]==target)
                    return true;
                else if(row[middle]>target)
                    end=middle-1;
                else if(row[middle]<target)
                    start=middle+1;
            }
        }
        return false;
    }    
    public static void main(String[] args){
        Scanner sc;
        int[][] grid;
        try{
            sc=new Scanner(System.in);
            System.out.println("Enter M and N values : ");
            int m=sc.nextInt();
            int n=sc.nextInt();
            grid=new int[m][n];
            for(int i=0;i<m;i++){
                for(int j=0;j<n;j++){
                    grid[i][j]=sc.nextInt();
                }
            }
            System.out.println("Enter Target Value : ");
            int target=sc.nextInt();
            System.out.println(new Search2DMatrix().searchMatrix(grid, target));
        }
        catch(Exception e){
            System.out.println("Exception occurred : "+e.getMessage());
            e.printStackTrace();
        }
    }
}
