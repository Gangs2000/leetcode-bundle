package MemoiDPAndBackTracking;

import java.util.Arrays;
import java.util.Scanner;

public class LongestIncreasingSubSequence {
    int[][] cache;
    public int lengthOfLIS(int[] nums) {
        cache=new int[nums.length][nums.length+1];
        Arrays.stream(cache).forEach(row->Arrays.fill(row, -1));
        return findAllPossibilites(0, -1, nums, cache);
    }
    public int findAllPossibilites(int index, int prev, int[] nums, int[][] cache){
        if(index==nums.length)
            return 0;
        if(cache[index][prev+1]!=-1)
            return cache[index][prev+1];
        int notTake=0+findAllPossibilites(index+1, prev, nums, cache);
        int take=0;        
        if(prev==-1 || nums[index]>nums[prev])
            take=1+findAllPossibilites(index+1, index, nums, cache);            
        return cache[index][prev+1]=Math.max(take, notTake);
    }
    public static void main(String[] main){
        Scanner sc;
        int[] nums;
        try{
            sc=new Scanner(System.in);
            System.out.println("Enter length of nums array : ");
            int length=sc.nextInt();
            nums=new int[length];
            for(int i=0;i<length;i++)
                nums[i]=sc.nextInt();
            System.out.println(new LongestIncreasingSubSequence().lengthOfLIS(nums));
        }
        catch(Exception e){
            System.out.println("Exception occurred : "+e.getMessage());
            e.printStackTrace();
        }
    }
}
