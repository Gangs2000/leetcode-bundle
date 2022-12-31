package LeetcodeDailyStreaks;

import java.util.Comparator;

import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class RelativeRanks {
    String[] result;
    int position=0;
    PriorityQueue<List<Integer>> priorityQueue;
    public RelativeRanks(){        
        priorityQueue=new PriorityQueue<>(new Comparator<List<Integer>>() {
            @Override
            public int compare(List<Integer> list1, List<Integer> list2) {                
                return (list1.get(0)>list2.get(0))?(-1):(1);
            }            
        });
    }
    public String[] findRelativeRanks(int[] score) {
        result=new String[score.length];        
        for(int i=0;i<score.length;i++)
            priorityQueue.add(List.of(score[i], i));                    
        while(!priorityQueue.isEmpty()){
            List<Integer> topper=priorityQueue.poll();
            position++;
            if(position<=3){
                switch(position){
                    case 1 : result[topper.get(1)]="Gold Medal"; break;
                    case 2 : result[topper.get(1)]="Silver Medal"; break;
                    case 3 : result[topper.get(1)]="Bronze Medal"; break;
                }
            }
            else
                result[topper.get(1)]=String.valueOf(position);             
        }            
        return result;
    }
    public static void main(String[] args){
        Scanner sc;
        int[] scores;
        try{
            sc=new Scanner(System.in);
            System.out.println("Enter length of score array : ");
            int length=sc.nextInt();
            scores=new int[length];
            for(int i=0;i<length;i++)
                scores[i]=sc.nextInt();
            System.out.println(new RelativeRanks().findRelativeRanks(scores));
        }
        catch(Exception e){
            System.out.println("Exception occurred : ");
            e.printStackTrace();
        }
    }
}
