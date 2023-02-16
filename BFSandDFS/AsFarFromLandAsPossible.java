import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class AsFarFromLandAsPossible {
    int maxDistanceCount=0;
    Set<List<Integer>> set;
    public AsFarFromLandAsPossible(){
        set=new HashSet<>();
    }
    public int maxDistance(int[][] grid) {        
        while(true){
            this.scanLandsFromGrid(grid);
            if(set.size()==grid.length*grid.length)
                return -1;
            if(set.size()==0)
                break;                               
            for(List<Integer> list : set){
                int row=list.get(0);
                int column=list.get(1);
                makeNighbourCellsAsLand(row ,column-1, grid);     //Left
                makeNighbourCellsAsLand(row ,column+1, grid);     //Right
                makeNighbourCellsAsLand(row-1 ,column, grid);     //Top
                makeNighbourCellsAsLand(row+1 ,column, grid);     //Bottom
            }
            maxDistanceCount++;    
            set.clear();
        }
        return (maxDistanceCount==0)?(-1):(maxDistanceCount-1);
    }
    public void makeNighbourCellsAsLand(int i, int j, int[][] grid){
        if(i>=0 && j>=0 && i<=grid.length-1 && j<=grid.length-1){
            if(grid[i][j]==0)
                grid[i][j]=1;
        }
    }
    public void scanLandsFromGrid(int[][] grid){
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid.length;j++){
                if(grid[i][j]==1){
                    grid[i][j]=2;
                    set.add(List.of(i,j));
                }
            }
        }
    }
    public static void main(String[] args){
        Scanner sc;
        int[][] grid;
        try{
            sc=new Scanner(System.in);
            System.out.println("Enter N value : ");
            int n=sc.nextInt();
            grid=new int[n][n];
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    grid[i][j]=sc.nextInt();
                }
            }
            System.out.println(new AsFarFromLandAsPossible().maxDistance(grid));
        }
        catch(Exception e){
            System.out.println("Exception occurred : "+e.getMessage());
            e.printStackTrace();
        }
    }
}
