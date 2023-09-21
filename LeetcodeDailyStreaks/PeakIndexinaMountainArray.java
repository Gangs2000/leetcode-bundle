package LeetcodeDailyStreaks;

import java.util.Scanner;

public class PeakIndexinaMountainArray {
    public int peakIndexInMountainArray(int[] arr) {
        int leftPointer=0, rightPointer=arr.length-1;
        while(leftPointer<rightPointer){            
            int middle=leftPointer+((rightPointer-leftPointer)/2);
            if(arr[middle]>arr[middle+1])
                rightPointer=middle;
            else
                leftPointer=middle+1;            
        }
        return leftPointer;
    }
    public static void main(String[] args){
        Scanner sc;
        int[] nums;
        try{
            sc=new Scanner(System.in);
            System.out.println("Enter length of an nums array : ");
            int length=sc.nextInt();
            nums=new int[length];
            for(int i=0;i<length;i++)
                nums[i]=sc.nextInt();
            System.out.println(new PeakIndexinaMountainArray().peakIndexInMountainArray(nums));
        }
        catch(Exception e){
            System.out.println("Exception occurred : "+e.getMessage());
            e.printStackTrace();
        }
    }
}
