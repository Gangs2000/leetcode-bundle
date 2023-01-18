import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class ShortestPathInBinaryMatrix {
    Map<List<Integer>, Integer> queue;
    int currentValue=0;
    public ShortestPathInBinaryMatrix(){
        queue=new LinkedHashMap<>();
    }
    public int shortestPathBinaryMatrix(int[][] grid) {
        if(grid[0][0]==1)
            return -1;
        queue.put(List.of(0,0), 1);
        while(!queue.isEmpty()){
            List<Integer> list=queue.keySet().stream().findFirst().get();
            grid[list.get(0)][list.get(1)]=1;
            currentValue=queue.get(list);
            if(list.get(0)==grid.length-1 && list.get(1)==grid.length-1)
                return currentValue;            
            directions(list.get(0), list.get(1)-1, grid);           //Left
            directions(list.get(0), list.get(1)+1, grid);           //Right
            directions(list.get(0)-1, list.get(1), grid);           //Top
            directions(list.get(0)+1, list.get(1), grid);           //Bottom
            directions(list.get(0)-1, list.get(1)+1, grid);         //Top-right
            directions(list.get(0)-1, list.get(1)-1, grid);         //Top-left
            directions(list.get(0)+1, list.get(1)+1, grid);         //Bottom-right
            directions(list.get(0)+1, list.get(1)-1, grid);         //Bottom-left
            queue.remove(list);            
        }
        return -1;
    }
    public void directions(int i, int j, int[][] grid){
        if(i>=0 && j>=0 && i<=grid.length-1 && j<=grid.length-1){
            if(grid[i][j]==0){
                grid[i][j]=1;
                queue.put(List.of(i,j), currentValue+1);
            }
        }
    }
    public static void main(String[] args){
        Scanner sc;
        try{
            sc=new Scanner(System.in);
            int[][] grid;
            System.out.println("Enter grid N value : ");
            int n=sc.nextInt();
            grid=new int[n][n];
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    grid[i][j]=sc.nextInt();
                }
            }
        }
        catch(Exception e){
            System.out.println("Exception occurred : "+e.getMessage());
            e.printStackTrace();
        }
    }
}
