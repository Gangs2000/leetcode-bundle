package LeetcodeDailyStreaks;

import java.util.Scanner;

public class MaximumNumberofVowelsSubstringofGivenLength {
    int i=0, j=0, maxVowelCount=0;
    public int maxVowels(String s, int k) {
        int vowelCount=0;
        while(i<=s.length()-k){
            if((j-i+1)<=k){
                if(this.isVowel(s, j)){
                    vowelCount++;                
                    maxVowelCount=Math.max(maxVowelCount, vowelCount);
                }
                j++;
            }
            else {
                if(this.isVowel(s, i))
                    vowelCount--;
                i++;
            }
        }
        return maxVowelCount;        
    }    
    public boolean isVowel(String s, int index){
        return (s.charAt(index)=='a' || s.charAt(index)=='e' || s.charAt(index)=='i' || s.charAt(index)=='o' || s.charAt(index)=='u')?(true):(false);
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
