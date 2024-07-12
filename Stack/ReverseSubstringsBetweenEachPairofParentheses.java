import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class ReverseSubstringsBetweenEachPairofParentheses {
    Stack<List<Object>> stack;
    public ReverseSubstringsBetweenEachPairofParentheses(){
        stack=new Stack<>();
    }
    public String reverseParentheses(String s) {
        StringBuilder resultStr=new StringBuilder(s);
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='(')
                stack.push(Arrays.asList(i, '('));
            else if(s.charAt(i)==')'){
                int startIndex=((int) stack.pop().get(0))+1;
                int endIndex=i;
                StringBuilder reversedStr=new StringBuilder(resultStr.substring(startIndex, endIndex)).reverse();
                resultStr.replace(startIndex, endIndex, reversedStr.toString());
            }
        }
        //Replace ( and ) with empty element for getting final result value
        String finalResult=resultStr.toString().replace("(", "").replace(")", "");
        return finalResult;
    }
    public static void main(String[] args) {
        Scanner sc;
        try {
            sc=new Scanner(System.in);
            System.out.println("Enter S value : ");
            String s=sc.nextLine();
            System.out.println(new ReverseSubstringsBetweenEachPairofParentheses().reverseParentheses(s));
            sc.close();
        } 
        catch (Exception e) {
            System.out.println("Exception occurred : "+e.getMessage());
            e.printStackTrace();
        }
    }
}
