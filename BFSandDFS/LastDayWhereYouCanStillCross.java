import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class LastDayWhereYouCanStillCross {
    int lastDayStillCross=0;
    int[][] grid;
    List<List<Integer>> queue;
    public int latestDayToCross(int row, int col, int[][] cells) {
        grid=new int[row][col];        
        int leftPointer=0, rightPointer=cells.length-1;        
        while(leftPointer<=rightPointer){            
            int middle=leftPointer+((rightPointer-leftPointer)/2);
            Arrays.stream(grid).forEach(array->Arrays.fill(array, 0));
            if(canCrossTheDay(middle, cells, grid)){
                lastDayStillCross=middle+1;
                leftPointer=middle+1;
            }
            else
                rightPointer=middle-1;
        }
        return lastDayStillCross;
    }
    public boolean canCrossTheDay(int middle, int[][] cells, int[][] grid){
        for(int i=0;i<=middle;i++){
            int[] cell=cells[i];
            grid[cell[0]-1][cell[1]-1]=1;
        }      
        for(int i=0;i<grid[0].length;i++){            
            if(grid[0][i]==0){                
                queue=new LinkedList<>();
                grid[0][i]=1;
                queue.add(List.of(0, i));
                while(!queue.isEmpty()){                    
                    int x=queue.get(0).get(0);
                    int y=queue.get(0).get(1);                                   
                    //If Row reaches at the end of grid..
                    if(x==grid.length-1)
                        return true;
                    validDirection(x, y-1, grid);   //Left          
                    validDirection(x, y+1, grid);   //Right           
                    validDirection(x-1, y, grid);   //Top          
                    validDirection(x+1, y, grid);   //Bottom
                    queue.remove(0);
                }
            }
        }
        return false;
    }
    public void validDirection(int i, int j, int[][] grid){
        if(i>=0 && j>=0 && i<=grid.length-1 && j<=grid[i].length-1 && grid[i][j]==0){            
            grid[i][j]=1;
            queue.add(List.of(i, j));
        }
    }    
    public static void main(String[] args){
        Scanner sc;        
        int[][] cells;
        try{
            sc=new Scanner(System.in);
            System.out.println("Enter Rows and Columns count : ");
            int rows=sc.nextInt();
            int columns=sc.nextInt();            
            System.out.println("Enter the length cells array : ");            
            int length=sc.nextInt();            
            cells=new int[length][2];
            for(int i=0;i<length;i++){
                cells[i][0]=sc.nextInt();
                cells[i][1]=sc.nextInt();
            }             
            System.out.println(new LastDayWhereYouCanStillCross().latestDayToCross(rows, columns, cells));   
        }
        catch(Exception e){
            System.out.println("Exception occurred : "+e.getMessage());
            e.printStackTrace();
        }
    }
}

