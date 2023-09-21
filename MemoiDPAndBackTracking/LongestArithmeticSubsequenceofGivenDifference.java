package MemoiDPAndBackTracking;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class LongestArithmeticSubsequenceofGivenDifference {
    Map<Integer, Integer> map;
    public LongestArithmeticSubsequenceofGivenDifference(){
        map=new HashMap<>();
    }
    public int longestSubsequence(int[] arr, int difference) {
        int maxDiff=1;
        for(int number : arr){
            int tillNow=map.getOrDefault(number-difference, 0);
            map.put(number, tillNow+1);
            maxDiff=Math.max(maxDiff, map.get(number));
        }
        return maxDiff;
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
            System.out.println("Enter difference between two values : ");
            int difference=sc.nextInt();
            System.out.println(new LongestArithmeticSubsequenceofGivenDifference().longestSubsequence(nums, difference));
        }
        catch(Exception e){
            System.out.println("Exception occurred : "+e.getMessage());
            e.printStackTrace();
        }
    }
}
