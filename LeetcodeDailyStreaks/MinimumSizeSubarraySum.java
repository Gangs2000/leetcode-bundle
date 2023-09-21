package LeetcodeDailyStreaks;

import java.util.Scanner;

public class MinimumSizeSubarraySum {
    int minSubArrLen=Integer.MAX_VALUE;
    public int minSubArrayLen(int target, int[] nums) {
        int leftPointer=0, rightPointer=0, currentSum=0;
        while(rightPointer<nums.length){
            currentSum+=nums[rightPointer++];
            while(currentSum>=target){
                minSubArrLen=Math.min(minSubArrLen, (rightPointer-leftPointer));
                currentSum-=nums[leftPointer++];                                                
            }                            
        }
        return (minSubArrLen==Integer.MAX_VALUE)?(0):(minSubArrLen);
    }
    public static void main(String[] args){
        Scanner sc;
        int[] nums;
        try{
            sc=new Scanner(System.in);
            System.out.println("Enter Target value : ");
            int target=sc.nextInt();
            System.out.println("Enter length of nums array : ");
            int length=sc.nextInt();
            nums=new int[length];
            for(int i=0;i<length;i++)
                nums[i]=sc.nextInt();
            System.out.println(new MinimumSizeSubarraySum().minSubArrayLen(target, nums));
        }
        catch(Exception e){
            System.out.println("Exception occurred : "+e.getMessage());
            e.printStackTrace();
        }
    }
}
