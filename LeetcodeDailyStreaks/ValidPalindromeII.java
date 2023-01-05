package LeetcodeDailyStreaks;

import java.util.Scanner;

public class ValidPalindromeII {
    public boolean validPalindrome(String s) {
        for(int i=0;i<(s.length()/2);i++){
            if(s.charAt(i)!=s.charAt(s.length()-i-1)){
                if(deleteChars(s, i))
                    return true;                                    
                if(deleteChars(s, (s.length()-i-1)))
                    return true;
                return false;
            }
        }
        return true;        
    }
    public boolean deleteChars(String s, int index){
        StringBuilder delete=new StringBuilder(s);                    
        delete.deleteCharAt(index);
        if(delete.toString().equals(delete.reverse().toString()))
            return true;
        return false;
    }
    public static void main(String[] args){
        Scanner sc;
        try{
            sc=new Scanner(System.in);
            System.out.println("Enter a String to make it palindrome by deleting at most one character : ");
            String string=sc.next();
            System.out.println(new ValidPalindromeII().validPalindrome(string));
        }
        catch(Exception e){
            System.out.println("Exception occurred : "+e.getMessage());
            e.printStackTrace();
        }
    }
}
