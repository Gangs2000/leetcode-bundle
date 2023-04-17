import java.util.Scanner;
import java.util.Stack;

public class RemovingStartsFromAString {
    Stack<Character> stack;    
    StringBuilder builder;
    public RemovingStartsFromAString(){
        stack=new Stack<>();      
        builder=new StringBuilder();  
    }
    public String removeStars(String s) {
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='*'){
                stack.pop();     
                builder.deleteCharAt(builder.length()-1);
            }           
            else {
                stack.push(s.charAt(i));                
                builder.append(s.charAt(i));
            }
        }
        return builder.toString();
    }
    public static void main(String[] args){
        Scanner sc;
        try{
            sc=new Scanner(System.in);
            System.out.println("Enter S Value : ");
            String s=sc.next();
            System.out.println(new RemovingStartsFromAString().removeStars(s));
        }   
        catch(Exception e){
            System.out.println("Exception occurred : "+e.getMessage());
            e.printStackTrace();
        }
    }
}
