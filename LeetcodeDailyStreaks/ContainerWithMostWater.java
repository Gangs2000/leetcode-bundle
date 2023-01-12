package LeetcodeDailyStreaks;

import java.util.Scanner;

public class ContainerWithMostWater {
    int mostWater=0;
    public int maxArea(int[] height) {
        int leftPointer=0, rightPointer=height.length-1;
        while(leftPointer!=rightPointer){
            mostWater=Math.max(mostWater, (rightPointer-leftPointer)*(Math.min(height[leftPointer], height[rightPointer])));
            int findShortestPiller=Math.min(height[rightPointer], height[leftPointer]);
            if(findShortestPiller==height[leftPointer])
                leftPointer++;
            else    
                rightPointer--;
        }
        return mostWater;
    }
    public static void main(String[] args){
        Scanner sc;
        int[] heights;
        try{
            sc=new Scanner(System.in);
            System.out.println("Enter length of height array : ");
            int length=sc.nextInt();
            heights=new int[length];
            for(int i=0;i<length;i++)
                heights[i]=sc.nextInt();
            System.out.println(new ContainerWithMostWater().maxArea(heights));
        }
        catch(Exception e){
            System.out.println("Exception occurred : "+e.getMessage());
            e.printStackTrace();
        }
    }
}
