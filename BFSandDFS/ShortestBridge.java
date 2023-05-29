import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.Arrays;

public class ShortestBridge {
    boolean[][] visited;
    List<List<Integer>> trackIslandOne, queue;        
    public ShortestBridge(){
        trackIslandOne=new LinkedList<>();
        queue=new LinkedList<>();
    }
    public int shortestBridge(int[][] grid) {
        visited=new boolean[grid.length][grid.length];
        Arrays.stream(visited).forEach(array->Arrays.fill(array, false));        
        boolean flag=false;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid.length;j++){
                if(grid[i][j]==1){
                    visited[i][j]=true;
                    flag=true;
                    queue.add(List.of(i,j,0,0));
                    trackIslandOne.add(List.of(i,j));                    
                    this.bfsForFindingIslandOne(trackIslandOne, grid);       
                    break;                 
                }                
            }    
            if(flag)   
                break;        
        }                
        return this.breathFirstSearch(queue, grid);
    }    
    private void bfsForFindingIslandOne(List<List<Integer>> trackIslandOne, int[][] grid){
        while(!trackIslandOne.isEmpty()){
            int row=trackIslandOne.get(0).get(0);
            int column=trackIslandOne.get(0).get(1);
            isValidPosition(row, column-1, grid);     //Left
            isValidPosition(row, column+1, grid);     //Right
            isValidPosition(row-1, column, grid);     //Top
            isValidPosition(row+1, column, grid);     //Bottom
            trackIslandOne.remove(0);
        }
    }
    private void isValidPosition(int i, int j, int[][] grid){
        if(i>=0 && j>=0 && i<=grid.length-1 && j<=grid.length-1 && !visited[i][j] && grid[i][j]==1){
            visited[i][j]=true;
            queue.add(List.of(i,j,0,0));
            trackIslandOne.add(List.of(i,j));                        
        }        
    }
    private int breathFirstSearch(List<List<Integer>> queue, int[][] grid){                
        while(!queue.isEmpty()){            
            int row=queue.get(0).get(0);
            int column=queue.get(0).get(1);
            int currentLevel=queue.get(0).get(2);
            int isFound=queue.get(0).get(3);
            if(isFound==1)
                return currentLevel;
            foundUnVisitedIsland(row, column-1, currentLevel, grid);    //Left
            foundUnVisitedIsland(row, column+1, currentLevel, grid);    //Right
            foundUnVisitedIsland(row-1, column, currentLevel, grid);    //Top
            foundUnVisitedIsland(row+1, column, currentLevel, grid);    //Bottom
            queue.remove(0);
        }
        return 1;
    }
    private void foundUnVisitedIsland(int i, int j, int currentLevel, int[][] grid){
        if(i>=0 && j>=0 && i<=grid.length-1 && j<=grid.length-1 && !visited[i][j]){
            visited[i][j]=true;            
            queue.add(List.of(i,j,((grid[i][j]==1)?(currentLevel):(currentLevel+1)), (grid[i][j]==1)?(1):(0)));
        }        
    }
    public static void main(String[] args){
        Scanner sc;
        int[][] grid;
        try{
            sc=new Scanner(System.in);
            System.out.println("Enter grid length value : ");
            int n=sc.nextInt();
            grid=new int[n][n];
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    grid[i][j]=sc.nextInt();                    
                }
            }
            System.out.println(new ShortestBridge().shortestBridge(grid));
        }
        catch(Exception e){
            System.out.println("Exception occurred : "+e.getMessage());
            e.printStackTrace();
        }
    }
}

