package MemoiDPAndBackTracking;

import java.util.Arrays;
import java.util.Scanner;

public class MinimumPathSum {    
    public int minPathSum(int[][] grid) {   
        int[][] dp=new int[grid.length][grid[0].length];         
        Arrays.stream(dp).forEach(array -> Arrays.fill(array, -1));
        return traversePath(0, 0, dp, grid);
    }
    public int traversePath(int i, int j,int[][] dp, int[][] grid){                      
        if(i==grid.length-1 && j==grid.length-1)
            return grid[i][j];
        if(dp[i][j]!=-1)
            return dp[i][j];
        if(i==grid.length-1)
            return dp[i][j]=grid[i][j]+traversePath(i, j+1, dp, grid);
        else if(j==grid[i].length-1)
            return dp[i][j]=grid[i][j]+traversePath(i+1, j, dp, grid);
        else
            return dp[i][j]=grid[i][j]+Math.min(traversePath(i, j+1, dp, grid), traversePath(i+1, j, dp, grid));
    }
    public static void main(String[] args){
        Scanner sc;
        int[][] grid;
        try{
            sc=new Scanner(System.in);
            System.out.println("Enter M and N values : ");
            int row=sc.nextInt();
            int column=sc.nextInt();
            grid=new int[row][column];
            for(int i=0;i<row;i++){
                for(int j=0;j<column;j++){
                    grid[i][j]=sc.nextInt();
                }
            }
            System.out.println(new MinimumPathSum().minPathSum(grid));
        }
        catch(Exception e){
            System.out.println("Exception occurred : "+e.getMessage());
            e.printStackTrace();
        }
    }
}
