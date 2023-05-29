package LeetcodeDailyStreaks;

import java.util.PriorityQueue;
import java.util.Scanner;

public class KthLargestElementInArray {
    PriorityQueue<Integer> priorityQueue;
    public KthLargestElementInArray(){
        priorityQueue=new PriorityQueue<>();
    }
    public int findKthLargest(int[] nums, int k) {
        for(int i=0;i<nums.length;i++)
            priorityQueue.offer(nums[i]);
        while(priorityQueue.size()>k)
            priorityQueue.remove();
        return priorityQueue.peek();        
    }
    public static void main(String[] args){
        Scanner sc;
        int[] nums;
        try{
            sc=new Scanner(System.in);
            System.out.println("Enter length of an array : ");
            int length=sc.nextInt();
            nums=new int[length];
            for(int i=0;i<length;i++)
                nums[i]=sc.nextInt();
            System.out.println("Enter K value : ");
            int k=sc.nextInt();
            System.out.println(new KthLargestElementInArray().findKthLargest(nums, k));
        }
        catch(Exception e){
            System.out.println("Exception occurred : "+e.getMessage());
            e.printStackTrace();
        }
    }
}
