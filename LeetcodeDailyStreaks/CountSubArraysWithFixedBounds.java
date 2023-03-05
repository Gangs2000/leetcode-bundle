package LeetcodeDailyStreaks;

import java.util.Scanner;

public class CountSubArraysWithFixedBounds {
    long answer=0;
    int minimumBound=-1, maximumBound=-1, culpritIndex=-1;
    public long countSubarrays(int[] nums, int minK, int maxK) {
        for(int i=0;i<nums.length;i++){
            if(nums[i]==minK)
                minimumBound=i;
            if(nums[i]==maxK)
                maximumBound=i;
            if(nums[i]>maxK)
                culpritIndex=i;
            int smaller=Math.min(minimumBound, maximumBound);
            int temp=smaller-culpritIndex;
            answer+=(temp<=0)?(0):(temp);
        }
        return answer;
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
            System.out.println("Enter min and max K values : ");
            int minK=sc.nextInt();
            int maxK=sc.nextInt();
            System.out.println(new CountSubArraysWithFixedBounds().countSubarrays(nums, minK, maxK));
        }
        catch(Exception e){
            System.out.println("Exception occurred : "+e.getMessage());
            e.printStackTrace();
        }
    }
}
