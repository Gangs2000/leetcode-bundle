package LeetcodeDailyStreaks;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class EqualRowsAndColumnsPairs {
    int totalPairs=0;
    Map<List<Integer>, Integer> map;
    public EqualRowsAndColumnsPairs(){
        map=new LinkedHashMap<>();
    }
    public int equalPairs(int[][] grid) {
        countRowOccurance(grid, grid.length, 0);
        countColumnOccurance(grid, grid.length, 0);
        return totalPairs;
    }
    public void countRowOccurance(int[][] grid, int length, int row){
        if(row!=length){
            List<Integer> list=new LinkedList<>();
            for(int i=0;i<length;i++)
                list.add(grid[row][i]);
            if(map.containsKey(list))
                map.put(list, map.get(list)+1);
            else
                map.put(list, 1);
            countRowOccurance(grid, length, row+1);
        }
    }
    public void countColumnOccurance(int[][] grid, int length, int column){
        if(column!=length){
            List<Integer> list=new LinkedList<>();
            for(int i=0;i<length;i++)
                list.add(grid[i][column]);
            if(map.containsKey(list))
                totalPairs+=(1)*(map.get(list));
            countColumnOccurance(grid, length, column+1);
        }
    }
    public static void main(String[] args){
        int[][] grid;
        try{
            grid=new int[][]{
                {3,1,2,2},
                {1,4,4,5},
                {2,4,2,2},
                {2,4,2,2}
            };
            System.out.println(new EqualRowsAndColumnsPairs().equalPairs(grid));
        }
        catch(Exception e){
            System.out.println("Exception occured : "+e.getMessage());
            e.printStackTrace();
        }
    }
}
