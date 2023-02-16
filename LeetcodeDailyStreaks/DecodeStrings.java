package LeetcodeDailyStreaks;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class DecodeStrings {
    String digit="", chars="", result="";
    Stack<Integer> digitStack;
    Stack<String> alphaStack;
    public DecodeStrings(){
        digitStack=new Stack<>();
        alphaStack=new Stack<>();
    }
    public String decodeString(String s) {
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='[' || s.charAt(i)==']'){
                if(digit.length()!=0){
                    digitStack.push(Integer.valueOf(digit));
                    digit=""; 
                }
                if(chars.length()!=0){
                    alphaStack.push(chars);
                    chars="";
                }
                if(s.charAt(i)==']'){            
                    String[] charArray=new String[digitStack.pop()];
                    Arrays.fill(charArray, alphaStack.pop());                        
                    if(digitStack.size()==0 && alphaStack.size()==0)                        
                        result+=String.join("", charArray);
                    else{                        
                        String peekAlpha=alphaStack.pop();
                        peekAlpha+=String.join("", charArray);
                        alphaStack.push(peekAlpha);                        
                    }
                }
                continue;
            }            
            else{
                if(Character.isDigit(s.charAt(i))){
                    if(chars.length()!=0 && digitStack.size()!=0)
                        alphaStack.push(chars);                        
                    else
                        result+=chars;
                    chars=""; digit+=s.charAt(i);
                }
                else if(Character.isLetter(s.charAt(i))){
                    if(digit.length()!=0){
                        digitStack.push(Integer.valueOf(digit));
                        digit=""; 
                    }
                    chars+=s.charAt(i);
                }
            }
        }    
        if(chars.length()!=0)
            result+=chars;        
        return result.toString();
    }
    public static void main(String[] args){
        Scanner sc;
        try{
            sc=new Scanner(System.in);
            System.out.println("Enter S value : ");
            String s=sc.next();
            System.out.println(new DecodeStrings().decodeString(s));
        }
        catch(Exception e){
            System.out.println("Exception occurred : "+e.getMessage());
            e.printStackTrace();
        }
    }
}
