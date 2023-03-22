package LeetcodeDailyStreaks;

import java.util.Scanner;
import java.util.Stack;

public class RemoveOuterMostParantheses {
    String outputString="", tempString="";
    Stack<Character> stack;
    public RemoveOuterMostParantheses(){
        stack=new Stack<>();
    }
    public String removeOuterParentheses(String s) {
        for(int i=0;i<s.length();i++){
            if(stack.empty())
                stack.push(s.charAt(i));
            else{
                if(stack.peek()=='(' && s.charAt(i)==')')
                    stack.pop();
                else
                    stack.push(s.charAt(i));
            }
            tempString+=s.charAt(i);
            if(stack.isEmpty()){
                outputString+=tempString.substring(1, tempString.length()-1);                
                tempString="";
            }
        }
        return outputString;
    }
    public static void main(String[] args){
        Scanner sc;
        try{
            sc=new Scanner(System.in);
            System.out.println("Enter S value : ");
            String s=sc.next();
            System.out.println(new RemoveOuterMostParantheses().removeOuterParentheses(s));
        }
        catch(Exception e){
            System.out.println("Exception occurred : "+e.getMessage());
            e.printStackTrace();
        }
    }    
}
