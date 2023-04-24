package MemoiDPAndBackTracking;

import java.util.Arrays;
import java.util.Scanner;

public class MinimumInsertionToMakeStrPalindrome {        
    int[][] dp;
    public MinimumInsertionToMakeStrPalindrome(){
        dp=new int[501][501];
    }
    public int minInsertions(String s) {
        Arrays.stream(dp).forEach(array->Arrays.fill(array, -1));
        return findMinCharsToBeAdded(dp, 0, s.length()-1, s);
    }        
    public int findMinCharsToBeAdded(int[][] dp, int begin, int end, String string){
        if(begin>=end)
            return 0;
        if(dp[begin][end]!=-1)
            return dp[begin][end];
        if(string.charAt(begin)==string.charAt(end))
            return findMinCharsToBeAdded(dp, begin+1, end-1, string);
        return dp[begin][end]=1+Math.min(findMinCharsToBeAdded(dp, begin+1, end, string), findMinCharsToBeAdded(dp, begin, end-1, string));
    }
    public static void main(String[] args){
        Scanner sc;
        try{
            sc=new Scanner(System.in);
            System.out.println("Enter S value : ");
            String s=sc.next();                        
            System.out.println(new MinimumInsertionToMakeStrPalindrome().minInsertions(s));
        }
        catch(Exception e){
            System.out.println("Exception occurred : "+e.getMessage());
            e.printStackTrace();
        }
    }
}
