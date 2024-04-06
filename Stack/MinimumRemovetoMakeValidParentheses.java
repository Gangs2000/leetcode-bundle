import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class MinimumRemovetoMakeValidParentheses {
    Stack<List<Object>> stack;
    public MinimumRemovetoMakeValidParentheses(){
        stack=new Stack<>();
    }
    public String minRemoveToMakeValid(String s) {
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='(' || s.charAt(i)==')'){
                if(stack.isEmpty())
                    stack.push(Arrays.asList(i, s.charAt(i)));
                else{
                    if((char) stack.peek().get(1)=='(' && s.charAt(i)==')')
                        stack.pop();
                    else
                        stack.push(Arrays.asList(i, s.charAt(i)));
                }
            }
        }
        return (stack.empty())?(s):(this.buildValidString(stack, s));
    }
    public String buildValidString(Stack<List<Object>> stack, String s){
        StringBuilder builder=new StringBuilder();
        for(int i=s.length()-1;i>=0;i--){
            if(!stack.empty() && (int) stack.peek().get(0)==i)
                stack.pop();
            else
                builder.append(s.charAt(i));
        }
        return builder.reverse().toString();
    }
    public static void main(String[] args) {
        Scanner sc;
        try {
            sc=new Scanner(System.in);
            System.out.println("Enter S value : ");
            String s=sc.next();
            System.out.println(new MinimumRemovetoMakeValidParentheses().minRemoveToMakeValid(s));
            sc.close();
        } 
        catch (Exception e) {
            System.out.println("Exception occurred : "+e.getMessage());
            e.printStackTrace();
        }
    }
}
