package MemoiDPAndBackTracking;

import java.util.Scanner;

public class PathSumInMatrixSumDivByK {
    int count=0;
    public int numberOfPaths(int[][] grid, int k) {
        findAllPosibilites(0, 0, 0, k, grid);
        return count;
    }
    public void findAllPosibilites(int i, int j, int sum, int k, int[][] grid){               
        if(i>=grid.length || j>=grid[i].length)
            return ;    
        sum+=grid[i][j];    
        if(i==grid.length-1 && j==grid[i].length-1){                
            if(sum%k==0)                
                count++;
            return ;
        }                
        findAllPosibilites(i, j+1, sum, k, grid);     //Right                         
        findAllPosibilites(i+1, j, sum, k, grid);     //Bottom                                
    }
    public static void main(String[] args){
        Scanner sc;
        try{
            sc=new Scanner(System.in);
            System.out.println("Enter M and N values : ");
            int m=sc.nextInt(); int n=sc.nextInt();
            int[][] grid=new int[m][n];
            for(int i=0;i<m;i++){
                for(int j=0;j<n;j++){
                    grid[i][j]=sc.nextInt();
                }
            }
            System.out.println("Enter K value : ");
            int k=sc.nextInt();
            System.out.println(new PathSumInMatrixSumDivByK().numberOfPaths(grid, k));
        }
        catch(Exception e){
            System.out.println("Exception occurred : "+e.getMessage());
            e.printStackTrace();
        }
    }
}
