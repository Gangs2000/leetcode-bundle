package LeetcodeDailyStreaks;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class RemoveInvalidParanthesis {
    List<String> validParanthesisList;
    Stack<Character> stackBrackets;
    public RemoveInvalidParanthesis(){
        validParanthesisList=new LinkedList<>();
        stackBrackets=new Stack<>();
    }
    public List<String> removeInvalidParentheses(String s) {
        String tempString=s;        
        for(int i=0;i<s.length();i++){            
            StringBuilder stringBuilder=new StringBuilder(tempString);
            if(stringBuilder.length()>2){
                if(stringBuilder.charAt(i)=='(' || stringBuilder.charAt(i)==')')
                    stringBuilder.deleteCharAt(i);    
                //Core Logic condition             
                if(this.isValidStack(stringBuilder.toString()) && !validParanthesisList.contains(stringBuilder.toString()))                
                    validParanthesisList.add(stringBuilder.toString());   
            }
            else if(stringBuilder.length()==2 || (stringBuilder.length()==1)){
                if(this.isValidStack(stringBuilder.toString()) && !validParanthesisList.contains(stringBuilder.toString()))                
                    validParanthesisList.add(stringBuilder.toString());               
            }            
            tempString=s; stackBrackets.clear();
        }
        //If Valid paranthesis list is empty then add chars to list..        
        if(validParanthesisList.size()==0){
            for(int i=0;i<s.length();i++){
                if(s.charAt(i)!='(' && s.charAt(i)!=')'){
                    if(!validParanthesisList.contains(String.valueOf(s.charAt(i))))
                        validParanthesisList.add(String.valueOf(s.charAt(i)));
                }
            }
        }
        //If Valid paranthesis is empty even after checking chars then add "" space
        if(validParanthesisList.size()==0)
            validParanthesisList.add("");
        return validParanthesisList;
    }
    public boolean isValidStack(String string){
        boolean flag=true;               
        for(int i=0;i<string.length();i++){
            if(string.charAt(i)=='(' || string.charAt(i)==')'){
                if(string.charAt(i)=='(')
                    stackBrackets.push(string.charAt(i));
                else{
                    if(stackBrackets.size()==0 || (stackBrackets.peek()!='(')){
                        flag=false;                                  
                        break;
                    }
                    else
                        stackBrackets.pop();
                }                
            }            
        }            
        return (stackBrackets.empty() && flag)?(true):(false);
    }
    public static void main(String[] args){
        Scanner sc;
        try{
            sc=new Scanner(System.in);
            System.out.println("Enter a String to find out valid paranthesis list : ");
            String string=sc.nextLine();
            System.out.println(new RemoveInvalidParanthesis().removeInvalidParentheses(string));
        }
        catch(Exception e){
            System.out.println("Exception occured : "+e.getMessage());
            e.printStackTrace();
        }
    }
}
