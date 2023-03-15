import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class NumberOfClosedIslands {
    boolean isInvalid=false;
    int numberOfClosedLands=0;
    List<List<Integer>> queue;
    public NumberOfClosedIslands(){
        queue=new LinkedList<>();
    }
    public int closedIsland(int[][] grid) {
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[i].length;j++){
                if(i!=0 && j!=0 && i!=grid.length-1 && j!=grid[i].length-1 && grid[i][j]==0){
                    //Marking this coordinate as visited..
                    grid[i][j]=2;
                    queue.add(List.of(i,j));
                    directions(queue, grid);
                    if(!isInvalid)
                        numberOfClosedLands++;
                    isInvalid=false; queue.clear();
                }
            }
        }
        return numberOfClosedLands;
    }
    public void directions(List<List<Integer>> queue, int[][] grid){
        while(!queue.isEmpty()){
            int row=queue.get(0).get(0);
            int column=queue.get(0).get(1);
            breathFirstSearch(grid, row, column-1);   //Left
            breathFirstSearch(grid, row, column+1);   //Right
            breathFirstSearch(grid, row-1, column);   //Top
            breathFirstSearch(grid, row+1, column);   //Bottom
            queue.remove(0);            
        }
    }
    public void breathFirstSearch(int[][] grid, int i, int j){
        if(i>=0 && j>=0 && i<=grid.length-1 && j<=grid[i].length-1 && grid[i][j]==0){
            if(i!=0 && j!=0 && i!=grid.length-1 && j!=grid[i].length-1){
                //Marking this coordinate as visited..
                grid[i][j]=2;
                queue.add(List.of(i,j));                
            }
            else
                isInvalid=true;
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
            System.out.println(new NumberOfClosedIslands().closedIsland(grid));
        }
        catch(Exception e){
            System.out.println("Exception occurred : "+e.getMessage());
            e.printStackTrace();
        }
    }
}
