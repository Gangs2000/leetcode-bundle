package LeetcodeDailyStreaks;

import java.util.Scanner;
import java.util.Stack;

public class ValidParanthesis {
    Stack<Character> stack;
    public ValidParanthesis(){
        stack=new Stack<>();
    }
    public boolean isValid(String s){
        boolean flag=true;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='(' || s.charAt(i)=='{' || s.charAt(i)=='[')
                stack.push(s.charAt(i));
            else{  
                char currentChar=s.charAt(i);
                if(stack.size()==0 || (currentChar==')' && stack.peek()!='(') || ((currentChar=='}' && stack.peek()!='{')) || ((currentChar==']' && stack.peek()!='['))){
                    flag=false;
                    break;
                }                                
                stack.pop();                
            }
        }
        return (stack.size()==0 && flag)?(true):(false);
    }
    public static void main(String[] args){
        Scanner sc;
        try{
            sc=new Scanner(System.in);
            System.out.println("Enter a String to find valid paranthesis or not : ");
            String string=sc.nextLine();
            System.out.println(new ValidParanthesis().isValid(string));
        }
        catch(Exception e){
            System.out.println("Exception occured : "+e.getMessage());
            e.printStackTrace();
        }
    }   
}
