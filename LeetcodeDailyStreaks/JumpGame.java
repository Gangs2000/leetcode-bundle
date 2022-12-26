package LeetcodeDailyStreaks;

import java.util.Scanner;

public class JumpGame {
    public boolean canJump(int[] nums) {
        int index=nums.length-1;
        for(int i=nums.length-2;i>=0;i--){
            if(nums[i]+i>=index)
                index=i;
        }
        return index==0;
    }
    public static void main(String[] args){
        Scanner sc;
        try{
            sc=new Scanner(System.in);
            System.out.println("Enter length of an array : ");
            int length=sc.nextInt();
            int[] nums=new int[length];
            for(int i=0;i<length;i++)
                nums[i]=sc.nextInt();
            System.out.println(new JumpGame().canJump(nums));
        }
        catch(Exception e){
            System.out.println("Exception occurred : "+e.getMessage());
            e.printStackTrace();
        }
    }
}
