package LeetcodeDailyStreaks;

import java.util.Scanner;

public class MergeStringsAlternatively {
    StringBuilder builder;
    public String mergeAlternately(String word1, String word2) {
        builder=new StringBuilder();
        int start=0, end=(word1.length()<word2.length())?(word1.length()):(word2.length());
        while(start<end){
            builder.append(word1.charAt(start));
            builder.append(word2.charAt(start));
            start++;
        }
        if(start==word1.length())
            builder.append(word2.substring(start));
        if(start==word2.length())
            builder.append(word1.substring(start));
        return builder.toString();
    }
    public static void main(String[] args){
        Scanner sc;
        try{
            sc=new Scanner(System.in);
            System.out.println("Enter Word1 and Word2 values : ");
            String word1=sc.next();
            String word2=sc.next();
            System.out.println(new MergeStringsAlternatively().mergeAlternately(word1, word2));
        }
        catch(Exception e){
            System.out.println("Exception occurred : "+e.getMessage());
            e.printStackTrace();    
        }
    }
}
