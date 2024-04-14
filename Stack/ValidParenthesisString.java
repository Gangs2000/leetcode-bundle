import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class ValidParenthesisString {
    Stack<List<Object>> stack, starStack;
    public ValidParenthesisString(){
        stack=new Stack<>();
        starStack=new Stack<>();
    }
    public boolean checkValidString(String s) {
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='(')
                stack.push(Arrays.asList('(', i));
            else if(s.charAt(i)==')'){
                if(!stack.isEmpty() && (char) stack.peek().get(0)=='(')
                    stack.pop();
                else if(stack.isEmpty()){
                    if(starStack.isEmpty())
                        return false;
                    else
                        starStack.pop();
                }
            }
            else if(s.charAt(i)=='*')
                starStack.push(Arrays.asList('*', i));
        }
        while(!stack.isEmpty()){
            if(starStack.isEmpty())
                return false;
            if((int) stack.peek().get(1) < (int) starStack.peek().get(1)){
                stack.pop();
                starStack.pop();
            }
            else
                return false;
        }
        return stack.isEmpty();
    }
    public static void main(String[] args) {
        Scanner sc;
        try{
            sc=new Scanner(System.in);
            System.out.println("Enter String to verify if given is valid paranthesis : ");
            String s=sc.next();
            System.out.println(new ValidParenthesisString().checkValidString(s));
            sc.close();
        }
        catch(Exception e){
            System.out.println("Exception occurred : "+e.getMessage());
            e.printStackTrace();
        }
    }
}
