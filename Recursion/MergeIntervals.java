import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class MergeIntervals {
    List<List<Integer>> resultList=new LinkedList<>();
    int[][] result;
    public int[][] merge(int[][] intervals) {
        if(intervals.length==1)
            return intervals;
        //Sorting array elements by ascending order..
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o1[0], o2[0]);
            }
        });
        for(int i=0;i<intervals.length-1;i++){
            if(intervals[i][1]>=intervals[i+1][0]){
                int minElement=Math.min(intervals[i][0], intervals[i+1][0]);
                int maxElement=Math.max(intervals[i][1], intervals[i+1][1]);
                intervals[i+1][0]=minElement;
                intervals[i+1][1]=maxElement;     
                if(i==intervals.length-2)
                    resultList.add(List.of(intervals[i+1][0], intervals[i+1][1]));
            }
            else{
                if(i==intervals.length-2){
                    resultList.add(List.of(intervals[i][0], intervals[i][1]));
                    resultList.add(List.of(intervals[i+1][0], intervals[i+1][1]));
                }
                else
                    resultList.add(List.of(intervals[i][0], intervals[i][1]));
            }   
        }        
        result=new int[resultList.size()][2];
        for(int i=0;i<result.length;i++){
            result[i][0]=resultList.get(i).get(0);
            result[i][1]=resultList.get(i).get(1);
        }
        return result;
    }    
    public static void main(String[] args){
        Scanner sc;
        int[][] intervals;        
        try{
            sc=new Scanner(System.in);            
            System.out.println("Enter length of intervals array : ");
            int length=sc.nextInt();
            intervals=new int[length][2];
            for(int i=0;i<length;i++){
                intervals[i][0]=sc.nextInt();
                intervals[i][1]=sc.nextInt();
            }          
            System.out.println(new MergeIntervals().merge(intervals));              
        }
        catch(Exception e){
            System.out.println("Exception occured : "+e.getMessage());
            e.printStackTrace();
        }
    }
}
