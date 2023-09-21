import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class BinaryMatrix {
    int[][] distance;    
    List<List<Integer>> queue;
    public BinaryMatrix(){        
        queue=new LinkedList<>();
    }
    public int[][] updateMatrix(int[][] mat) {
        distance=new int[mat.length][mat[0].length];
        Arrays.stream(distance).forEach(array->Arrays.fill(array, -1));
        for(int i=0;i<mat.length;i++){
            for(int j=0;j<mat[0].length;j++){
                if(mat[i][j]==0){
                    distance[i][j]=0;
                    queue.add(List.of(i,j));
                }
            }
        }
        while(!queue.isEmpty()){
            List<Integer> list=queue.get(0);
            int row=list.get(0);
            int column=list.get(1);
            directions(row, column-1, distance, row, column);      //Left
            directions(row, column+1, distance, row, column);      //Right
            directions(row-1, column, distance, row, column);      //Top
            directions(row+1, column, distance, row, column);      //Bottom
            queue.remove(0);
        }
        return distance;
    }    
    public void directions(int row, int column, int[][] distance, int i, int j){
        if(row>=0 && column>=0 && row<=distance.length-1 && column<=distance[row].length-1 && distance[row][column]==-1){
            distance[row][column]=distance[i][j]+1;
            queue.add(List.of(row, column));
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
            System.out.println(new BinaryMatrix().updateMatrix(grid));
        }
        catch(Exception e){
            System.out.println("Exception occurred : "+e.getMessage());
            e.printStackTrace();
        }
    }
}
