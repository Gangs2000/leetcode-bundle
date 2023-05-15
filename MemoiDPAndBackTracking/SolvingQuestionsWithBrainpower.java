package MemoiDPAndBackTracking;

import java.util.Arrays;
import java.util.Scanner;

public class SolvingQuestionsWithBrainpower {    
    long[] cache;
    public SolvingQuestionsWithBrainpower(){
        cache=new long[100006];
    }
    public long mostPoints(int[][] questions) {
        Arrays.fill(cache, -1);
        return getMaxPoints(questions, 0, cache);
    }
    public long getMaxPoints(int[][] questions, int index, long[] cache){
        if(index>=questions.length)
            return 0;        
        if(cache[index]!=-1)
            return cache[index];        
        return cache[index]=Math.max(questions[index][0]+getMaxPoints(questions, index+questions[index][1]+1, cache), getMaxPoints(questions, index+1, cache));
    }
    public static void main(String[] args){
        Scanner sc;
        int[][] questions;
        try{
            sc=new Scanner(System.in);
            System.out.println("Enter length questions array : ");
            int length=sc.nextInt();
            questions=new int[length][2];
            for(int i=0;i<length;i++){
                questions[i][0]=sc.nextInt();
                questions[i][1]=sc.nextInt();
            }
            System.out.println(new SolvingQuestionsWithBrainpower().mostPoints(questions));
        }
        catch(Exception e){
            System.out.println("Exception occurred : "+e.getMessage());
            e.printStackTrace();
        }
    }
}
