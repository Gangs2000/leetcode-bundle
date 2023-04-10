package LeetcodeDailyStreaks;

import java.util.Arrays;
import java.util.Scanner;

public class BoatsToSavePeople {
    int requiredBoats=0;
    public int numRescueBoats(int[] people, int limit) {       
        Arrays.sort(people);
        int leftPointer=0, rightPointer=people.length-1;
        while(leftPointer<=rightPointer){
            if(people[leftPointer]+people[rightPointer]<=limit){
                leftPointer++;
                rightPointer--;
            }
            else
                rightPointer--;
            requiredBoats++;
        }        
        return requiredBoats;
    }
    public static void main(String[] args){
        Scanner sc;
        int[] people;
        try{
            sc=new Scanner(System.in);
            System.out.println("Enter length of people array : ");
            int length=sc.nextInt();
            people=new int[length];
            for(int i=0;i<length;i++)
                people[i]=sc.nextInt();
            System.out.println("Enter limit value : ");
            int limit=sc.nextInt();
            System.out.println(new BoatsToSavePeople().numRescueBoats(people, limit));   
        }
        catch(Exception e){
            System.out.println("Exception occurred : "+e.getMessage());
            e.printStackTrace();
        }
    }
}
