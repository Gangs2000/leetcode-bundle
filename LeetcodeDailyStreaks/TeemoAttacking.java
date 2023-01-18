package LeetcodeDailyStreaks;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class TeemoAttacking {
    List<List<Integer>> intervals;    
    int totalPoisonedDuration=0;
    public TeemoAttacking(){
        intervals=new LinkedList<>();        
    }
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        for(int i=0;i<timeSeries.length;i++)
            intervals.add(List.of(timeSeries[i], timeSeries[i]+(duration-1)));          //Calculating intervals
        System.out.println(intervals);
        if(intervals.size()==1)
            return (intervals.get(0).get(1)-intervals.get(0).get(0))+1;                  
        for(int i=0;i<intervals.size()-1;i++){
            if(intervals.get(i).get(1)>=intervals.get(i+1).get(0)){
                int min=Math.min(intervals.get(i).get(0), intervals.get(i+1).get(0));
                int max=Math.max(intervals.get(i).get(1), intervals.get(i+1).get(1));                                
                intervals.set(i+1, List.of(min, max));
                System.out.println(intervals);
                if(i==intervals.size()-2)
                    totalPoisonedDuration+=(intervals.get(i+1).get(1)-intervals.get(i+1).get(0))+1;              
            }
            else{
                if(i==intervals.size()-2){                                
                    totalPoisonedDuration+=(intervals.get(i).get(1)-intervals.get(i).get(0))+1;
                    totalPoisonedDuration+=(intervals.get(i+1).get(1)-intervals.get(i+1).get(0))+1;              
                }
                else
                    totalPoisonedDuration+=(intervals.get(i).get(1)-intervals.get(i).get(0))+1;
            }
        }
        return totalPoisonedDuration;
    }    
    public static void main(String[] args){
        Scanner sc;
        int[] timeSeries;
        int duration;
        try{
            sc=new Scanner(System.in);
            System.out.println("Enter length of time series array : ");
            int length=sc.nextInt();
            timeSeries=new int[length];
            for(int i=0;i<length;i++)
                timeSeries[i]=sc.nextInt();
            System.out.println("Enter duration : ");
            duration=sc.nextInt();
            System.out.println(new TeemoAttacking().findPoisonedDuration(timeSeries, duration));
        }
        catch(Exception e){
            System.out.println("Exception occurred : "+e.getMessage());
            e.printStackTrace();
        }
    }
}
