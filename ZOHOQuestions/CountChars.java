package ZOHOQuestions;

import java.util.Arrays;
import java.util.Scanner;

public class CountChars {   
    int numeric=0;
    char character; 
    StringBuilder stringBuilder;
    public CountChars(){
        stringBuilder=new StringBuilder();
    }
    public String printCharacters(String string){
        //a12b12c45d2e5                        
        for(int i=0;i<string.length()-1;i++){
            if(Character.isLetter(string.charAt(i)))                
                character=string.charAt(i);
            if(Character.isDigit(string.charAt(i)) && Character.isDigit(string.charAt(i+1)))
                numeric=(numeric*10)+(string.charAt(i)-'0');
            else if(Character.isDigit(string.charAt(i))){
                numeric=(numeric*10)+(string.charAt(i)-'0');
                buildString(character, numeric);
                numeric=0;
            }
        }
        numeric=(numeric*10)+(string.charAt(string.length()-1)-'0'); 
        buildString(character, numeric);               
        return stringBuilder.toString();
    }
    public void buildString(char character, int frequency){
        char[] characters=new char[frequency];
        Arrays.fill(characters, character);
        stringBuilder.append(String.valueOf(characters));
    }
    public static void main(String[] args){
        Scanner sc;
        try{
            sc=new Scanner(System.in);
            System.out.println("Enter String to print characters : ");
            String string=sc.nextLine();
            System.out.println(new CountChars().printCharacters(string));
        }
        catch(Exception e){
            System.out.println("Exception occurred : "+e.getMessage());
            e.printStackTrace();
        }
    }
}
