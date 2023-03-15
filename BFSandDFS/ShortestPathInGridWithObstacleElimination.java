import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class ShortestPathInGridWithObstacleElimination {
    List<List<Integer>> queue;
    boolean[][][] visited;
    int minSteps=Integer.MAX_VALUE;
    public ShortestPathInGridWithObstacleElimination(){
        queue=new LinkedList<>();        
    }
    public int shortestPath(int[][] grid, int k) {
        visited = new boolean[grid.length][grid[0].length][k + 1];        
        queue.add(List.of(0,0,k,0));
        visited[0][0][k]=true;
        while(!queue.isEmpty()){
            int row=queue.get(0).get(0);
            int column=queue.get(0).get(1);
            int remainingObstacles=queue.get(0).get(2);
            int steps=queue.get(0).get(3);
            if(row==grid.length-1 && column==grid[row].length-1)                
                minSteps=Math.min(minSteps, steps);
            this.directions(row, column, remainingObstacles, steps, grid);            
            queue.remove(0);                                           
        }
        return (minSteps==Integer.MAX_VALUE)?(-1):(minSteps);        
    }
    public void directions(int row, int column, int remainingObstacles, int steps, int[][] grid){
        this.bfs(row, column-1, remainingObstacles, steps, grid);     //Left
        this.bfs(row, column+1, remainingObstacles, steps, grid);     //Right
        this.bfs(row-1, column, remainingObstacles, steps, grid);     //Top
        this.bfs(row+1, column, remainingObstacles, steps, grid);     //Bottom
    }
    public void bfs(int row, int column, int obstacle, int steps, int[][] grid){
        //Boundary limit condition..
        if(row>=0 && column>=0 && row<=grid.length-1 && column<=grid[row].length-1){            
            if(grid[row][column]==0 && !visited[row][column][obstacle]){
                queue.add(List.of(row, column, obstacle, steps+1));                
                visited[row][column][obstacle]=true;
            }
            if(grid[row][column]==1 && obstacle!=0 && !visited[row][column][obstacle-1]){
                queue.add(List.of(row, column, obstacle-1, steps+1));                
                visited[row][column][obstacle-1]=true;
            }            
        }
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
            System.out.println("Enter K value : ");
            int k=sc.nextInt();
            System.out.println(new ShortestPathInGridWithObstacleElimination().shortestPath(grid, k));
        }
        catch(Exception e){
            System.out.println("Exception occurred : "+e.getMessage());
            e.printStackTrace();
        }
    }
}
