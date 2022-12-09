package LeetcodeDailyStreaks;

import java.util.Scanner;

public class ApplyOperationsToAnArray {
    int zeroPointer=0;
    public int[] applyOperations(int[] nums) {
        for(int i=0;i<nums.length-1;i++){
            if(nums[i]==nums[i+1]){
                nums[i]=nums[i]*2;
                nums[i+1]=0;
            }
        }        
        return this.moveZeroes(nums);
    }    
    public int[] moveZeroes(int[] nums){
        for(int i=0;i<nums.length;i++){
            if(nums[zeroPointer]==0){
                if(nums[i]!=0){
                    nums[zeroPointer]=nums[zeroPointer]+nums[i];   // 0 + 1 = 1
                    nums[i]=nums[zeroPointer]-nums[i];             // 1 - 1 = 0                    
                    nums[zeroPointer]=nums[zeroPointer]-nums[i];   // 1 - 0 = 1
                    zeroPointer++;
                }
            }
            else
                zeroPointer++;
        }
        return nums;
    }
    public static void main(String[] args){
        Scanner sc;
        int[] nums;
        try{
            sc=new Scanner(System.in);
            System.out.println("Enter length of an array : ");
            int length=sc.nextInt();
            nums=new int[length];
            for(int i=0;i<length;i++)
                nums[i]=sc.nextInt();            
            System.out.println(new ApplyOperationsToAnArray().applyOperations(nums));
        }
        catch(Exception e){
            System.out.println("Exception occured : "+e.getMessage());
            e.printStackTrace();
        }
    }
}
