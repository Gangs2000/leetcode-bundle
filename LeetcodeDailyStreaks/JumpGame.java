package LeetcodeDailyStreaks;

import java.util.Scanner;

public class JumpGame {
    int cache[];
    public boolean canJump(int[] nums) {        
        cache=new int[10001];
        return (isReachableToLastIndex(0, nums)==1)?(true):(false);
    }
    public int isReachableToLastIndex(int index, int[] nums){
        if(index==nums.length-1 || index>=nums.length)
            return 1;
        if(cache[index]!=0)
            return cache[index];
        for(int i=1;i<=nums[index];i++){
            if(isReachableToLastIndex(index+i, nums)==1)                
                return cache[index]=1;
        }        
        return cache[index]=2;
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
