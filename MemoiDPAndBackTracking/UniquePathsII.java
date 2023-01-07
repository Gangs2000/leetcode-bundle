package MemoiDPAndBackTracking;

import java.util.Scanner;

public class UniquePathsII {
    int uniquePathsCount=0;
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        backTrackingThroughGrid(obstacleGrid, 0, 0);
        return uniquePathsCount;
    }
    public void backTrackingThroughGrid(int[][] grid, int x, int y){
        if(x<0 || y<0 || x>=grid.length || y>=grid[x].length || grid[x][y]==1)
            return ;
        if(x==grid.length-1 && y==grid[x].length-1){
            uniquePathsCount++;
            return ;            
        }        
        grid[x][y]=1;        
        backTrackingThroughGrid(grid, x, y+1);        //Right        
        backTrackingThroughGrid(grid, x+1, y);        //Bottom
        grid[x][y]=0;
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
            System.out.println(new UniquePathsII().uniquePathsWithObstacles(grid));
        }
        catch(Exception e){
            System.out.println("Exception occurred : "+e.getMessage());
            e.printStackTrace();
        }
    }
}
