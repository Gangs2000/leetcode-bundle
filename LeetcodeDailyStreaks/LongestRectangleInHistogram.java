package LeetcodeDailyStreaks;

import java.util.Scanner;
import java.util.Stack;
public class LongestRectangleInHistogram {
    int maxHistogram=0, position=0;
    Stack<Integer> elementStack, positionStack;
    public LongestRectangleInHistogram(){
        elementStack=new Stack<>();
        positionStack=new Stack<>();
    }
    public int largestRectangleArea(int[] heights) {
        for(int i=0;i<heights.length;i++){                          
            if(!elementStack.empty()){
                if(elementStack.peek()>heights[i]){                                        
                    while(!elementStack.empty()){
                        if(elementStack.peek()>heights[i]){
                            maxHistogram=Math.max(maxHistogram, elementStack.pop()*(i-positionStack.pop()));
                            position--;
                        }
                        else
                            break;
                    }                    
                }                
            }  
            elementStack.push(heights[i]);
            positionStack.push(position);
            position++;
        }
        return maxHistogram;
    }        
    public static void main(String[] args){
        Scanner sc;
        int[] heights;   
        try{            
            sc=new Scanner(System.in);            
            System.out.println("Enter length of the list : ");
            int length=sc.nextInt();
            heights=new int[length];
            for(int i=0;i<length;i++)
                heights[i]=sc.nextInt();
            System.out.println(new LongestRectangleInHistogram().largestRectangleArea(heights));            
        }
        catch(Exception e){
            System.out.println("Exception occured : "+e.getMessage());
            e.printStackTrace();
        }
    }
}
