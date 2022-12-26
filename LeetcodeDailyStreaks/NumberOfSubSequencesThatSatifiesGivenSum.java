package LeetcodeDailyStreaks;

import java.util.Arrays;
import java.util.Scanner;

public class NumberOfSubSequencesThatSatifiesGivenSum {
    int count=0,rightPointer=0,leftPointer=0;
    public int numSubseq(int[] nums, int target) {
        Arrays.sort(nums);
        rightPointer=nums.length-1;
        while(leftPointer<=rightPointer){
            int sumOfPointers=nums[leftPointer]+nums[rightPointer];            
            if(sumOfPointers<=target){                         
                count+=(leftPointer==rightPointer)?(1):(Math.pow(2, rightPointer-leftPointer));
                leftPointer++;                                                   
            }
            else if(sumOfPointers>target)                
                rightPointer--;
        }
        return count;            
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
            System.out.println("Enter target value : ");
            int target=sc.nextInt();
            System.out.println(new NumberOfSubSequencesThatSatifiesGivenSum().numSubseq(nums, target));
        }
        catch(Exception e){
            System.out.println("Exception occurred : "+e.getMessage());
            e.printStackTrace();    
        }
    }
}

