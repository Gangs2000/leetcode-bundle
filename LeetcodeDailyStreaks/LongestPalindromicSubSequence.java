package LeetcodeDailyStreaks;

import java.util.Arrays;
import java.util.Scanner;

public class LongestPalindromicSubSequence {
    int dp[][];
    public LongestPalindromicSubSequence(){
        dp=new int[1001][1001];
    }
    public int longestPalindromeSubseq(String s) {  
        Arrays.stream(dp).forEach(array->Arrays.fill(array, -1));
        return s.length()-this.findAllSubSequences(dp, 0, s.length()-1, s);
    }
    public int findAllSubSequences(int[][] dp, int begin, int end, String string){
        if(begin>=end)
            return 0;
        if(dp[begin][end]!=-1)
            return dp[begin][end];
        if(string.charAt(begin)==string.charAt(end))
            return findAllSubSequences(dp, begin+1, end-1, string);        
        return dp[begin][end]=1+Math.min(findAllSubSequences(dp, begin+1, end, string), findAllSubSequences(dp, begin, end-1, string));
    }    
    public static void main(String[] args){
        Scanner sc;
        try{
            sc=new Scanner(System.in);
            System.out.println("Enter a String to find out longest palindromic subsequence : ");
            String string=sc.next();
            System.out.println(new LongestPalindromicSubSequence().longestPalindromeSubseq(string));
        }
        catch(Exception e){
            System.out.println("Exception occurred : "+e.getMessage());
            e.printStackTrace();
        }
    }
}
