package LeetcodeDailyStreaks;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class LongestSubarrayof1AfterDeletingOneElement {
    int longesCount=0;
    PriorityQueue<List<Integer>> priorityQueue;
    public LongestSubarrayof1AfterDeletingOneElement(){
        priorityQueue=new PriorityQueue<>(new Comparator<List<Integer>>() {
            @Override
            public int compare(List<Integer> arg0, List<Integer> arg1) {
                return arg0.get(0).compareTo(arg1.get(0));
            }
        });
    }
    public int longestSubarray(int[] nums) {
        int pointer=-1;
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=0){
                if(pointer==-1)
                    pointer=i;                
            }
            else if(nums[i]==0 && pointer!=-1){
                priorityQueue.add(List.of(pointer, i));
                pointer=-1;
            }
        }
        if(pointer!=-1)
            priorityQueue.add(List.of(pointer, nums.length));
        if(priorityQueue.size()==1){
            List<Integer> peekList=priorityQueue.poll();
            if((peekList.get(1)-peekList.get(0))==nums.length)
                return nums.length-1;
        }
        while(!priorityQueue.isEmpty()){            
            List<Integer> peekList=priorityQueue.poll();
            longesCount=Math.max(longesCount, peekList.get(1)-peekList.get(0));
            if(priorityQueue.size()!=0){
                List<Integer> nextPeekList=priorityQueue.peek();
                if((nextPeekList.get(0)-peekList.get(1))==1){             
                    int sum=(peekList.get(1)-peekList.get(0))+(nextPeekList.get(1)-nextPeekList.get(0));
                    longesCount=Math.max(longesCount, sum);
                }
            }
        }            
        return longesCount;
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
            System.out.println(new LongestSubarrayof1AfterDeletingOneElement().longestSubarray(nums));
        }
        catch(Exception e){
            System.out.println("Exception occurred : "+e.getMessage());
            e.printStackTrace();
        }
    }
}
