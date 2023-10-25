package LeetcodeDailyStreaks;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class ConstrainedSubsequenceSum {    
    PriorityQueue<List<Integer>> priorityQueue;
    public ConstrainedSubsequenceSum(){
        priorityQueue=new PriorityQueue<>(new Comparator<List<Integer>>() {
            @Override
            public int compare(List<Integer> list1, List<Integer> list2) {                
                if(list1.get(0)==list2.get(0))                    
                    return list2.get(1).compareTo(list1.get(1));
                return list2.get(0).compareTo(list1.get(0));
            }            
        });
    }
    public int constrainedSubsetSum(int[] nums, int k) {
        int result=nums[0];
        int t[]=new int[nums.length];
        for(int i=0;i<nums.length;i++)
            t[i]=nums[i];
        //Putting initial value into the PQ
        priorityQueue.add(List.of(nums[0], 0));
        for(int i=1;i<nums.length;i++){
            while(!priorityQueue.isEmpty() && i-priorityQueue.peek().get(1)>k)
                priorityQueue.poll();
            List<Integer> topQueue=priorityQueue.peek();
            t[i]=Math.max(t[i], nums[i]+topQueue.get(0));
            result=Math.max(result, t[i]);
            priorityQueue.add(List.of(t[i], i));
        }
        return result;
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
            System.out.println(new ConstrainedSubsequenceSum().constrainedSubsetSum(nums, k));
        }
        catch(Exception e){
            System.out.println("Exception occurred : "+e.getMessage());
            e.printStackTrace();
        }
    }
}
