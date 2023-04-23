package MemoiDPAndBackTracking;

import java.util.Scanner;

public class MaximumAlternatinSubSeqSum {
    long maxSubSeqSum=0;
    public long maxAlternatingSum(int[] nums) {
        this.findAllCombinations(0, 0, 0, 0, nums);
        return maxSubSeqSum;
    }
    public void findAllCombinations(int index, int evenIndexSum, int oddIndexSum, int capacity, int[] nums){                         
        maxSubSeqSum=Math.max(maxSubSeqSum, (evenIndexSum-oddIndexSum));
        for(int i=index;i<nums.length;i++){            
            if(capacity%2==0)              
                this.findAllCombinations(i+1, evenIndexSum+nums[i], oddIndexSum, capacity+1, nums);
            else                
                this.findAllCombinations(i+1, evenIndexSum, oddIndexSum+nums[i], capacity+1, nums);            
        }         
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
            System.out.println(new MaximumAlternatinSubSeqSum().maxAlternatingSum(nums));       
        }
        catch(Exception e){
            System.out.println("Exception occurred : "+e.getMessage());
            e.printStackTrace();
        }
    }
}
