package LeetcodeDailyStreaks;

import java.util.Scanner;

public class MostConsecutiveOnes {
    int maxCount=0;
    public int longestOnes(int[] nums, int k) {
        int leftPointer=0, rightPointer=0, count=0;
        while(rightPointer<nums.length){
            if(nums[rightPointer++]==0)
                count++;
            while(count>k)
                count-=(nums[leftPointer++]==0)?(1):(0);
            maxCount=Math.max(maxCount, rightPointer-leftPointer);
        }
        return maxCount;
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
            System.out.println("Enter number of operations to be performed : ");
            int k=sc.nextInt();
            System.out.println(new MostConsecutiveOnes().longestOnes(nums, k));
        }
        catch(Exception e){
            System.out.println("Exception occurred : "+e.getMessage());
            e.printStackTrace();
        }
    }
}
