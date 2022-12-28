package LeetcodeDailyStreaks;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class RemoveStonesToMinimizeTotal {
    PriorityQueue<Integer> priorityQueue;    
    public RemoveStonesToMinimizeTotal(){
        priorityQueue=new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {        
            if(a==b)
                return 0;
            return (a>b)?(-1):(1);
            }
        });
    }        
    public int minStoneSum(int[] piles, int k) {           
        int sum=sumOfArray(piles);         
        for(int i=0;i<k;i++){
            int peekElement=priorityQueue.poll();            
            int remove=peekElement/2;
            sum-=remove;            
            peekElement-=remove;
            priorityQueue.add(peekElement);
        }
        return sum;
    }    
    public int sumOfArray(int[] piles){
        int sum=0;
        for(int i=0;i<piles.length;i++){ 
            priorityQueue.add(piles[i]);
            sum+=piles[i];
        }
        return sum;
    }
        
    public static void main(String[] args){
        Scanner sc;
        int[] piles;
        try{
            sc=new Scanner(System.in);
            System.out.println("Enter length of piles array : ");
            int length=sc.nextInt();
            piles=new int[length];
            for(int i=0;i<length;i++)
                piles[i]=sc.nextInt();
            System.out.println("Enter number of times operations to be performed : ");
            int k=sc.nextInt();
            System.out.println(new RemoveStonesToMinimizeTotal().minStoneSum(piles, k));
        }
        catch(Exception e){
            System.out.println("Exception occurred : "+e.getMessage());
            e.printStackTrace();
        }
    }    
}
