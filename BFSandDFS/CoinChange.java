import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class CoinChange {        
    List<List<Integer>> queue;
    Set<Integer> visited;
    public CoinChange(){
        queue=new LinkedList<>();
        visited=new HashSet<>();
    }
    public int coinChange(int[] coins, int amount) {
        if(amount==0)
            return 0;
        queue.add(List.of(amount, 0));
        visited.add(amount);
        while(!queue.isEmpty()){
            List<Integer> list=queue.get(0);
            for(int coin : coins){
                int remining=list.get(0)-coin;
                if(remining>0 && !visited.contains(remining)){
                    queue.add(List.of(remining, list.get(1)+1));
                    visited.add(remining);
                }
                else if(remining==0)
                    return list.get(1)+1;
            }
            queue.remove(0);
        }
        return -1;
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
            System.out.println("Enter an amount : ");
            int amount=sc.nextInt();
            System.out.println(new CoinChange().coinChange(coins, amount));
        }
        catch(Exception e){
            System.out.println("Exception occurred : "+e.getMessage());
            e.printStackTrace();
        }
    }
}
