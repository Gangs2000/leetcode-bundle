package LeetcodeDailyStreaks;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class MaxProdAfterKIncrement {
    PriorityQueue<Integer> queue;    
    public MaxProdAfterKIncrement(){
        queue=new PriorityQueue<>();
    }
    public int maximumProduct(int[] nums, int k) {
        Arrays.stream(nums).forEach(element->queue.add(element));
        while(k!=0){
            int getLeastElement=queue.poll();
            getLeastElement++; k--;
            queue.add(getLeastElement);
        }                
        return (queue.stream().reduce((a,b)-> (a*b)).get())%1000000007;        
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
            System.out.println("Enter K value : ");
            int k=sc.nextInt();
            System.out.println(new MaxProdAfterKIncrement().maximumProduct(nums, k));
        }
        catch(Exception e){
            System.out.println("Exception occurred : "+e.getMessage());
            e.printStackTrace();
        }
    }
}
