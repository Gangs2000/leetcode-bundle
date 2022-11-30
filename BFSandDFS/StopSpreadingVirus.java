import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class StopSpreadingVirus {
    int wallsRequiredToQuarantine=0,countWalls=0;    
    Map<Integer, List<List<Integer>>> currentAffectedGridIndicies;
    List<List<Integer>> listAffectedCells,duplicateListAffectedCells;
    public StopSpreadingVirus(){
        this.currentAffectedGridIndicies=new HashMap<>();        
        this.listAffectedCells=new LinkedList<>();
        this.duplicateListAffectedCells=new LinkedList<>();        
    }
    private int wallsNeedToBeBuilt(int[][] grid){
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[i].length;j++){       
                if(grid[i][j]==1){    
                    listAffectedCells.add(List.of(i,j));   
                    grid[i][j]=-1;                                                                                  //Marking current index as -1 ( Visited )                    
                    this.callDirectionsToCheckBounds(i, j, grid);                                                   //Calling direction method                                                                                                       
                    duplicateListAffectedCells=listAffectedCells.stream().collect(Collectors.toList());             //Copying original values to duplicate list to avoid data collision                    
                    currentAffectedGridIndicies.put(countWalls, duplicateListAffectedCells);                                                  
                    listAffectedCells.clear(); countWalls=0;                                                                             
                }                                   
            }                             
        }  
        if(currentAffectedGridIndicies.size()!=0){
            this.putWallsAroundMostAffectedRegion(currentAffectedGridIndicies, grid);           //Calling method to find max affected region and build walls 
            this.spreadVirus(grid);                                                             //Calling method to spread virus to adjacent cells                                   
            wallsNeedToBeBuilt(grid);                                                           //Calling iteration method for next iteration.. Iteration occurs till all map size becomes 0  
        }              
        return wallsRequiredToQuarantine;
    }  
    private void callDirectionsToCheckBounds(int i, int j, int[][] grid){
        this.checkBoundAndListOutAllAffectedAndFutureAffectedCells(i, j-1, grid);       //Bottom
        this.checkBoundAndListOutAllAffectedAndFutureAffectedCells(i, j+1, grid);       //Top
        this.checkBoundAndListOutAllAffectedAndFutureAffectedCells(i+1, j, grid);       //Right
        this.checkBoundAndListOutAllAffectedAndFutureAffectedCells(i-1, j, grid);       //Left
    }
    private void checkBoundAndListOutAllAffectedAndFutureAffectedCells(int i, int j, int[][] grid){
        if(i>=0 && i<=grid.length-1 && j>=0 && j<=grid[i].length-1){                                                      //Setting bound limit ( Lower and Upper bound )
            if(grid[i][j]==1){
                listAffectedCells.add(List.of(i,j));
                grid[i][j]=-1;   
                this.callDirectionsToCheckBounds(i, j, grid);                                                             //Recursive call function since current grid value is 1             
            }
            else if(grid[i][j]==0)
                countWalls++;                         
        }
    }
    private void putWallsAroundMostAffectedRegion(Map<Integer, List<List<Integer>>> currentVirusAffectedMap, int[][] grid){                   
        int getMaxKey=currentVirusAffectedMap.keySet().stream().max(Integer::compareTo).get();         //Fetching maximum key value from keyset and adding it to wallsRequiredToQuarantine variable        
        wallsRequiredToQuarantine+=getMaxKey;
        List<List<Integer>> listOfGridIndicies=currentVirusAffectedMap.get(getMaxKey);
        for(int i=0;i<listOfGridIndicies.size();i++)
            grid[listOfGridIndicies.get(i).get(0)][listOfGridIndicies.get(i).get(1)]=2;                 //After building walls aroung virus area, resetting infected region to disinfected region                
        currentAffectedGridIndicies.clear();                  
    }    
    private void spreadVirus(int[][] grid){                                                       
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[i].length;j++){
                if(grid[i][j]==-1){
                    grid[i][j]=1;                        
                    callDirectionsToSpreadVirus(i+1, j, grid);
                    callDirectionsToSpreadVirus(i-1, j, grid);
                    callDirectionsToSpreadVirus(i, j+1, grid);
                    callDirectionsToSpreadVirus(i, j-1, grid);
                }
            }
        }                                                            
    }
    private void callDirectionsToSpreadVirus(int i, int j, int[][] grid){
        if(i>=0 && i<=grid.length-1 && j>=0 && j<=grid[i].length-1)
            if(grid[i][j]==0)
                grid[i][j]=1;
    }
    public static void main(String[] srgs){
        Scanner sc;
        int[][] grid;
        try{
            System.out.println("Enter number of rows and columns to form grid : ");
            sc=new Scanner(System.in);
            int row=sc.nextInt();
            int column=sc.nextInt();
            grid=new int[row][column];
            for(int i=0;i<row;i++)
                for(int j=0;j<column;j++)
                    grid[i][j]=sc.nextInt();
            System.out.println("Number of walls need to build "+new StopSpreadingVirus().wallsNeedToBeBuilt(grid));
        }
        catch(Exception e){
            System.out.println("Exception occured : "+e.getMessage());
            e.printStackTrace();
        }
    }
}
