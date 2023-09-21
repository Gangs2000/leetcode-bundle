package MemoiDPAndBackTracking;

import java.util.Scanner;

public class CoinChangeII {
    public int change(int amount, int[] coins) {
        return coinChange(0, amount, coins);
    }
    public int coinChange(int currentSum, int amount, int[] coins){
        if(currentSum>amount)
            return 0;
        if(currentSum==amount)
            return 1;
        int count=0;
        for(int i=0;i<coins.length;i++)
            count+=coinChange(currentSum+coins[i], amount, coins);
        return count;
    }   
    public static void main(String[] args){
        Scanner sc;
        int[] coins;
        try{
            sc=new Scanner(System.in);
            System.out.println("Enter length of coins array : ");
            int length=sc.nextInt();
            coins=new int[length];
            for(int i=0;i<length;i++)
                coins[i]=sc.nextInt();
            System.out.println("Enter amount : ");
            int amount=sc.nextInt();
            System.out.println(new CoinChangeII().change(amount, coins));
        }
        catch(Exception e){
            System.out.println("Exception occurred : "+e.getMessage());
            e.printStackTrace();
        }
    }
}
