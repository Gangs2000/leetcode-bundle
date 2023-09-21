import java.util.Scanner;

public class WhereBallWillFall {    
    int[] result;  
    int index=0;  
    public int[] findBall(int[][] grid) {
        result=new int[grid[0].length];
        for(int i=0;i<grid[0].length;i++){
            int row=0, column=i;
            while(row!=grid.length){                
                if((column==0 && grid[row][column]==-1) || (column==grid[0].length-1 && grid[row][column]==1)){                    
                    result[index]=-1;
                    index++;
                    break;
                }
                else{
                    if(grid[row][column]==1 && grid[row][column+1]==1){
                        row++; column++;                        
                    }
                    else if(grid[row][column]==-1 && grid[row][column-1]==-1){
                        row++; column--;
                    }
                    else{
                        result[index]=-1;
                        index++;
                        break;
                    }
                }                
            }    
            if(row==grid.length){
                result[index]=column;
                index++;
            }        
        }
        return result;
    }
    public static void main(String[] args){
        Scanner sc;
        int[][] grid;
        try{
            sc=new Scanner(System.in);            
            System.out.println("Enter row and column value : ");
            int rows=sc.nextInt();            
            int columns=sc.nextInt();
            grid=new int[rows][columns];
            for(int i=0;i<rows;i++){
                for(int j=0;j<columns;j++){
                    grid[i][j]=sc.nextInt();
                }
            }
            System.out.println(new WhereBallWillFall().findBall(grid));
        }
        catch(Exception e){
            System.out.println("Exception occured : "+e.getMessage());
            e.printStackTrace();
        }        
    }
}
