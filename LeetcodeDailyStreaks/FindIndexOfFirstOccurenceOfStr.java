package LeetcodeDailyStreaks;

import java.util.Scanner;

public class FindIndexOfFirstOccurenceOfStr {    
    public int strStr(String haystack, String needle) {
        int leftPointer=0, rightPointer=needle.length();
        if(haystack.length()<needle.length())
            return -1;
        while(rightPointer!=haystack.length()+1){
            if(haystack.substring(leftPointer, rightPointer).equals(needle))
                return leftPointer;
            leftPointer++;
            rightPointer++;            
        }
        return -1;
    }
    public static void main(String[] args){
        Scanner sc;
        try{
            sc=new Scanner(System.in);
            System.out.println("Enter hayStack and needle words : ");
            String hayStack=sc.next();
            String needle=sc.next();
            System.out.println(new FindIndexOfFirstOccurenceOfStr().strStr(hayStack, needle));
        }
        catch(Exception e){
            System.out.println("Exception occurred : "+e.getMessage());
            e.printStackTrace();
        }
    }
}
