package LeetcodeDailyStreaks;

import java.util.Scanner;

public class MonotonicArray {
    public boolean isMonotonic(int[] nums) {
        int type=(nums[0]<=nums[nums.length-1])?(1):(-1);
        for(int i=0;i<nums.length-1;i++){
            if(type==1){
                if(!(nums[i]<=nums[i+1]))
                    return false;
            }
            else if(type==-1){
                if(!(nums[i]>=nums[i+1]))
                    return false;
            }
        }
        return true;         
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
            System.out.println(new MonotonicArray().isMonotonic(nums));
        }
        catch(Exception e){
            System.out.println("Exception occurred : "+e.getMessage());
            e.printStackTrace();
        }
    }
}
