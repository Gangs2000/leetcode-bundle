package LeetcodeDailyStreaks;

import java.util.Scanner;

public class ReverseWordsInString {
    public String reverseWords(String s) {                
        String[] words=s.split("\\s+");                 
        for(int i=0;i<(words.length)/2;i++){
            String tempStr=words[i];            
            words[i]=words[(words.length-1)-i];
            words[(words.length-1)-i]=tempStr;   
     
        }        
        for(String string : words)
            s+=string+" ";        
        return s;   
    }
    public static void main(String[] args){
        Scanner sc;
        try{
            sc=new Scanner(System.in);
            System.out.println("Enter a String : ");
            String string=sc.nextLine().strip();
            System.out.println(new ReverseWordsInString().reverseWords(string));
        }
        catch(Exception e){
            System.out.println("Exce[tion occured : "+e.getMessage());
            e.printStackTrace();
        }
    }
}
