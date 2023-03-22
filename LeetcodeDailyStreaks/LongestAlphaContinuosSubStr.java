package LeetcodeDailyStreaks;

import java.util.Scanner;

public class LongestAlphaContinuosSubStr {
    int countSequence=1, longestSequence=1;
    public int longestContinuousSubstring(String s) {
        for(int i=0;i<s.length()-1;i++){
            byte a=(byte) s.charAt(i);
            byte b=(byte) s.charAt(i+1);
            if((b-a)==1)
                countSequence++;
            else{                
                longestSequence=Math.max(longestSequence, countSequence);
                countSequence=1;
            }
        }        
        return (countSequence==1)?(longestSequence):(Math.max(longestSequence, countSequence));
    }
    public static void main(String[] args){
        Scanner sc;
        try{
            sc=new Scanner(System.in);
            System.out.println("Enter String S value : ");
            String s=sc.next().toLowerCase();
            System.out.println(new LongestAlphaContinuosSubStr().longestContinuousSubstring(s));
        }
        catch(Exception e){
            System.out.println("Exception occurred : "+e.getMessage());
            e.printStackTrace();
        }
    }
}
