package LeetcodeDailyStreaks;

import java.util.List;
import java.util.LinkedList;
import java.util.Scanner;

public class LongestRectangleInHistogram {
    List<Integer> list;
    int largestRectangleArea=0;    
    public LongestRectangleInHistogram(){
        list=new LinkedList<>();
    }    
    public int largestRectangleArea(int[] heights) {
        for(int i=0;i<heights.length;i++){
            for(int j=i;j<heights.length;j++){
                list.add(heights[j]);
                int currentValue=(list.stream().min(Integer::compareTo).get())*list.size();
                if(currentValue>largestRectangleArea)
                    largestRectangleArea=currentValue;
            }                          
            list.clear();
        }
        return largestRectangleArea;   
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
