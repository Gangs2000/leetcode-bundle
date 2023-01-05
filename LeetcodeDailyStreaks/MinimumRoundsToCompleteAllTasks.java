package LeetcodeDailyStreaks;

import java.util.Arrays;
import java.util.Scanner;

public class MinimumRoundsToCompleteAllTasks {
    int minimumCount=0, count=1;
    public int minimumRounds(int[] tasks) {
        Arrays.sort(tasks);
        for(int i=0;i<tasks.length-1;i++){
            if(tasks[i]==tasks[i+1])
                count++;
            else{
                if(count==1)
                    return -1;
                countMinimum(count);
                count=1;
            }
        }
        if(count==1)
            return -1;
        countMinimum(count);
        return minimumCount;
    }
    public void countMinimum(int count){
        if(count==2 || count==3)
            minimumCount+=1;
        else if(count==4)
            minimumCount+=2;
        else{
            switch(count%3){
                case 0 : minimumCount+=count/3; break;
                case 1 : minimumCount+=((count-4)/3)+2; break;
                case 2 : minimumCount+=((count-2)/3)+1; break;
            }            
        }
    }
    public static void main(String[] args){
        Scanner sc;
        int[] tasks;
        try{
            sc=new Scanner(System.in);
            System.out.println("Enter length of tasks array : ");
            int length=sc.nextInt();
            tasks=new int[length];
            for(int i=0;i<length;i++)
                tasks[i]=sc.nextInt();
            System.out.println(new MinimumRoundsToCompleteAllTasks().minimumRounds(tasks));
        }
        catch(Exception e){
            System.out.println("Exception occurred : "+e.getMessage());
            e.printStackTrace();
        }
    }
}
