package LeetcodeDailyStreaks;

import java.util.Scanner;

public class RemovePalindromicSubSeq {
    public int removePalindromeSub(String s) {
        if(s.equals(""))
            return 0;
        else{
            StringBuilder stringBuilder=new StringBuilder(s);
            if(stringBuilder.reverse().toString().equals(s))
                return 1;
            else    
                return 2;
        }
    }
    public static void main(String[] args){
        Scanner sc;
        try{
            sc=new Scanner(System.in);
            System.out.println("Enter a String to remove palindromic strings : ");
            String string=sc.next();
            System.out.println(new RemovePalindromicSubSeq().removePalindromeSub(string));
        }
        catch(Exception e){
            System.out.println("Exception occurred : "+e.getMessage());
            e.printStackTrace();
        }
    }
}
