package LeetcodeDailyStreaks;

import java.util.Scanner;

public class SearchinRotatedSortedArray {
    public int search(int[] nums, int target) {
        //Do Binary Search to find out pivot point..
        int start=0, end=nums.length-1, pivot=0;
        while(start<end){
            int middle=start+((end-start))/2;
            if(nums[middle]>nums[start])
                start=middle;
            else if(nums[middle]<nums[start])
                end=middle;
            else{
                pivot=end;
                break;
            }
        }
        if(nums[pivot]==target)        
            return pivot;
        //Binary search on left and right subarray..
        int leftSubArray=binarySearch(0, pivot-1, target, nums);
        return (leftSubArray!=-1)?(leftSubArray):(binarySearch(pivot, nums.length-1, target, nums));
    }
    public int binarySearch(int start, int end, int target, int[] nums){
        while(start<=end){
            int middle=start+((end-start)/2);
            if(nums[middle]==target)
                return middle;
            else if(nums[middle]<target)
                start=middle+1;
            else if(nums[middle]>target)
                end=middle-1;
        }
        return -1;
    }
    public static void main(String[] args){
        Scanner sc;
        int[] array;
        try{
            sc=new Scanner(System.in);
            System.out.println("Enter length of an array : ");
            int length=sc.nextInt();
            array=new int[length];
            for(int i=0;i<length;i++)
                array[i]=sc.nextInt();
            System.out.println("Enter target value : ");
            int target=sc.nextInt();
            System.out.println(new SearchinRotatedSortedArray().search(array, target));
        }
        catch(Exception e){
            System.out.println("Exception occurred : "+e.getMessage());
            e.printStackTrace();
        }
    }
}
