package LeetcodeDailyStreaks;

import java.util.Scanner;

public class WateringPlantsII {
    int noOfTimeToBeRefilled=0;
    public int minimumRefill(int[] plants, int capacityA, int capacityB) {
        int leftPointer=0, rightPointer=plants.length-1, aliceTank=capacityA, bobTank=capacityB;
        while(leftPointer<=rightPointer){           
            if(leftPointer==rightPointer){
                if((Math.max(capacityA, capacityB)<plants[rightPointer]))
                    noOfTimeToBeRefilled++;                    
            }                 
            else{
                //Alice watering the plant..
                if(plants[leftPointer]<=capacityA)
                    capacityA-=plants[leftPointer];
                else{
                    capacityA=aliceTank;
                    capacityA-=plants[leftPointer];
                    noOfTimeToBeRefilled++;
                }
                //Bob watering the plant..
                if(plants[rightPointer]<=capacityB)
                    capacityB-=plants[rightPointer];
                else{
                    capacityB=bobTank;
                    capacityB-=plants[rightPointer];
                    noOfTimeToBeRefilled++;
                }
            }            
            leftPointer++; rightPointer--;
        }
        return noOfTimeToBeRefilled;
    }    
    public static void main(String[] args){
        Scanner sc;
        int[] plants;
        try{
            sc=new Scanner(System.in);
            System.out.println("Enter length of plants array : ");
            int length=sc.nextInt();
            plants=new int[length];
            for(int i=0;i<length;i++)
                plants[i]=sc.nextInt();
            System.out.println("Enter Alice and Bob's water capacity values : ");
            int capacityA=sc.nextInt();
            int capacityB=sc.nextInt();
            System.out.println(new WateringPlantsII().minimumRefill(plants, capacityA, capacityB));
        }   
        catch(Exception e){
            System.out.println("Exception occurred : "+e.getMessage());
            e.printStackTrace();
        }
    }
}
