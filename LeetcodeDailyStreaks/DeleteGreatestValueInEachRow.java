package LeetcodeDailyStreaks;

import java.util.Scanner;

public class DeleteGreatestValueInEachRow {
    int grateatValueSum=0, maxElementInColumn=0;
    public int deleteGreatestValue(int[][] grid) {
        int columnCount=grid[0].length-1;
        while(columnCount!=-1){
            for(int i=0;i<grid.length;i++){
                int maxElementInRow=0,rowIndex=0,columnIndex=0;
                for(int j=0;j<grid[i].length;j++){
                    if(grid[i][j]!=0 && grid[i][j]>maxElementInRow){        
                        maxElementInRow=grid[i][j];
                        rowIndex=i; columnIndex=j;                
                    }                                                      
                }    
                grid[rowIndex][columnIndex]=0;                      
                maxElementInColumn=Math.max(maxElementInColumn, maxElementInRow);                                
            }            
            grateatValueSum+=maxElementInColumn; maxElementInColumn=0;
            columnCount--;            
        }
        return grateatValueSum;
    }
    public static void main(String[] args){
        Scanner sc;
        int[][] grid;
        try{
            sc=new Scanner(System.in);
            System.out.println("Enter number of rows and columns : ");
            int row=sc.nextInt(); int column=sc.nextInt();
            grid=new int[row][column];
            for(int i=0;i<row;i++)
                for(int j=0;j<column;j++)
                    grid[i][j]=sc.nextInt();
            System.out.println(new DeleteGreatestValueInEachRow().deleteGreatestValue(grid));
        }
        catch(Exception e){
            System.out.println("Exception occured : "+e.getMessage());
            e.printStackTrace();                        
        }
    }
}
