package LeetcodeDailyStreaks;

import java.util.List;
import java.util.Scanner;

public class ReverseVowelsOfAString {
    List<Character> vowels;    
    public ReverseVowelsOfAString(){
        vowels=List.of('a','e','i','o','u','A','E','I','O','U');
    }
    public String reverseVowels(String s) {
        StringBuilder strBuilder=new StringBuilder(s);         
        int leftPointer=-1, rightPointer=strBuilder.length()-1;
        for(int i=0;i<=rightPointer;i++){
            if(vowels.contains(strBuilder.charAt(i))){
                leftPointer=i;
                while(rightPointer>i){
                    if(vowels.contains(strBuilder.charAt(rightPointer))){                               
                        if(strBuilder.charAt(leftPointer)!=strBuilder.charAt(rightPointer)){                                           
                            char tempChar=strBuilder.charAt(rightPointer);
                            strBuilder.setCharAt(rightPointer, strBuilder.charAt(leftPointer));
                            strBuilder.setCharAt(leftPointer, tempChar);                                  
                        }                        
                        rightPointer--;          
                        break;
                    }
                    rightPointer--;
                }
            }            
        }
        return strBuilder.toString();
    }
    public static void main(String[] args){
        Scanner sc;
        try{
            sc=new Scanner(System.in);
            System.out.println("Enter a String to reverse all vowels : ");
            String string=sc.nextLine();                                    
            System.out.println(new ReverseVowelsOfAString().reverseVowels(string));
        }
        catch(Exception e){
            System.out.println("Exception occured : "+e.getMessage());
            e.printStackTrace();
        }
    }
}
