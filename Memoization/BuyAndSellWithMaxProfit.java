package Memoization;

import java.util.Scanner;

public class BuyAndSellWithMaxProfit {    
    public int maxProfit(int[] prices) {        
        int minimumCost=prices[0], profit=0;
        for(int i=1;i<prices.length;i++){
            int cost=prices[i]-minimumCost;
            profit=Math.max(profit, cost);
            minimumCost=Math.min(minimumCost, prices[i]);
        }
        return profit;
    }    
    public static void main(String[] args){
        Scanner sc;
        int[] prices;
        try{
            sc=new Scanner(System.in);
            System.out.println("Enter N value : ");
            int length=sc.nextInt();
            prices=new int[length];
            for(int i=0;i<length;i++)
                prices[i]=sc.nextInt();
            System.out.println(new BuyAndSellWithMaxProfit().maxProfit(prices));   
        }
        catch(Exception e){
            System.out.println("Exception occurred : "+e.getMessage());
            e.printStackTrace();
        }
    }
}
