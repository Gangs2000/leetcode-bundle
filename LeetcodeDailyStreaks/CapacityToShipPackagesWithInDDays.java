package LeetcodeDailyStreaks;

import java.util.Scanner;

public class CapacityToShipPackagesWithInDDays {    
    public int shipWithinDays(int[] weights, int days) {
        int lowerBound=Integer.MIN_VALUE, upperBound=0;
        for(int weight : weights){
            lowerBound=Math.max(lowerBound, weight);
            upperBound+=weight;
        }
        int minCapacity=upperBound;
        //Simple binary search
        while(lowerBound<=upperBound){
            int capacity=(lowerBound+upperBound)/2;
            if(canBefitToShip(weights, capacity, days)){
                minCapacity=Math.min(minCapacity, capacity);
                upperBound=capacity-1;
            }
            else
                lowerBound=capacity+1;
        }
        return minCapacity;
    }
    public boolean canBefitToShip(int[] weights, int capacity, int days){
        int ships=1, currentCapacity=capacity;
        for(int weight : weights){
            while(currentCapacity-weight<0){
                ships++;
                currentCapacity=capacity;
            }
            currentCapacity-=weight;
        }
        return ships<=days;
    }
    public static void main(String[] args){
        Scanner sc;
        int[] weights;
        try{
            sc=new Scanner(System.in);
            System.out.println("Enter length of weights array : ");
            int length=sc.nextInt();
            weights=new int[length];
            for(int i=0;i<length;i++)
                weights[i]=sc.nextInt();
            System.out.println("Enter number of days : ");
            int days=sc.nextInt();
            System.out.println(new CapacityToShipPackagesWithInDDays().shipWithinDays(weights, days));
        }
        catch(Exception e){
            System.out.println("Exception occurred : "+e.getMessage());
            e.printStackTrace();
        }
    }
}
