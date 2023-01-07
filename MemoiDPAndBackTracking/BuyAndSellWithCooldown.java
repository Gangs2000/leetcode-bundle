package MemoiDPAndBackTracking;

import java.util.Scanner;

public class BuyAndSellWithCooldown {
    int[][] cache;
    public BuyAndSellWithCooldown(){
        cache=new int[5001][2];
    }
    public int maxProfit(int[] prices) {
        return findMaxProfit(prices, 0, prices.length, 1);
    }
    private int findMaxProfit(int[] prices, int day, int lastDay, int buy) {
        if(day>=lastDay)
            return 0;
        if(cache[day][buy]!=0)
            return cache[day][buy];
        int profit=0;
        if(buy==1){
            int buying=findMaxProfit(prices, day+1, lastDay, 0)-prices[day];
            int notBuying=findMaxProfit(prices, day+1, lastDay, 1);
            profit=Math.max(profit, Math.max(buying, notBuying));
        }
        else if(buy==0){
            int selling=prices[day]+findMaxProfit(prices, day+2, lastDay, 1);
            int notSelling=findMaxProfit(prices, day+1, lastDay, 0);
            profit=Math.max(profit, Math.max(selling, notSelling));
        }
        return cache[day][buy]=profit;
    }
    public static void main(String[] args){
        Scanner sc;
        int[] prices;
        try{
            sc=new Scanner(System.in);
            System.out.println("Enter length of price array : ");
            int length=sc.nextInt();
            prices=new int[length];
            for(int i=0;i<length;i++)
                prices[i]=sc.nextInt();
            System.out.println(new BuyAndSellWithCooldown().maxProfit(prices));
        }
        catch(Exception e){
            System.out.println("Exception occured : "+e.getMessage());
            e.printStackTrace();
        }
    }
}
