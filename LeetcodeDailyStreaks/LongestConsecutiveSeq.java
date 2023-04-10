package LeetcodeDailyStreaks;

import java.util.Arrays;
import java.util.Scanner;

public class LongestConsecutiveSeq {
    int result=Integer.MIN_VALUE, longestCount=1;
    public int longestConsecutive(int[] nums) { 
        if(nums.length==0)
            return 0;       
        Arrays.sort(nums);
        for(int i=1;i<nums.length;i++){
            if(nums[i]!=nums[i-1]){
                if((nums[i]-nums[i-1])==1)
                    longestCount++;
                else{
                    result=Math.max(result, longestCount);
                    longestCount=1;                
                }
            }
        }
        return Math.max(result, longestCount);        
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
            System.out.println(new LongestConsecutiveSeq().longestConsecutive(nums));
        }
        catch(Exception e){
            System.out.println("Exception occurred : "+e.getMessage());
            e.printStackTrace();
        }
    }
}
