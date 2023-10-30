package LeetcodeDailyStreaks;

import java.util.Scanner;

public class LongestPalindromicSubstring {
    int startingPoint=0, maxLength=Integer.MIN_VALUE;    
    public String longestPalindrome(String s) {
        for(int i=0;i<s.length();i++){
            for(int j=i;j<s.length();j++){
                if(this.isStringPalindrome(s, i, j)==true){                                        
                    if(maxLength<(j-i+1)){
                        maxLength=Math.max(maxLength, (j-i+1));
                        startingPoint=i;                        
                    }                    
                }
            }
        }        
        return s.substring(startingPoint, startingPoint+maxLength);
    }
    public boolean isStringPalindrome(String string, int i, int j){
        if(i>j)
            return true;
        if(string.charAt(i)==string.charAt(j))
            return isStringPalindrome(string, i+1, j-1);
        else
            return false;
    }
    public static void main(String[] args){
        Scanner sc;
        try{
            sc=new Scanner(System.in);
            System.out.println("Enter S value : ");
            String string=sc.next();
            System.out.println(new LongestPalindromicSubstring().longestPalindrome(string));
        }
        catch(Exception e){
            System.out.println("Exception occurred : "+e.getMessage());
            e.printStackTrace();
        }
    }
}
