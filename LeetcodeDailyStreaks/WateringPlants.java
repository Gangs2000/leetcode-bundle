package LeetcodeDailyStreaks;

import java.util.Scanner;

public class WateringPlants {
    int steps=0;
    public int wateringPlants(int[] plants, int capacity) {
        int refill=capacity;
        for(int i=0;i<plants.length;i++){
            if(plants[i]<=capacity){
                steps++;
                capacity-=plants[i];
            }
            else{
                steps+=((i-1)-(-1));                //Going backward to river located at -1                
                capacity=refill-plants[i];          //Watering the plant
                steps+=(i-(-1));                    //Returning back to current index 
            }            
        }
        return steps;
    }
    public static void main(String[] args){
        Scanner sc;
        int[] plants;
        try{
            sc=new Scanner(System.in);
            System.out.println("Enter length of water plants : ");
            int length=sc.nextInt();
            plants=new int[length];
            for(int i=0;i<length;i++)
                plants[i]=sc.nextInt();
            System.out.println("Enter water tank capacity : ");
            int capacity=sc.nextInt();
            System.out.println(new WateringPlants().wateringPlants(plants, capacity));
        }
        catch(Exception e){
            System.out.println("Exception occurred : "+e.getMessage());
            e.printStackTrace();
        }
    }
}