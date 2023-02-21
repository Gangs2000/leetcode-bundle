package LeetcodeDailyStreaks;

import java.util.Scanner;

public class SingleElementInASortedArray {
    public int singleNonDuplicate(int[] nums) {
        int leftPointer=0, rightPointer=nums.length-1, halfTraverse=(leftPointer+rightPointer)/2;
        while(leftPointer<halfTraverse){
            //Left to right traversal
            if(nums[leftPointer]!=nums[leftPointer+1])
                return nums[leftPointer];
            else
                leftPointer=leftPointer+2;
            //Right to left traversal
            if(nums[rightPointer]!=nums[rightPointer-1])
                return nums[rightPointer];
            else
                rightPointer=rightPointer-2;
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
            System.out.println(new SingleElementInASortedArray().singleNonDuplicate(nums));
        }
        catch(Exception e){
            System.out.println("Exception occurred : "+e.getMessage());
            e.printStackTrace();
        }
    }
}
