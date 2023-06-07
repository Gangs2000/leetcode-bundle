import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class DetectCyclesin2DGrid {
    List<List<Integer>> queue;    
    int[][] visited, tracker;
    public DetectCyclesin2DGrid(){
        queue=new LinkedList<>();        
    }
    public boolean containsCycle(char[][] grid) {
        visited=new int[grid.length][grid[0].length];        
        tracker=new int[grid.length][grid[0].length];        
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[i].length;j++){
                if(visited[i][j]==0){
                    visited[i][j]=1;
                    queue.add(List.of(i,j,1));
                    tracker[i][j]=1;
                    if(breathFirstSearch(grid, grid[i][j]))
                        return true;                                 
                }
            }
        }
        return false;
    }
    public boolean breathFirstSearch(char[][] grid, char character){        
        while(!queue.isEmpty()){
            List<Integer> firstList=queue.get(0);
            int i=firstList.get(0);                 //Row
            int j=firstList.get(1);                 //Column
            int currentLevel=firstList.get(2);      //Current level
            if(isValidBoundary(grid, i, j-1, currentLevel, character))  //Left
                return true;
            if(isValidBoundary(grid, i, j+1, currentLevel, character))  //Right
                return true;
            if(isValidBoundary(grid, i-1, j, currentLevel, character))  //Top
                return true;
            if(isValidBoundary(grid, i+1, j, currentLevel, character))  //Bottom
                return true;
            queue.remove(0);
        }
        return false;
    }
    public boolean isValidBoundary(char[][] grid, int i, int j, int level, char character){
        if(i>=0 && j>=0 && i<=grid.length-1 && j<=grid[i].length-1 && grid[i][j]==character){                        
            if(tracker[i][j]==level+1)
                return true;            
            if(visited[i][j]==0){
                visited[i][j]=1;
                queue.add(List.of(i,j,level+1));
                tracker[i][j]=level+1;
            }            
        }
        return false;
    }
    public static void main(String[] args){
        Scanner sc;
        char[][] grid;
        try{
            sc=new Scanner(System.in);
            System.out.println("Enter M and N values : ");
            int m=sc.nextInt();
            int n=sc.nextInt();
            grid=new char[m][n];
            for(int i=0;i<m;i++){
                for(int j=0;j<n;j++){
                    grid[i][j]=sc.next().charAt(0);
                }
            }
            System.out.println(new DetectCyclesin2DGrid().containsCycle(grid));
        }   
        catch(Exception e){
            System.out.println("Exception occurred : "+e.getMessage());
            e.printStackTrace();
        }
    }
}
