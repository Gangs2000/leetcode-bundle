import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import FunctionalInterface.Function;

public class MergeIntervals {
    private static List<List<Integer>> sortIntervals(List<List<Integer>> intervals){
        for(int i=0;i<intervals.size()-1;i++){
            for(int j=i+1;j<intervals.size();j++){
                if(intervals.get(i).get(0)>intervals.get(j).get(0)){
                    List<Integer> tempList=intervals.get(i);
                    intervals.set(i, intervals.get(j));
                    intervals.set(j, tempList);                    
                }                
            }
        }
        return intervals;
    }
    private static List<List<Integer>> mergeOverLappedIntervals(List<List<Integer>> sortedIntervals){
        List<List<Integer>> mergedIntervals=new LinkedList<>();
        for(int i=0;i<sortedIntervals.size();i++){
            if(mergedIntervals.size()==0)
                mergedIntervals.add(sortedIntervals.get(i));
            else {
                List<Integer> nonOverLappedList=new LinkedList<>();                               
                if(sortedIntervals.get(i).get(0)<=mergedIntervals.get(mergedIntervals.size()-1).get(1)){  //Retrieving last indexed list to compare values with current list
                    nonOverLappedList.add(mergedIntervals.get(mergedIntervals.size()-1).get(0));
                    nonOverLappedList.add(sortedIntervals.get(i).get(1));
                    mergedIntervals.set(mergedIntervals.size()-1, nonOverLappedList);
                }
                else 
                    mergedIntervals.add(sortedIntervals.get(i));
            }
        }
        return mergedIntervals;
    }
    public static void main(String[] args){
        Scanner sc;
        List<List<Integer>> intervals;
        Function<List<List<Integer>>,List<List<Integer>>> sortList, mergeList;
        try{
            sc=new Scanner(System.in);
            intervals=new LinkedList<>();
            System.out.println("Enter length of the list : ");
            int length=sc.nextInt();
            for(int i=0;i<length;i++){
                List<Integer> addList=new LinkedList<>();
                addList.add(sc.nextInt()); addList.add(sc.nextInt());
                intervals.add(addList);          
            }
            sortList=MergeIntervals::sortIntervals;
            mergeList=MergeIntervals::mergeOverLappedIntervals;
            System.out.println("Non Overlapped list : "+mergeList.apply(sortList.apply(intervals)));              //First Calling method to sort starting point of intervals and then invoked merge list method to merge overlapped intervals         
        }
        catch(Exception e){
            System.out.println("Exception occured : "+e.getMessage());
            e.printStackTrace();
        }
    }
}
