package LeetcodeDailyStreaks;

import java.util.Scanner;
import java.util.Stack;

public class MaximumNestingDepthOfParanthesis {
    int depth=0, push=0;
    Stack<Character> stack;
    public MaximumNestingDepthOfParanthesis(){
        stack=new Stack<>();
    }
    public int maxDepth(String s) {
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='(' || s.charAt(i)==')'){                
                if(stack.size()==0 || stack.peek()=='(' && s.charAt(i)!=')'){
                    stack.push(s.charAt(i));
                    push++;                          
                }                
                else{
                    if(push>depth)
                        depth=push;
                    stack.pop();                        
                    push--;
                }
            }
        }
        return depth;
    }
    public static void main(String[] args){
        Scanner sc;
        try{
            sc=new Scanner(System.in);
            System.out.println("Enter a String to find depth of valid paranthesis : ");
            String string=sc.nextLine();
            System.out.println(new MaximumNestingDepthOfParanthesis().maxDepth(string));
        }
        catch(Exception e){
            System.out.println("Exception occured : "+e.getMessage());
            e.printStackTrace();
        }
    }
}
