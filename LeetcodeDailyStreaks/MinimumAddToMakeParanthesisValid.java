package LeetcodeDailyStreaks;

import java.util.Scanner;
import java.util.Stack;

public class MinimumAddToMakeParanthesisValid {
    Stack<Character> stack;
    public MinimumAddToMakeParanthesisValid(){
        stack=new Stack<>();
    }
    public int minAddToMakeValid(String s) {
        for(int i=0;i<s.length();i++){
            if(stack.empty())
                stack.push(s.charAt(i));
            else{
                if(stack.peek()=='(' && s.charAt(i)==')')
                    stack.pop();
                else
                    stack.push(s.charAt(i));
            }
        }
        return stack.size();
    }
    public static void main(String[] args){
        Scanner sc;
        try{
            sc=new Scanner(System.in);
            System.out.println("Enter a String to find out minimum add to make parathesis valid : ");
            String string=sc.next();
            System.out.println(new MinimumAddToMakeParanthesisValid().minAddToMakeValid(string));
        }
        catch(Exception e){
            System.out.println("Exception occurred : "+e.getMessage());
            e.printStackTrace();
        }
    }
}
