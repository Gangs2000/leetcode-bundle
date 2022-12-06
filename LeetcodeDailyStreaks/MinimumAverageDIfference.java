package LeetcodeDailyStreaks;

import java.util.Scanner;

public class MinimumAverageDIfference {    
    int sum=0,leftSum=0,rightSum=0,index=0,element=Integer.MAX_VALUE;    
    public int minimumAverageDifference(int[] nums) {                
        for(int i=0;i<nums.length;i++)
            sum+=nums[i];
        for(int i=0;i<nums.length;i++){                       
            leftSum+=nums[i];
            rightSum=sum-leftSum;            
            int result=Math.abs((Math.abs(leftSum/(i+1)))-Math.abs(((i==nums.length-1)?(0):(rightSum/((nums.length)-(i+1))))));                                                                        
            if(result<element){
                element=result;
                index=i;                
            }                                                
        }                
        return index;
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
            System.out.println(new MinimumAverageDIfference().minimumAverageDifference(nums));
        }
        catch(Exception e){
            System.out.println("Exception occured : "+e.getMessage());
            e.printStackTrace();
        }
    }
}
