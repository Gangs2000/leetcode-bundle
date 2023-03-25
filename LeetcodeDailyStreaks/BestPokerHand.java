package LeetcodeDailyStreaks;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class BestPokerHand {
    Map<Object, Integer> suitMap, rankMap;
    public BestPokerHand(){
        suitMap=new LinkedHashMap<>();
        rankMap=new LinkedHashMap<>();
    }
    public String bestHand(int[] ranks, char[] suits) {
        for(int i=0;i<ranks.length;i++){
            //Operation for suitMap..
            suitMap.putIfAbsent((char) suits[i], 0);
            suitMap.put((char) suits[i], suitMap.get((char) suits[i])+1);            
            //Operation for rankMap..
            rankMap.putIfAbsent((int) ranks[i], 0);
            rankMap.put((int) ranks[i], rankMap.get((int) ranks[i])+1);
        }        
        if(suitMap.containsValue(5))
            return "Flush";
        else {
            int maxValue=rankMap.values().stream().max(Integer::compareTo).get();
            if(maxValue>=3)
                return "Three of a Kind";
            else if(maxValue==2)
                return "Pair";
        }        
        return "High Card";
    }
    public static void main(String[] args){
        Scanner sc;
        int[] ranks;
        char[] suites;
        try{
            sc=new Scanner(System.in);        
            System.out.println("Enter length of ranks and suites : ");
            int length=sc.nextInt();
            ranks=new int[length];
            suites=new char[length];
            for(int i=0;i<length;i++){
                ranks[i]=sc.nextInt();
                suites[i]=sc.next().charAt(0);
            }    
            System.out.println(new BestPokerHand().bestHand(ranks, suites));
        }
        catch(Exception e){
            System.out.println("Exception occurred : "+e.getMessage());
            e.printStackTrace();
        }
    }
}
