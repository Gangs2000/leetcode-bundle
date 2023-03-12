package LeetcodeDailyStreaks;
import java.util.Scanner;

public class MinimumTimeToCompleteTrips {
    public long minimumTime(int[] time, int totalTrips) {
        long leftPointer=1;
        long rightPointer=100000000000000L;
        while(leftPointer<rightPointer){
            long midPoint=leftPointer+((rightPointer-leftPointer)/2);
            if(this.possibleToFinishTrips(midPoint, time, totalTrips))
                rightPointer=midPoint;
            else    
                leftPointer=midPoint+1;
        }
        return leftPointer;
    }
    public boolean possibleToFinishTrips(long midPoint, int[] time, int totalTrips){
        long sumOfAllTime=0;
        for(int element : time)
            sumOfAllTime+=(midPoint/element);
        return sumOfAllTime>=totalTrips;
    }
    public static void main(String[] args){
        Scanner sc;
        int[] time;
        try{
            sc=new Scanner(System.in);
            System.out.println("Enter length of time array : ");
            int length=sc.nextInt();
            time=new int[length];
            for(int i=0;i<length;i++)
                time[i]=sc.nextInt();
            System.out.println("Enter total trips value : ");
            int totalTrips=sc.nextInt();
            System.out.println(new MinimumTimeToCompleteTrips().minimumTime(time, totalTrips));       
        }
        catch(Exception e){
            System.out.println("Exception occurred : "+e.getMessage());
            e.printStackTrace();
        }
    }
}
