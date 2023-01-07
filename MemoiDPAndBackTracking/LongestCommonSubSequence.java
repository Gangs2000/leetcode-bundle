package MemoiDPAndBackTracking;

import java.util.Scanner;

public class LongestCommonSubSequence { 
    int cache[][];
    public LongestCommonSubSequence(){
        cache=new int[1001][1001];
    }   
    public int longestCommonSubsequence(String text1, String text2) {               
        return this.findSequence(text1, text2, 0, 0);        
    }
    public int findSequence(String text1, String text2, int i, int j){
        if(i>=text1.length() || j>=text2.length())
            return 0;
        if(text1.charAt(i)==text2.charAt(j))
            return 1+findSequence(text1, text2, i+1, j+1);
        if(cache[i][j]!=0)
            return cache[i][j];            
        else
            return cache[i][j]=Math.max(findSequence(text1, text2, i+1, j), findSequence(text1, text2, i, j+1));
    }
    public static void main(String[] args){
        Scanner sc;        
        try{
            sc=new Scanner(System.in);
            System.out.println("Enter String1 and String2 to find out longest common subsequence : ");
            String text1=sc.next();
            String text2=sc.next();
            System.out.println(new LongestCommonSubSequence().longestCommonSubsequence(text1, text2));
        }
        catch(Exception e){
            System.out.println("Exception occurred : "+e.getMessage());
            e.printStackTrace();
        }
    }
}
