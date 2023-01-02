package LeetcodeDailyStreaks;

import java.util.Scanner;

public class DetectCapital {    
    public boolean detectCapitalUse(String word) {   
        if(word.length()==1)    
            return true;  
        if(word.length()>=2){
            if(Character.isLowerCase(word.charAt(0)) && Character.isUpperCase(word.charAt(1)))
                return false;
        }
        for(int i=1;i<word.length()-1;i++){
            if(Character.getType(word.charAt(i))!=Character.getType(word.charAt(i+1)))
                return false;
        }
        return true;
    }
    public static void main(String[] args){
        Scanner sc;
        try{
            sc=new Scanner(System.in);
            System.out.println("Enter a word to detect captial : ");
            String word=sc.next();
            System.out.println(new DetectCapital().detectCapitalUse(word));
        }
        catch(Exception e){
            System.out.println("Exception occurred : "+e.getMessage());
            e.printStackTrace();
        }
    }
}
