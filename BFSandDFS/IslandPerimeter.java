import java.util.Scanner;

public class IslandPerimeter {
    int totalPerimeter=0;
    public int islandPerimeter(int[][] grid) {
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[i].length;j++){
                if(grid[i][j]==1){
                    directions(i, j-1, grid);         //Left
                    directions(i, j+1, grid);         //Right
                    directions(i-1, j, grid);         //Top
                    directions(i+1, j, grid);         //Bottom
                }
            }
        }
        return totalPerimeter;
    }
    public void directions(int i, int j, int[][] grid){
        if(i>=0 && j>=0 && i<=grid.length-1 && j<=grid[i].length-1){
            if(grid[i][j]==0)
                totalPerimeter++;
        }
        else
            totalPerimeter++;
    }
    public static void main(String[] args){
        Scanner sc;
        int[][] grid;
        try{
            sc=new Scanner(System.in);
            System.out.println("Enter M and N value : ");
            int m=sc.nextInt(); int n=sc.nextInt();
            grid=new int[m][n];
            for(int i=0;i<m;i++){
                for(int j=0;j<n;j++){
                    grid[i][j]=sc.nextInt();
                }
            }
            System.out.println(new IslandPerimeter().islandPerimeter(grid));
        }
        catch(Exception e){
            System.out.println("Exception occurred : "+e.getMessage());
            e.printStackTrace();
        }
    }
}
