package LeetcodeDailyStreaks;

import java.util.Scanner;

public class CountPrefixOfGivenStrings {
    private int countPrefix=0;
    public int countPrefixes(String[] words, String s) {
        for(int i=0;i<words.length;i++){
            if(words[i].length()<=s.length() && words[i].equals(s.substring(0, words[i].length())))
                countPrefix++;
        }
        return countPrefix;
    }
    public static void main(String[] args){
        Scanner sc;
        String[] words;
        try{
            sc=new Scanner(System.in);
            System.out.println("Enter length of words array : ");
            int length=sc.nextInt();
            words=new String[length];
            for(int i=0;i<length;i++)
                words[i]=sc.next();
            System.out.println("Enter S value : ");
            String s=sc.next();
            System.out.println(new CountPrefixOfGivenStrings().countPrefixes(words, s));
        }
        catch(Exception e){
            System.out.println("Exception occurred : "+e.getMessage());
            e.printStackTrace();
        }
    }
}
