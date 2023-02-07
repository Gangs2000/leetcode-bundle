package LeetcodeDailyStreaks;

import java.util.Arrays;
import java.util.Scanner;

public class PermutationsInString {
    public boolean checkInclusion(String s1, String s2) {
        char[] arr=s1.toCharArray();
        Arrays.sort(arr);
        s1=String.valueOf(arr);
        int limit=s2.length()-(s1.length())+1;
        for(int i=0;i<limit;i++){
            char[] getSubChars=s2.substring(i, i+s1.length()).toCharArray();
            Arrays.sort(getSubChars);
            if(String.valueOf(getSubChars).equals(s1))
                return true;
        }
        return false;
    }
    public static void main(String[] args){
        Scanner sc;
        try{
            sc=new Scanner(System.in);
            System.out.println("Enter S1 and S2 values : ");
            String s1=sc.next(); 
            String s2=sc.next();
            System.out.println(new PermutationsInString().checkInclusion(s1, s2));
        }
        catch(Exception e){
            System.out.println("Exception occurred : "+e.getMessage());
            e.printStackTrace();
        }
    }
}
