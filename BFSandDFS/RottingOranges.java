import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class RottingOranges {
    int minutes=0, freshOranges=0, rottenOranges=0;
    List<List<Integer>> queue;
    public RottingOranges(){
        queue=new LinkedList<>();
    }
    public int orangesRotting(int[][] grid) {
        //find rotten oranges and fresh oranges
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[i].length;j++){
                if(grid[i][j]==1)
                    freshOranges++;                         //Counting fresh oranges
                else if(grid[i][j]==2)
                    queue.add(List.of(i,j));                //Adding rotten oranges indicies to the queue
            }
        }
        if(freshOranges==0 && queue.isEmpty())
            return 0;
        if(freshOranges!=0 && queue.isEmpty())
            return -1;
        while(!queue.isEmpty())
            directions(queue, grid);                        
        return (freshOranges==rottenOranges)?(minutes):(-1);
    }
    public void directions(List<List<Integer>> queue, int[][] grid){        
        int start=0, end=queue.size();        
        while(start<end){
            int i=queue.get(0).get(0);
            int j=queue.get(0).get(1);
            checkBoundAndAddRottenIndicies(i, j-1, grid);         //Left
            checkBoundAndAddRottenIndicies(i, j+1, grid);         //Right
            checkBoundAndAddRottenIndicies(i-1, j, grid);         //Top
            checkBoundAndAddRottenIndicies(i+1, j, grid);         //Bottom
            queue.remove(0); start++;                        
        }
        if(queue.size()!=0)
            minutes++;
    }
    public void checkBoundAndAddRottenIndicies(int i, int j, int[][] grid){
        if(i>=0 && j>=0 && i<=grid.length-1 && j<=grid[i].length-1){
            if(grid[i][j]==1){
                grid[i][j]=2;
                queue.add(List.of(i,j));
                rottenOranges++;
            }
        }
    }
    public static void main(String[] args){
        Scanner sc;
        int[][] grid;
        try{
            sc=new Scanner(System.in);
            System.out.println("Enter number of rows and columns : ");
            int rows=sc.nextInt();
            int columns=sc.nextInt();
            grid=new int[rows][columns];
            for(int i=0;i<rows;i++){
                for(int j=0;j<columns;j++){
                    grid[i][j]=sc.nextInt();
                }
            }
            System.out.println(new RottingOranges().orangesRotting(grid));
        }
        catch(Exception e){
            System.out.println("Exception occurred : "+e.getMessage());
            e.printStackTrace();
        }
    }
}
