package LeetcodeDailyStreaks;

import java.util.Scanner;

public class CheckIfStringIsPrefixOfArray {
    String buildStr="";
    public boolean isPrefixString(String s, String[] words) {
        for(int i=0;i<words.length;i++){
            buildStr+=words[i];
            if(buildStr.length()==s.length())
                return (s.equals(buildStr.substring(0, s.length())));
        }
        return false;
    }
    public static void main(String[] args){
        Scanner sc;
        String[] words;
        try{
            sc=new Scanner(System.in);
            System.out.println("Enter String S value : ");
            String s=sc.next();
            System.out.println("Enter length of words array : ");
            int length=sc.nextInt();
            words=new String[length];
            for(int i=0;i<length;i++)
                words[i]=sc.next();
            System.out.println(new CheckIfStringIsPrefixOfArray().isPrefixString(s, words));
        }
        catch(Exception e){
            System.out.println("Exception occurred : "+e.getMessage());
            e.printStackTrace();
        }
    }
}
