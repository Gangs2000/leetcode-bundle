package LeetcodeDailyStreaks;

import java.util.Scanner;

public class SearchInsertPosition {
    public int searchInsert(int[] nums, int target) {
        int leftPointer=0, rightPointer=nums.length-1;
        while(leftPointer<=rightPointer){            
            int middlePointer=(leftPointer+rightPointer)/2;            
            if(nums[middlePointer]==target)                
                return middlePointer;            
            else if(nums[middlePointer]<target){
                leftPointer=middlePointer+1;    
                if(middlePointer==nums.length-1)
                    return nums.length;            
                if(nums[leftPointer]>target)                                     
                    return middlePointer+1;                      
            }
            else if(nums[middlePointer]>target){
                rightPointer=middlePointer-1;
                if(middlePointer==0)
                    return 0;                
                if(nums[rightPointer]<target)                    
                    return middlePointer;
            }
        }      
        return 1;  
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
            System.out.println("Enter Target value : ");
            int target=sc.nextInt();
            System.out.println(new SearchInsertPosition().searchInsert(nums, target));
        }
        catch(Exception e){
            System.out.println("Exception occurred : "+e.getMessage());
            e.printStackTrace();
        }
    }
}
