import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class MaximumNumberofFishinaGrid {
    int findMaxFish=0, fishCount=0;
    List<List<Integer>> queue;
    public int findMaxFish(int[][] grid) {
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[i].length;j++){
                if(grid[i][j]!=0)
                    findMaxFish=Math.max(findMaxFish, breathFirstSearch(i, j, grid));
            }
        }
        return findMaxFish;
    }
    public int breathFirstSearch(int x, int y, int[][] grid){
        fishCount=0;
        queue=new LinkedList<>();
        queue.add(List.of(x,y));
        fishCount+=grid[x][y];
        grid[x][y]=0;        
        while(!queue.isEmpty()){
            int i=queue.get(0).get(0);
            int j=queue.get(0).get(1);            
            if(checkGridBoundaries(i, j-1, grid)){                
                fishCount+=grid[i][j-1];
                grid[i][j-1]=0;
            }
            if(checkGridBoundaries(i, j+1, grid)){
                fishCount+=grid[i][j+1];
                grid[i][j+1]=0;
            }
            if(checkGridBoundaries(i-1, j, grid)){
                fishCount+=grid[i-1][j];
                grid[i-1][j]=0;
            }
            if(checkGridBoundaries(i+1, j, grid)){
                fishCount+=grid[i+1][j];
                grid[i+1][j]=0;
            }
            queue.remove(0);
        }
        return fishCount;        
    }
    public boolean checkGridBoundaries(int i, int j, int[][] grid){
        if(i>=0 && j>=0 && i<=grid.length-1 && j<=grid[i].length-1 && grid[i][j]!=0){
            queue.add(List.of(i, j));
            return true;
        }
        return false;
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
            System.out.println(new MaximumNumberofFishinaGrid().findMaxFish(grid));
        }
        catch(Exception e){
            System.out.println("Exception occurred : "+e.getMessage());
            e.printStackTrace();
        }
    }
}
