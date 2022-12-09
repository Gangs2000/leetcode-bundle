package LeetcodeDailyStreaks;

import java.util.Scanner;

public class MoveZeroes {
    int zeroPointer=0;    
    public void moveZeroes(int[] nums) {
        if(nums.length==1)
            System.out.println(nums);
        else{
            for(int i=1;i<nums.length;i++){
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
        }
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
            new MoveZeroes().moveZeroes(nums);
        }
        catch(Exception e){
            System.out.println("Exception occured : "+e.getMessage());
            e.printStackTrace();
        }
    }
}
