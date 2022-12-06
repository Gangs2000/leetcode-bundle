package LeetcodeDailyStreaks;

import java.util.Scanner;
import java.util.Stack;

public class BasicCalculator {
    Stack<Integer> stack;
    int number,result,sign;
    public BasicCalculator(){
        stack=new Stack<>();
        number=0; result=0; sign=1;
    }
    public int calculate(String s) {
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)!=' '){
                if(s.charAt(i)=='('){
                    stack.push(result);
                    stack.push(sign);
                    number=0; result=0; sign=1;                    
                }
                else if(s.charAt(i)==')'){                    
                    result=result+(number*sign);
                    number=0;                                   
                    result*=stack.pop();
                    result+=stack.pop();                                                                
                }
                else if(s.charAt(i)=='+' || s.charAt(i)=='-'){                    
                    result=result+(number*sign);
                    number=0; 
                    sign=(s.charAt(i)=='+')?(1):(-1);                    
                }
                else                    
                    number=(number*10)+(s.charAt(i)-'0');
            }
        }        
        return result+(number*sign);
    }
    public static void main(String[] args){
        Scanner sc;
        try{
            sc=new Scanner(System.in);
            System.out.println("Enter an expression to find output value : ");
            String expression=sc.useDelimiter("\n").next();
            System.out.println(new BasicCalculator().calculate(expression));
        }
        catch(Exception e){
            System.out.println("Exception occured : "+e.getMessage());
            e.printStackTrace();
        }
    }
}
