package LeetcodeDailyStreaks;

import java.util.Scanner;

public class MaximumNumberofVowelsSubstringofGivenLength {
    int countMaxVowel=0;
    public int maxVowels(String s, int k) {
        for(int i=0;i<=s.length()-k;i++)            
            countMaxVowel=Math.max(countMaxVowel, this.returnVowelCount(s.substring(i, i+k)));
        return countMaxVowel;        
    }
    public int returnVowelCount(String substr){
        int count=0;
        for(int i=0;i<substr.length();i++){
            if(substr.charAt(i)=='a' || substr.charAt(i)=='e' || substr.charAt(i)=='i' || substr.charAt(i)=='o' || substr.charAt(i)=='u')
                count++;
        }
        return count;
    }
    public static void main(String[] args){
        Scanner sc;
        try{
            sc=new Scanner(System.in);
            System.out.println("Enter S value : ");
            String s=sc.next();
            System.out.println("Enter K value : ");
            int k=sc.nextInt();
            System.out.println(new MaximumNumberofVowelsSubstringofGivenLength().maxVowels(s, k));
        }   
        catch(Exception e){
            System.out.println("Exception occurred : "+e.getMessage());
            e.printStackTrace();
        }
    }
}
