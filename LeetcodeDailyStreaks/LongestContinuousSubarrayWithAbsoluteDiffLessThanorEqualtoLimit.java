package LeetcodeDailyStreaks;

import java.util.Scanner;

public class LongestContinuousSubarrayWithAbsoluteDiffLessThanorEqualtoLimit {
    int longestSubArrayLength=0, min=Integer.MAX_VALUE, max=Integer.MIN_VALUE;    
    public int longestSubarray(int[] nums, int limit) {
        for(int i=0;i<nums.length;i++){
            for(int j=i;j<nums.length;j++){
                min=Math.min(min, nums[j]);
                max=Math.max(max, nums[j]);
                if(Math.abs(max-min)<=limit)
                    longestSubArrayLength=Math.max(longestSubArrayLength, (j-i)+1);
            }   
            min=Integer.MAX_VALUE; max=Integer.MIN_VALUE;         
        }
        return longestSubArrayLength;
    }
    public static void main(String[] args){
        Scanner sc;
        int[] nums;
        try{
            sc=new Scanner(System.in);
            System.out.println("Enter length of nums array : ");
            int length=sc.nextInt();
            nums=new int[length];
            for(int i=0;i<length;i++)
                nums[i]=sc.nextInt();
            System.out.println("Enter limit value : ");
            int limit=sc.nextInt();
            System.out.println(new LongestContinuousSubarrayWithAbsoluteDiffLessThanorEqualtoLimit().longestSubarray(nums, limit));
        }
        catch(Exception e){
            System.out.println("Exception occurred : "+e.getMessage());
            e.printStackTrace();
        }
    }
}
