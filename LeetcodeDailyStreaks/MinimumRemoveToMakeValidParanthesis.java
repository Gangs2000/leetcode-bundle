package LeetcodeDailyStreaks;

import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class MinimumRemoveToMakeValidParanthesis {
    Stack<List<Object>> stack;
    StringBuilder stringBuilder;
    int countInvalidParanthesis=0;
    public MinimumRemoveToMakeValidParanthesis(){
        stringBuilder=new StringBuilder();
        stack=new Stack<>();
    }
    public String minRemoveToMakeValid(String s) {        
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='(' || s.charAt(i)==')'){
                if(stack.empty()){
                    if(s.charAt(i)=='('){                        
                        stack.push(List.of(i, s.charAt(i)));
                        stringBuilder.append(s.charAt(i));
                    }
                    else    
                        countInvalidParanthesis++;
                }
                else{
                    if((char) stack.peek().get(1)=='(' && s.charAt(i)==')'){                        
                        stack.pop();
                        stringBuilder.append(s.charAt(i));
                    }
                    else{                        
                        stack.push(List.of(i, s.charAt(i)));
                        stringBuilder.append(s.charAt(i));
                    }
                }
            }   
            else    
                stringBuilder.append(s.charAt(i));
        }
        if(stack.empty())
            return stringBuilder.toString();
        else{            
            while(!stack.empty()){
                int index=(int) stack.pop().get(0);
                stringBuilder.deleteCharAt(index-countInvalidParanthesis);                
            }
            return stringBuilder.toString();
        }
    }
    public static void main(String[] args){
        Scanner sc;
        try{
            sc=new Scanner(System.in);
            System.out.println("Enter a String : ");
            String string=sc.next();
            System.out.println(new MinimumRemoveToMakeValidParanthesis().minRemoveToMakeValid(string));
        }
        catch(Exception e){
            System.out.println("Exception occurred : "+e.getMessage());
            e.printStackTrace();
        }
    }
}
