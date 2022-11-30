import java.util.Scanner;

public class BuildWalls {
    static int wallCount=0;
    private static int containVirus(int[][] grid){
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[i].length;j++){
                if(grid[i][j]==1){
                    direction(i, j+1, grid);                  //Right direction
                    direction(i, j-1, grid);                  //Left direction
                    direction(i+1, j, grid);                  //Top direction
                    direction(i-1, j, grid);                  //Bottom direction
                }                 
            }
        }
        return wallCount;
    }
    private static void direction(int i, int j, int[][] grid){
        if(i>=0 && i<=grid.length-1 && j>=0 && j<=grid[0].length-1){
            if(grid[i][j]!=1)
                wallCount++;
        }
    }
    public static void main(String[] args){
        Scanner sc;
        int world[][];
        try{
            sc=new Scanner(System.in);
            System.out.println("Enter number of rows and columns : ");
            int rows=sc.nextInt();
            int columns=sc.nextInt();
            world=new int[rows][columns];
            for(int i=0;i<rows;i++){
                for(int j=0;j<columns;j++)
                    world[i][j]=sc.nextInt();
            }
            System.out.println("Number of walls used to quratine the virus "+BuildWalls.containVirus(world));
        }
        catch(Exception e){
            System.out.println("Exception occured : "+e.getMessage());
            e.printStackTrace();
        }
    }
}
