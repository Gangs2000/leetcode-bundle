import java.util.Scanner;
import java.util.Stack;

public class MakeTheStringGreat {
    Stack<Character> stack;
    public MakeTheStringGreat(){
        stack=new Stack<>();
    }
    public String makeGood(String s) {
        if(s.length()==1)
            return s;
        for(int i=0;i<s.length();i++){
            if(stack.empty())
                stack.push(s.charAt(i));
            else{
                char topElement=stack.peek(); 
                boolean isUpper=Character.isUpperCase(topElement);
                if(isUpper && Character.isLowerCase(s.charAt(i)) && topElement==Character.toUpperCase(s.charAt(i)))
                    stack.pop();
                else if(!isUpper && Character.isUpperCase(s.charAt(i)) && topElement==Character.toLowerCase(s.charAt(i)))
                    stack.pop();
                else
                    stack.push(s.charAt(i));
            }
        }
        return (stack.isEmpty())?(""):(stack.stream().map(character-> Character.toString(character)).reduce((a,b)->(a+b)).get());
    }
    public static void main(String[] args) {
        Scanner sc;
        try{
            sc=new Scanner(System.in);
            System.out.println("Enter S value : ");
            String s=sc.next();
            System.out.println(new MakeTheStringGreat().makeGood(s));
            sc.close();
        }
        catch(Exception e){
            System.out.println("Exception occurred : "+e.getMessage());
            e.printStackTrace();
        }
    }
}
