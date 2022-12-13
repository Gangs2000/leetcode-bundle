public class MaxAreaOfIsland {
    int maxArea=0, countLands=0;
    public int maxAreaOfIsland(int[][] grid) {
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[i].length;j++){
                if(grid[i][j]==1){
                    countLands++;
                    grid[i][j]=2;
                    this.directions(i, j, grid);
                    maxArea=Math.max(maxArea, countLands);
                    countLands=0;
                }                
            }
        }
        return maxArea;
    }
    public void directions(int i, int j, int[][] grid){
        checkBoundaryAndMarkVisitedLands(i, j-1, grid);               //Left
        checkBoundaryAndMarkVisitedLands(i, j+1, grid);               //Right
        checkBoundaryAndMarkVisitedLands(i-1, j, grid);               //Top
        checkBoundaryAndMarkVisitedLands(i+1, j, grid);               //Bottom
    }
    public void checkBoundaryAndMarkVisitedLands(int i, int j, int[][] grid){
        if(i>=0 && i<=grid.length-1 && j>=0 && j<=grid[i].length-1){
            if(grid[i][j]==1){
                grid[i][j]=2;
                countLands++;
                directions(i, j, grid);
            }            
        }
    }
    public static void main(String[] args){
        int[][] grid;
        try{
            grid=new int[][]{
                {0,0,1,0,0,0,0,1,0,0,0,0,0},
                {0,0,0,0,0,0,0,1,1,1,0,0,0},
                {0,1,1,0,1,0,0,0,0,0,0,0,0},
                {0,1,0,0,1,1,0,0,1,0,1,0,0},
                {0,1,0,0,1,1,0,0,1,1,1,0,0},
                {0,0,0,0,0,0,0,0,0,0,1,0,0},
                {0,0,0,0,0,0,0,1,1,1,0,0,0},
                {0,0,0,0,0,0,0,1,1,0,0,0,0}
            };
            System.out.println(new MaxAreaOfIsland().maxAreaOfIsland(grid));
        }
        catch(Exception e){
            System.out.println("Exception occured : "+e.getMessage());
            e.printStackTrace();
        }
    }
}
