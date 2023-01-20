package LeetcodeDailyStreaks;

import java.util.Arrays;
import java.util.Scanner;

public class MaximumSumCiruclarSubArray {
    public int kadaneMax(int[] nums){
        int sum=nums[0], maxSum=nums[0];
        for(int i=1;i<nums.length;i++){
            sum=Math.max(sum+nums[i], nums[i]);
            maxSum=Math.max(maxSum, sum);
        }
        return maxSum;
    }
    public int kadaneMin(int[] nums){
        int sum=nums[0], minSum=nums[0];
        for(int i=1;i<nums.length;i++){
            sum=Math.min(sum+nums[i], nums[i]);
            minSum=Math.min(minSum, sum);
        }
        return minSum;
    }
    public int maxSubarraySumCircular(int[] nums) {
        int totalSum=Arrays.stream(nums).boxed().reduce((a,b)-> (a+b)).get();
        int maxSum=kadaneMax(nums);
        int minSum=kadaneMin(nums);
        int circularSum=totalSum-minSum;
        if(maxSum>0)
            return Math.max(circularSum, maxSum);
        return maxSum;        
    }
    public static void main(String[] args){
        Scanner sc;
        try{
            sc=new Scanner(System.in);
            System.out.println("Enter length of nums array : ");
            int length=sc.nextInt();
            int[] nums=new int[length];
            for(int i=0;i<length;i++)
                nums[i]=sc.nextInt();
            System.out.println(new MaximumSumCiruclarSubArray().maxSubarraySumCircular(nums));
        }
        catch(Exception e){
            System.out.println("Exception occurred : "+e.getMessage());
            e.printStackTrace();
        }
    }
}
