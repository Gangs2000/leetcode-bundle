import java.util.Scanner;

public class NumberOfEnclaves {
    int count=0,totalMoves=0;
    boolean cannotWalkOff=true;
    public int numEnclaves(int[][] grid) {
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[i].length;j++){
                if(grid[i][j]==1){
                    grid[i][j]=2;     
                    count++;
                    if(i==0 || j==0 || i==grid.length-1 || j==grid[i].length-1)                                                                
                        cannotWalkOff=false;
                    directions(i, j, grid);                    
                    totalMoves=(cannotWalkOff)?(totalMoves+count):(count);
                    count=0; cannotWalkOff=true;            //Reset count and cannot walk off indicator values
                }
            }
        }
        return totalMoves;
    }
    public void directions(int i, int j, int[][] grid){
        checkBoundariesAndMarkVisited(i, j-1, grid);          //Left
        checkBoundariesAndMarkVisited(i, j+1, grid);          //Right
        checkBoundariesAndMarkVisited(i-1, j, grid);          //Top
        checkBoundariesAndMarkVisited(i+1, j, grid);          //Bottom
    }
    public void checkBoundariesAndMarkVisited(int i, int j, int[][] grid){
        if((i>=0 && j>=0 && i<=grid.length-1 && j<=grid[i].length-1) && grid[i][j]==1){            
            count++;
            grid[i][j]=2;
            if(i==0 || j==0 || i==grid.length-1 || j==grid[i].length-1)                                                                
                cannotWalkOff=false;
            directions(i, j, grid);                     //Recursion call
        }
    }
    public static void main(String[] args){
        Scanner sc;
        int[][] grid;
        try{
            sc=new Scanner(System.in);
            System.out.println("Enter M and N value : ");
            int m=sc.nextInt();
            int n=sc.nextInt();
            grid=new int[m][n];
            for(int i=0;i<m;i++){
                for(int j=0;j<n;j++){
                    grid[i][j]=sc.nextInt();
                }
            }
            System.out.println(new NumberOfEnclaves().numEnclaves(grid));
        }
        catch(Exception e){
            System.out.println("Exception occurred : "+e.getMessage());
            e.printStackTrace();
        }
    }
}
