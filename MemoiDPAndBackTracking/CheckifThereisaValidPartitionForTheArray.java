package MemoiDPAndBackTracking;

import java.util.Scanner;

public class CheckifThereisaValidPartitionForTheArray {    
    public boolean validPartition(int[] nums) {        
        return partitionArray(0, nums, new Boolean[nums.length]);
    }
    public boolean partitionArray(int index, int[] nums, Boolean[] cache){
        if(index==nums.length)
            return true;
        if(cache[index]!=null)
            return cache[index];
        boolean result=false;
        if(index+1<nums.length && nums[index]==nums[index+1])  
            result |=partitionArray(index+2, nums, cache);
        if(index+2<nums.length && nums[index]==nums[index+1] && nums[index+1]==nums[index+2])
            result |=partitionArray(index+3, nums, cache);
        if(index+2<nums.length && nums[index+1]-nums[index]==1 && nums[index+2]-nums[index+1]==1)
            result |=partitionArray(index+3, nums, cache);
        return cache[index]=result;
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
            System.out.println(new CheckifThereisaValidPartitionForTheArray().validPartition(nums));
        }
        catch(Exception e){
            System.out.println("Exception occurred : "+e.getMessage());
            e.printStackTrace();
        }
    }
}
