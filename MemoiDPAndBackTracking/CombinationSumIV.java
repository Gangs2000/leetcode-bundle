package MemoiDPAndBackTracking;

import java.util.Arrays;
import java.util.Scanner;

public class CombinationSumIV {
    int[][] cache;
    public int combinationSum4(int[] nums, int target) {
        cache=new int[nums.length][target+1];
        Arrays.stream(cache).forEach(array->Arrays.fill(array, -1));
        return findAllCombinations(nums, cache, 0, target);
    }   
    public int findAllCombinations(int[] nums, int[][] cache, int index, int target){                
        if(index>=nums.length || target<0)
            return 0;
        if(target==0)
            return 1;
        if(cache[index][target]!=-1)    
            return cache[index][target];        
        return cache[index][target]=findAllCombinations(nums, cache, 0, target-nums[index])+findAllCombinations(nums, cache, index+1, target);
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
            System.out.println("Enter Target value : ");
            int target=sc.nextInt();
            System.out.println(new CombinationSumIV().combinationSum4(nums, target));
        }   
        catch(Exception e){
            System.out.println("Exception occurred : "+e.getMessage());
            e.printStackTrace();
        }
    }
}
