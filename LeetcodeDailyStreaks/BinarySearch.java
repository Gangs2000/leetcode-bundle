package LeetcodeDailyStreaks;

import java.util.Scanner;

public class BinarySearch {
    public int search(int[] nums, int target) {
        int start=0, end=nums.length;
        while(start<end){            
            int mid=start+(end-start)/2;
            if(nums[mid]==target)
                return mid;
            else if(nums[mid]<target){
                start=mid;                
                if((mid==nums.length-1 && nums[mid]!=target) || (mid!=nums.length-1 && nums[mid+1]>target))
                    return -1;                
            }
            else if(nums[mid]>target){
                end=mid;
                if((mid==0 && nums[mid]!=target) || (mid!=0 && nums[mid-1]<target))
                    return -1;
            }
        }
        return -1;
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
            System.out.println(new BinarySearch().search(nums, length));
        }
        catch(Exception e){
            System.out.println("Exception occurred : "+e.getMessage());
            e.printStackTrace();
        }
    }
}
