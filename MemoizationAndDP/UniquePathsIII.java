package MemoizationAndDP;

import java.util.Scanner;

public class UniquePathsIII {    
    int x=0, y=0, nonObstaclesCount=0, uniquePathCount=0;
    public int uniquePathsIII(int[][] grid) {
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[i].length;j++){
                if(grid[i][j]==1){
                    x=i; y=j;
                    nonObstaclesCount++;
                }
                if(grid[i][j]==0)
                    nonObstaclesCount++;
            }
        }        
        classicBackTracking(grid, 0, x, y);
        return uniquePathCount;
    }
    public void classicBackTracking(int[][] grid, int countVisited, int x, int y){
        //Checking boundary condition
        if(x<0 || x>=grid.length || y<0 || y>=grid[x].length || grid[x][y]==-1)
            return ;
        if(grid[x][y]==2){
            if(countVisited==nonObstaclesCount)
                uniquePathCount++;
            return ;
        }
        grid[x][y]=-1;
        classicBackTracking(grid, countVisited+1, x, y-1);            //Left
        classicBackTracking(grid, countVisited+1, x, y+1);            //Right
        classicBackTracking(grid, countVisited+1, x-1, y);            //Top
        classicBackTracking(grid, countVisited+1, x+1, y);            //Bottom
        grid[x][y]=0;
    }
    public static void main(String[] args){
        Scanner sc;
        int[][] grid;
        try{
            sc=new Scanner(System.in);
            System.out.println("Enter M and N value : ");
            int m=sc.nextInt();
            int n=sc.nextInt();
            grid=new int[m][n];
            for(int i=0;i<m;i++){
                for(int j=0;j<n;j++){
                    grid[i][j]=sc.nextInt();
                }
            }
            System.out.println(new UniquePathsIII().uniquePathsIII(grid));
        }
        catch(Exception e){
            System.out.println("Exception occurred : "+e.getMessage());
            e.printStackTrace();
        }
    }
}
