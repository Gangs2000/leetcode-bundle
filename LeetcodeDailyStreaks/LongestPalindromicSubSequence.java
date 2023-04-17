package LeetcodeDailyStreaks;

import java.util.Scanner;

public class LongestPalindromicSubSequence {
    int longestPalindromicCount=0;
    public int longestPalindromeSubseq(String s) {
        StringBuilder stringBuilder=new StringBuilder();
        this.findAllSubSequences(0, stringBuilder, s);
        return longestPalindromicCount;
    }
    public void findAllSubSequences(int index, StringBuilder stringBuilder, String originalString){
        if(index==originalString.length())            
            return ;            
        System.out.println(stringBuilder+" "+stringBuilder.reverse()+" "+stringBuilder.toString().equals(stringBuilder.reverse().toString()));
        stringBuilder.append(originalString.charAt(index));        
        findAllSubSequences(index+1, stringBuilder, originalString);        
        stringBuilder.deleteCharAt(stringBuilder.length()-1);        
        findAllSubSequences(index+1, stringBuilder, originalString);
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
