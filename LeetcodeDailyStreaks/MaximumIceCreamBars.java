package LeetcodeDailyStreaks;

import java.util.Scanner;
import java.util.Arrays;

public class MaximumIceCreamBars {
    int maximumCount=0;
    public int maxIceCream(int[] costs, int coins) {
        Arrays.sort(costs);
        for(int i=0;i<costs.length;i++){
            if(coins<costs[i])
                return maximumCount;
            maximumCount=Math.max(maximumCount, maximumCount+1);
            coins-=costs[i];
        }
        return maximumCount;
    }
    public static void main(String[] args){
        Scanner sc;
        int[] costs;
        try{
            sc=new Scanner(System.in);
            System.out.println("Enter length of costs array : ");
            int length=sc.nextInt();
            costs=new int[length];
            System.out.println("Enter coins value : ");
            int coins=sc.nextInt();
            System.out.println(new MaximumIceCreamBars().maxIceCream(costs, coins));
        }
        catch(Exception e){
            System.out.println("Exception occurred : "+e.getMessage());
            e.printStackTrace();
        }
    }
}
