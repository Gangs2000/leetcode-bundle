package LeetcodeDailyStreaks;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class MaximumProductOfTwoElementsInArray {
    PriorityQueue<Integer> priorityQueue;
    public MaximumProductOfTwoElementsInArray(){
        priorityQueue=new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                if(a==b)                
                    return 0;
                return (a>b)?(-1):(1);
            }            
        });
    }
    public int maxProduct(int[] nums) {
        for(int i=0;i<nums.length;i++)
            priorityQueue.add(nums[i]);
        return (priorityQueue.poll()-1)*(priorityQueue.poll()-1);
    }
    public static void main(String[] args){
        Scanner sc;
        int[] nums;
        try{
            sc=new Scanner(System.in);
            System.out.println("Enter length of nums array : ");
            int length=sc.nextInt();
            nums=new int[length];
            for(int i=0;i<length;i++)
                nums[i]=sc.nextInt();
            System.out.println(new MaximumProductOfTwoElementsInArray().maxProduct(nums));
        }
        catch(Exception e){
            System.out.println("Exception occurred : "+e.getMessage());
            e.printStackTrace();
        }
    }
}
