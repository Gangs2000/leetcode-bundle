package LeetcodeDailyStreaks;

import java.util.Arrays;
import java.util.Scanner;

public class FindTheDuplicateNumber {
    int duplicateElement=0;
    public int findDuplicate(int[] nums) {  
        Arrays.sort(nums);
        for(int i=0;i<nums.length-1;i++){
            if(nums[i]==nums[i+1]){
                duplicateElement=nums[i];
                break;
            }                
        }        
        return duplicateElement;
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
            System.out.println(new FindTheDuplicateNumber().findDuplicate(nums));
        }
        catch(Exception e){
            System.out.println("Exception occurred : "+e.getMessage());
            e.printStackTrace();
        }
    }
}
