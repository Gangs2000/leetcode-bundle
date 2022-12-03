package LeetcodeDailyStreaks;

import java.util.List;
import java.util.Scanner;

public class DetermineIfStringsHalvesAlike {
    int rightCount,leftCount;
    public DetermineIfStringsHalvesAlike(){
        rightCount=0;
        leftCount=0;
    }
    public boolean halvesAreAlike(String s) {
        for(int i=0;i<(s.length()/2);i++){
            if(List.of('a','e','i','o','u','A','E','I','O','U').contains(s.charAt(i)))
                rightCount++;
            if(List.of('a','e','i','o','u','A','E','I','O','U').contains(s.charAt(s.length()-i-1)))
                leftCount++;
        }
        return rightCount==leftCount;
    }
    public static void main(String[] args){
        Scanner sc;
        try{
            sc=new Scanner(System.in);
            System.out.println("Enter a String to find String Halves are alike : ");
            String string=sc.next();
            System.out.println(new DetermineIfStringsHalvesAlike().halvesAreAlike(string));            
        }
        catch(Exception e){
            System.out.println("Exception occured : "+e.getMessage());
            e.printStackTrace();
        }
    }
}
