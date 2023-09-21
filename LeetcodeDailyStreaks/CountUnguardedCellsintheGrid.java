package LeetcodeDailyStreaks;

import java.util.Arrays;
import java.util.Scanner;

public class CountUnguardedCellsintheGrid {
    int index=0, result=0;
    char[][] grid;
    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        grid=new char[m][n];       
        Arrays.stream(grid).forEach(array->Arrays.fill(array, ' '));
        //Fill the walls in grid..
        while(index<walls.length){
            int x=walls[index][0];
            int y=walls[index][1];
            grid[x][y]='W';            
            index++;
        }        
        index=0;
        while(index<guards.length){
            int x=guards[index][0];
            int y=guards[index][1];            
            grid[x][y]='G';                        
            index++;
        }            
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[i].length;j++){
                if(grid[i][j]=='G'){                    
                    left(i, j-1, grid);
                    right(i, j+1, grid);
                    top(i-1, j, grid);
                    bottom(i+1, j, grid);
                }
            }
        }         
        for(char[] array : grid){
            for(char j : array){
                if(j==' ')
                    result++;
            }
        }
        return result;
    }
    public void left(int i, int j, char[][] grid){
        while(j!=-1){
            if(grid[i][j]=='W' || grid[i][j]=='G')
                break;
            grid[i][j]='P';                    
            j--;
        }        
    }
    public void right(int i, int j, char[][] grid){
        while(j!=grid[i].length){
            if(grid[i][j]=='W' || grid[i][j]=='G')
                break;
            grid[i][j]='P';                   
            j++;
        }        
    }
    public void top(int i, int j, char[][] grid){
        while(i!=-1){    
            if(grid[i][j]=='W' || grid[i][j]=='G')
                break;        
            grid[i][j]='P';                      
            i--;
        }        
    }
    public void bottom(int i, int j, char[][] grid){
        while(i!=grid.length){            
            if(grid[i][j]=='W' || grid[i][j]=='G')
                break;
            grid[i][j]='P';              
            i++;
        }        
    }
    public static void main(String[] args){
        Scanner sc;        
        int[][] guards, walls;
        try{
            sc=new Scanner(System.in);
            System.out.println("Enter M and N values : ");
            int m=sc.nextInt();
            int n=sc.nextInt();
            System.out.println("Enter length of Guards array : ");            
            int guardLength=sc.nextInt();
            guards=new int[guardLength][2];
            for(int i=0;i<guardLength;i++){
                guards[i][0]=sc.nextInt();
                guards[i][1]=sc.nextInt();
            }
            System.out.println("Enter length of Walls array : ");            
            int wallLength=sc.nextInt();
            walls=new int[wallLength][2];
            for(int i=0;i<wallLength;i++){
                walls[i][0]=sc.nextInt();
                walls[i][1]=sc.nextInt();
            }
            System.out.println(new CountUnguardedCellsintheGrid().countUnguarded(m, n, guards, walls));
        }
        catch(Exception e){
            System.out.println("Exception occurred : "+e.getMessage());
            e.printStackTrace();
        }
    }
}
