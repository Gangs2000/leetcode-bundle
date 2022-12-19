package LeetcodeDailyStreaks;

import java.util.Stack;

public class ReversePolishNotation {
    Stack<Integer> stack;
    public ReversePolishNotation(){
        stack=new Stack<>();
    }
    public int evalRPN(String[] tokens) {
        for(int i=0;i<tokens.length;i++){            
            if(tokens[i].equals("+") || tokens[i].equals("-") || tokens[i].equals("*") || tokens[i].equals("/")){
                int operand1=stack.pop();
                int operand2=stack.pop();                    
                if(tokens[i].equals("+"))
                    stack.push(operand2+operand1);
                else if(tokens[i].equals("-"))
                    stack.push(operand2-operand1);
                else if(tokens[i].equals("*"))
                    stack.push(operand2*operand1);
                else if(tokens[i].equals("/")){                    
                    stack.push(operand2/operand1);
                }
            }
            else
                stack.push(Integer.valueOf(tokens[i]));
            System.out.println(stack);
        }
        return stack.peek();
    }
    public static void main(String[] args){
        String[] tokens;
        try{            
            tokens=new String[]{"2","1","+","3","*"};
            System.out.println(new ReversePolishNotation().evalRPN(tokens));
        }
        catch(Exception e){
            System.out.println("Exception occurred : "+e.getMessage());
            e.printStackTrace();
        }
    }
}
