import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class LuckyNumbersinaMatrix {
    List<Integer> resultList;
    public LuckyNumbersinaMatrix(){
        resultList=new LinkedList<>();
    }
    public List<Integer> luckyNumbers (int[][] matrix) {
        for(int i=0;i<matrix.length;i++){
            int minElementInRow=Integer.MAX_VALUE, column=-1;
            for(int j=0;j<matrix[i].length;j++){
                if(matrix[i][j]<minElementInRow){
                    column=j;
                    minElementInRow=matrix[i][j];
                }
            }
            if(this.returnMaxElementInColumn(column, matrix)==minElementInRow)
                resultList.add(minElementInRow);
        }
        return resultList;
    }
    private int returnMaxElementInColumn(int column, int[][] matrix){
        int maxElementInColumn=Integer.MIN_VALUE;
        for(int i=0;i<matrix.length;i++)
            maxElementInColumn=Math.max(maxElementInColumn, matrix[i][column]);
        return maxElementInColumn;
    }
    public static void main(String[] args) {
        Scanner sc;
        int[][] grid;
        try {
            sc=new Scanner(System.in);
            System.out.println("Enter rows and columns values : ");
            int rows=sc.nextInt();
            int columns=sc.nextInt();
            grid=new int[rows][columns];
            for(int i=0;i<rows;i++){
                for(int j=0;j<columns;j++){
                    grid[i][j]=sc.nextInt();
                }
            }
            System.out.println(new LuckyNumbersinaMatrix().luckyNumbers(grid));
            sc.close();
        } 
        catch (Exception e) {
            System.out.println("Exception occurred : "+e.getMessage());
            e.printStackTrace();
        }
    }
}
