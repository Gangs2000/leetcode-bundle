import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import FunctionalInterface.BiFunction;

public class MinimumIntervalToIncludeQuery {    
    public int[] minInterval(int[][] grid, int[] queries){
        int[] outputArray=new int[queries.length];
        for(int queryElement=0;queryElement<queries.length;queryElement++)
            outputArray[queryElement]=this.getMinimumIntervalValue(grid, queries[queryElement]);
        return outputArray;
    }
    public int getMinimumIntervalValue(int[][] grid, int element){
        int minElement=Integer.MAX_VALUE;
        for(int i=0;i<grid.length;i++){
            if(grid[i][0]<=element && grid[i][1]>=element){
                int operation=(grid[i][1]-grid[i][0])+1;
                if(operation<minElement)
                    minElement=operation;
            }
        }
        return (minElement==Integer.MAX_VALUE)?(-1):(minElement);
    }
    public static void main(String[] args){
        Scanner sc;
        List<Integer> resultList;
        int[] resultArray;
        try{
            sc=new Scanner(System.in);
            resultList=new LinkedList<>();            
            System.out.println("Enter number of rows : ");
            int rows=sc.nextInt();            
            int[][] grid=new int[rows][2];
            for(int i=0;i<rows;i++){
                for(int j=0;j<grid[i].length;j++)
                    grid[i][j]=sc.nextInt();
            }
            System.out.println("Enter queries list length : ");
            int lengthOfQueryList=sc.nextInt();
            resultArray=new int[lengthOfQueryList];
            int[] queries=new int[lengthOfQueryList];
            for(int i=0;i<lengthOfQueryList;i++)
                queries[i]=sc.nextInt();        
            BiFunction<int[][], int[], int[]> functionObject=new MinimumIntervalToIncludeQuery()::minInterval;     
            resultArray=functionObject.apply(grid, queries);
            for(int i=0;i<resultArray.length;i++)
                resultList.add(resultArray[i]);
            System.out.println(resultList);
        }
        catch(Exception e){
            System.out.println("Exception occured : "+e.getMessage());
            e.printStackTrace();
        }
    }
}
