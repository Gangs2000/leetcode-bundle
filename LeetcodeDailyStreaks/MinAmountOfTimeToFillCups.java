package LeetcodeDailyStreaks;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class MinAmountOfTimeToFillCups {
    int count=0;
    PriorityQueue<Integer> priorityQueue;
    public MinAmountOfTimeToFillCups(){
        priorityQueue=new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {  
                if(a==b)
                    return 0;
                return (a>b)?(-1):(1);
            }            
        });
    }
    public int fillCups(int[] amount) {
        for(int i=0;i<amount.length;i++)            
                priorityQueue.add(amount[i]);
        while(priorityQueue.peek()!=0){
            int firstTopMostElement=priorityQueue.poll();
            int secondTopMostElement=priorityQueue.poll();
            priorityQueue.add(firstTopMostElement-1);
            priorityQueue.add(secondTopMostElement-1);
            count++;
        }
        return count;
    }
    public static void main(String[] args){
        Scanner sc;
        int[] amount;
        try{
            sc=new Scanner(System.in);
            System.out.println("Enter length of an amount array : ");
            int length=sc.nextInt();
            amount=new int[length];
            for(int i=0;i<length;i++)
                amount[i]=sc.nextInt();
            System.out.println(new MinAmountOfTimeToFillCups().fillCups(amount));
        }
        catch(Exception e){
            System.out.println("Exception occurred : "+e.getMessage());
            e.printStackTrace();
        }
    }
}
