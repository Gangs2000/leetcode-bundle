package LeetcodeDailyStreaks;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class InsertIntervals {        
    List<List<Integer>> resultList=new LinkedList<>();
    public int[][] insert(int[][] intervals, int[] newInterval) {        
        for(int index=0;index<intervals.length;index++){
            if(intervals[index][1]<newInterval[0])
                resultList.add(List.of(intervals[index][0], intervals[index][1]));                
            else if(intervals[index][0]>newInterval[1])                
                return method(newInterval, intervals, index);
            else{
                newInterval[0]=Math.min(intervals[index][0], newInterval[0]);
                newInterval[1]=Math.max(intervals[index][1], newInterval[1]);
            }            
        }            
        return method(newInterval, intervals, intervals.length);
    }
    public int[][] method(int newInterval[],int intervals[][],int index){                 
        resultList.add(List.of(newInterval[0], newInterval[1]));        
        for(int i=index;i<intervals.length;i++)                           
            resultList.add(List.of(intervals[i][0], intervals[i][1]));
        int result[][]=new int[resultList.size()][2];
        for(int i=0;i<result.length;i++){
            result[i][0]=resultList.get(i).get(0);
            result[i][1]=resultList.get(i).get(1);
        }            
        return result;
    }
    public static void main(String[] args){
        Scanner sc;
        int[][] intervals;
        int[] newInterval;
        try{
            sc=new Scanner(System.in);
            System.out.println("Enter length of intervals array : ");
            int length=sc.nextInt();
            intervals=new int[length][2];
            for(int i=0;i<length;i++){
                intervals[i][0]=sc.nextInt();
                intervals[i][1]=sc.nextInt();
            }
            newInterval=new int[2];
            System.out.println("Enter new Interval value : ");
            newInterval[0]=sc.nextInt();
            newInterval[1]=sc.nextInt();
            System.out.println(new InsertIntervals().insert(intervals, newInterval));
        }
        catch(Exception e){
            System.out.println("Exception occurred : "+e.getMessage());
            e.printStackTrace();
        }
    }
}
