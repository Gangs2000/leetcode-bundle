package Stack;

import java.util.Scanner;
import java.util.Stack;

public class ValidStackSequence {
    Stack<Integer> stack;
    int pushIndex=0, popIndex=0;
    public ValidStackSequence(){
        stack=new Stack<>();
    }
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        while(pushIndex!=pushed.length){            
            stack.push(pushed[pushIndex]);                                    
            if(pushed[pushIndex]==popped[popIndex]){        
                if(!popElements(popped, pushed.length))
                    return false;                                    
            }            
            pushIndex++;       
        }
        return stack.isEmpty();        
    }
    public boolean popElements(int[] popped, int pushLength){
        while((!stack.isEmpty()) && popIndex!=popped.length){            
            if(stack.peek()==popped[popIndex]){
                stack.pop();
                popIndex++;                                
            }
            else if(pushIndex==pushLength)
                return false;            
            else
                break;
        }
        return true;
    }
    public static void main(String[] args){
        Scanner sc;
        int[] pushed, popped;
        try{
            sc=new Scanner(System.in);
            System.out.println("Enter length of stacks array : ");
            int length=sc.nextInt();
            pushed=new int[length];
            popped=new int[length];
            System.out.println("Enter pushed stack elements : ");
            for(int i=0;i<length;i++)
                pushed[i]=sc.nextInt();
            for(int i=0;i<length;i++)
                popped[i]=sc.nextInt();
            System.out.println(new ValidStackSequence().validateStackSequences(pushed, popped));
        }
        catch(Exception e){
            System.out.println("Exception occurred : "+e.getMessage());
            e.printStackTrace();
        }
    }
}
