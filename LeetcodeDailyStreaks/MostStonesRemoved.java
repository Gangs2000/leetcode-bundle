package LeetcodeDailyStreaks;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class MostStonesRemoved {
    int removeCount;
    List<Integer> rowList, colList;
    public MostStonesRemoved(){
        removeCount=0;
        rowList=new LinkedList<>();
        colList=new LinkedList<>();
    }
    public int removeStones(int[][] stones) {
        for(int i=0;i<stones.length;i++){            
            if(!rowList.contains(stones[i][0]) && !colList.contains(stones[i][1])){                
                rowList.add(stones[i][0]);
                colList.add(stones[i][1]);
                removeCount++;
            }
            else{                
                if(!rowList.contains(stones[i][0]))
                    rowList.add(stones[i][0]);
                if(!colList.contains(stones[i][1]))                    
                    colList.add(stones[i][1]);
            }
        }
        return stones.length-removeCount;
    }
    public static void main(String[] args){
        Scanner sc;
        int[][] grid;
        try{
            sc=new Scanner(System.in);
            System.out.println("Enter number of rows of a grid : ");
            int rows=sc.nextInt();
            grid=new int[rows][2];
            for(int i=0;i<rows;i++)
                for(int j=0;j<2;j++)
                    grid[i][j]=sc.nextInt();
            System.out.println(new MostStonesRemoved().removeStones(grid));
        }
        catch(Exception e){
            System.out.println("Exception occured : "+e.getMessage());
            e.printStackTrace();
        }
    }
}
