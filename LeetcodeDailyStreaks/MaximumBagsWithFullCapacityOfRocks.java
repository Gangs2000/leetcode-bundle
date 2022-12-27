package LeetcodeDailyStreaks;

import java.util.Arrays;
import java.util.Scanner;

public class MaximumBagsWithFullCapacityOfRocks {
    int count=0;
    public int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {
        Arrays.sort(rocks);
        for(int i=0;i<capacity.length;i++)
            rocks[i]=capacity[i]-rocks[i];
        Arrays.sort(rocks);                
        for(int i=0;i<rocks.length;i++){
            if(rocks[i]==0)                
                count++;
            else if(rocks[i]<=additionalRocks){                
                count++;
                additionalRocks-=rocks[i];                
            }
        }
        return count;        
    }
    public static void main(String[] args){
        Scanner sc;
        int[] capacity, rocks;
        try{
            sc=new Scanner(System.in);
            System.out.println("Enter length of capacity and rocks array : ");
            int length=sc.nextInt();
            capacity=new int[length];
            rocks=new int[length];
            for(int i=0;i<length;i++){
                System.out.println("Enter capacity value of "+(i+1)+" : ");
                capacity[i]=sc.nextInt();
                System.out.println("Enter rock value of "+(i+1)+" : ");
                rocks[i]=sc.nextInt();
            }
            System.out.println("Enter additional rocks value : ");
            int additionalRocks=sc.nextInt();
            System.out.println(new MaximumBagsWithFullCapacityOfRocks().maximumBags(capacity, rocks, additionalRocks));
        }
        catch(Exception e){
            System.out.println("Exception occurred : "+e.getMessage());
            e.printStackTrace();
        }
    }
}
