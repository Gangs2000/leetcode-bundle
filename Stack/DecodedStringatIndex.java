package Stack;

import java.util.Scanner;
import java.util.Stack;

public class DecodedStringatIndex {
    Stack<String> stack;
    int index=0;
    public DecodedStringatIndex(){
        stack=new Stack<>();
        stack.push("");
    }
    public String decodeAtIndex(String s, int k) {
        while(stack.peek().length()<k){
            if(Character.isLetter(s.charAt(index)))              
                stack.push(stack.pop()+s.charAt(index));
            else if(Character.isDigit(s.charAt(index))){
                int start=0, end=Integer.valueOf(s.charAt(index));
                String poppedStr=stack.pop(), newString="";
                while(start<(int) end){                  
                    newString+=poppedStr;
                    start++;
                }
                stack.push(newString);
            }
            index++;
        }             
        return String.valueOf(stack.pop().charAt(k-1));
    }
    public static void main(String[] args){
        Scanner sc;
        try{
            sc=new Scanner(System.in);
            System.out.println("Enter S value : ");
            String s=sc.next();
            System.out.println("Enter K value : ");
            int k=sc.nextInt();
            System.out.println(new DecodedStringatIndex().decodeAtIndex(s, k));
        }
        catch(Exception e){
            System.out.println("Exception occurred : "+e.getMessage());
            e.printStackTrace();    
        }
    }
}
