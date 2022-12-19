package LeetcodeDailyStreaks;

import java.util.Scanner;
import java.util.Stack;

public class DailyTempratures {
    Stack<Integer> stack;
    public DailyTempratures(){
        stack=new Stack<>();
    }
    public int[] dailyTemperatures(int[] temperatures) {
        int[] output=new int[temperatures.length];
        for(int i=output.length-1;i>=0;i--){
            if(stack.empty())
                output[i]=0;                
            else{
                if(temperatures[stack.peek()]>temperatures[i])
                    output[i]=stack.peek()-i;                    
                else if(temperatures[stack.peek()]<=temperatures[i]){
                    while(temperatures[stack.peek()]<=temperatures[i]){
                        stack.pop();
                        if(stack.empty())                            
                            break;
                    }
                    output[i]=(stack.empty())?(0):(stack.peek()-i);                    
                }                    
            }      
            stack.push(i);      
        }        
        return output;
    }
    public static void main(String[] args){
        Scanner sc;
        int[] tempratures;
        try{
            sc=new Scanner(System.in);
            System.out.println("Enter length of an array : ");
            int length=sc.nextInt();
            tempratures=new int[length];
            for(int i=0;i<length;i++)   
                tempratures[i]=sc.nextInt();
            System.out.println(new DailyTempratures().dailyTemperatures(tempratures));
        }
        catch(Exception e){
            System.out.println("Exception occured : "+e.getMessage());
            e.printStackTrace();
        }
    }
}
