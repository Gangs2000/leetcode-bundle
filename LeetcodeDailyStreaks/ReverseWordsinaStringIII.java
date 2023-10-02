package LeetcodeDailyStreaks;

import java.util.Scanner;

public class ReverseWordsinaStringIII { 
    StringBuilder builder=new StringBuilder();
    public String reverseWords(String s) {
        String[] words=s.split(" ");
        for(int i=0;i<words.length;i++){
            StringBuilder reverseWord=new StringBuilder(words[i]);            
            builder.append(reverseWord.reverse()+" ");
        }
        return builder.toString().trim();
    }
    public static void main(String[] args){
        Scanner sc;
        try{
            sc=new Scanner(System.in);
            System.out.println("Enter a Sentence to reverse the words : ");
            String sentence=sc.nextLine();
            System.out.println(new ReverseWordsinaStringIII().reverseWords(sentence));
        }
        catch(Exception e){
            System.out.println("Exception occurred : "+e.getMessage());
            e.printStackTrace();
        }
    }
}
