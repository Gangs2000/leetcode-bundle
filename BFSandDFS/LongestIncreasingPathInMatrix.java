import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class LongestIncreasingPathInMatrix {
    int longestIncreasingCount=0;
    List<List<Integer>> queue;
    public LongestIncreasingPathInMatrix(){
        queue=new LinkedList<>();
    }
    public int longestIncreasingPath(int[][] matrix) {
        for(int i=0;i<matrix.length;i++)
            for(int j=0;j<matrix[i].length;j++)
                this.breathFirstSearch(i, j, matrix);
        return longestIncreasingCount;
    }
    public void breathFirstSearch(int i, int j, int[][] matrix){        
        queue.add(List.of(i,j,1));
        while(!queue.isEmpty()){
            int row=queue.get(0).get(0);
            int column=queue.get(0).get(1);
            int currentDepth=queue.get(0).get(2);
            int prevElement=matrix[row][column];            
            longestIncreasingCount=Math.max(longestIncreasingCount, currentDepth);            
            this.directions(row, column-1, currentDepth, prevElement, matrix);        //Left
            this.directions(row, column+1, currentDepth, prevElement, matrix);        //Right
            this.directions(row-1, column, currentDepth, prevElement, matrix);        //Top
            this.directions(row+1, column, currentDepth, prevElement, matrix);        //Bottom            
            queue.remove(0);
        }
    }
    public void directions(int i, int j, int currentDepth, int prevElement, int[][] matrix){        
        if(i>=0 && j>=0 && i<=matrix.length-1 && j<=matrix[i].length-1){            
            if(matrix[i][j]>prevElement)
                queue.add(List.of(i,j,currentDepth+1));
        }
    }
    public static void main(String[] args){
        Scanner sc;
        int[][] grid;
        try{
            sc=new Scanner(System.in);
            System.out.println("Enter M and N Values : ");
            int m=sc.nextInt(); int n=sc.nextInt();
            grid=new int[m][n];
            for(int i=0;i<m;i++){
                for(int j=0;j<n;j++){
                    grid[i][j]=sc.nextInt();                    
                }
            }
            System.out.println(new LongestIncreasingPathInMatrix().longestIncreasingPath(grid));
        }   
        catch(Exception e){
            System.out.println("Exception occurred : "+e.getMessage());
            e.printStackTrace();
        }
    }
}
