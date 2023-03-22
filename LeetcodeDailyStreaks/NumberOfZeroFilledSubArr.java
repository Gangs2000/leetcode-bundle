package LeetcodeDailyStreaks;

import java.util.Scanner;

public class NumberOfZeroFilledSubArr {
    long countZeroFilledSubArr=0, consZeroCount=0;
    public long zeroFilledSubarray(int[] nums) {
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0){      
                consZeroCount++;
                if(consZeroCount!=0 && i==nums.length-1)
                    countZeroFilledSubArr+=this.recursiveCall(consZeroCount);
            }
            else{
                if(consZeroCount!=0){
                    countZeroFilledSubArr+=this.recursiveCall(consZeroCount);
                    consZeroCount=0;
                }
            }
        }        
        return countZeroFilledSubArr;
    }
    public long recursiveCall(long consZeroCount){
        long totalSum=0;
        while(consZeroCount!=0){
            totalSum+=consZeroCount;
            consZeroCount--;
        }
        return totalSum;
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
            System.out.println(new NumberOfZeroFilledSubArr().zeroFilledSubarray(nums));
        }
        catch(Exception e){
            System.out.println("Exception occurred : "+e.getMessage());
            e.printStackTrace();
        }
    }
}
