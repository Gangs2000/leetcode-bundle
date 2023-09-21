package MemoiDPAndBackTracking;

import java.util.Scanner;

public class UniquePathsII {    
    int[][] cache;
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        cache=new int[obstacleGrid.length][obstacleGrid[0].length];        
        return findAllPossiblePaths(0, 0, cache, obstacleGrid);
    }    
    public int findAllPossiblePaths(int i, int j, int[][] cache, int[][] grid){
        if(i==grid.length || j==grid[i].length || grid[i][j]==1)
            return 0;
        if(i==grid.length-1 && j==grid[i].length-1)
            return 1;
        if(cache[i][j]!=0)
            return cache[i][j];
        return cache[i][j]=findAllPossiblePaths(i, j+1, cache, grid)+findAllPossiblePaths(i+1, j, cache, grid);
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
