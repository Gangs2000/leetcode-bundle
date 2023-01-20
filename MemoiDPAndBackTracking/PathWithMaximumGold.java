package MemoiDPAndBackTracking;

import java.util.Scanner;
import java.util.LinkedList;
import java.util.List;

public class PathWithMaximumGold {
    int maxGold=0;
    public int getMaximumGold(int[][] grid) {
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[i].length;j++){          
                if(grid[i][j]!=0)
                    findAllPaths(i, j, 0, new LinkedList<>(), grid);
            }
        }
        return maxGold;
    }
    public void findAllPaths(int i, int j, int sum, List<Integer> tracker, int[][] grid){
        if(i<0 || j<0 || i>=grid.length || j>=grid[i].length || grid[i][j]==0)
            return ;        
        sum+=grid[i][j];
        maxGold=Math.max(maxGold, sum);        
        tracker.add(grid[i][j]);
        grid[i][j]=0;
        //Directions
        findAllPaths(i, j-1, sum, tracker, grid);     //Left
        findAllPaths(i, j+1, sum, tracker, grid);     //Right
        findAllPaths(i-1, j, sum, tracker, grid);     //Top
        findAllPaths(i+1, j, sum, tracker, grid);     //Bottom
        grid[i][j]=tracker.get(tracker.size()-1);
        tracker.remove(tracker.size()-1);
        sum-=grid[i][j];
    }
    public static void main(String[] args){
        Scanner sc;
        try{
            sc=new Scanner(System.in);
            System.out.println("Enter M and N value : ");
            int m=sc.nextInt(); int n=sc.nextInt();
            int[][] grid=new int[m][n];
            for(int i=0;i<m;i++){
                for(int j=0;j<n;j++){
                    grid[i][j]=sc.nextInt();
                }
            }
            System.out.println(new PathWithMaximumGold().getMaximumGold(grid));
        }
        catch(Exception e){
            System.out.println("Exception occurred : "+e.getMessage());
            e.printStackTrace();
        }
    }
}
