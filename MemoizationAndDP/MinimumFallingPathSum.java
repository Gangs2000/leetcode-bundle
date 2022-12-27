package MemoizationAndDP;

public class MinimumFallingPathSum {
    int output;
    int[][] cache;
    public MinimumFallingPathSum(){
        output=Integer.MAX_VALUE;
        cache=new int[101][101];
    }
    public int minFallingPathSum(int[][] matrix) {
        int row=0;
        for(int column=0;column<matrix.length;column++)
            output=Math.min(output, this.possibleFallingPath(matrix, row, column));
        return output;        
    }
    public int possibleFallingPath(int[][] matrix, int row, int column){                
        if(row==matrix.length-1)
            return matrix[row][column];
        if(cache[row][column]!=0)
            return cache[row][column];
        int sum=matrix[row][column];
        int minimumSum=Integer.MAX_VALUE;
        if(row+1<matrix.length && column-1>=0)            
            minimumSum=Math.min(minimumSum, sum+this.possibleFallingPath(matrix, row+1, column-1));
        if(row+1<matrix.length)            
            minimumSum=Math.min(minimumSum, sum+this.possibleFallingPath(matrix, row+1, column));            
        if(row+1<matrix.length && column+1<matrix.length)            
            minimumSum=Math.min(minimumSum, sum+this.possibleFallingPath(matrix, row+1, column+1));        
        return cache[row][column]=minimumSum;
    }
    public static void main(String[] args){
        int[][] grid;
        try{
            grid=new int[][]{
                {2,1,3},
                {6,5,4},
                {7,8,9}
            };
            System.out.println(new MinimumFallingPathSum().minFallingPathSum(grid));
        }
        catch(Exception e){
            System.out.println("Exception occured : "+e.getMessage());
            e.printStackTrace();
        }
    }
}
