package LeetcodeDailyStreaks;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class LastStoneWeight {
    PriorityQueue<Integer> priorityQueue;
    public LastStoneWeight(){
        priorityQueue=new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                if(a==b)
                    return 0;                
                return (a>b)?(-1):(1);
            }            
        });
    }
    public int lastStoneWeight(int[] stones) {
        for(int i=0;i<stones.length;i++)
            priorityQueue.add(stones[i]);
        while(priorityQueue.size()>1){
            int firstTop=priorityQueue.poll();
            int secondTop=priorityQueue.poll();
            if(firstTop!=secondTop)
                priorityQueue.add(firstTop-secondTop);
        }
        return (priorityQueue.isEmpty())?(0):(priorityQueue.peek());        
    }
    public static void main(String[] args){
        Scanner sc;
        int[] stones;
        try{
            sc=new Scanner(System.in);
            System.out.println("Enter length of stones array : ");
            int length=sc.nextInt();
            stones=new int[length];
            for(int i=0;i<length;i++)
                stones[i]=sc.nextInt();
            System.out.println(new LastStoneWeight().lastStoneWeight(stones));
        }
        catch(Exception e){
            System.out.println("Exception occurred : "+e.getMessage());
            e.printStackTrace();
        }
    }
}
