package MemoiDPAndBackTracking;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MinCostClimbingStairs {    
    Map<Integer, Integer> map;
    public MinCostClimbingStairs(){
        map=new HashMap<>();
    }
    public int minCostClimbingStairs(int[] costs){        
        return Math.min(traverseArray(costs, 0, map), traverseArray(costs, 0, map));
    }
    public int traverseArray(int[] costs, int index, Map<Integer, Integer> map){        
        if(index>=costs.length)
            return 0;
        if(index==costs.length-1)
            return costs[index];
        if(map.containsKey(index))
            return map.get(index);
        int costOne=traverseArray(costs, index+1, map);
        map.put(index+1, costOne);
        int costTwo=traverseArray(costs, index+2, map);        
        map.put(index+2, costTwo);
        return Math.min(costOne, costTwo)+costs[index];
    }
    public static void main(String[] args){
        Scanner sc;
        int[] costs;
        try{
            sc=new Scanner(System.in);
            System.out.println("Enter length of costs array : ");
            int length=sc.nextInt();
            costs=new int[length];
            for(int i=0;i<length;i++)
                costs[i]=sc.nextInt();
            System.out.println(new MinCostClimbingStairs().minCostClimbingStairs(costs));
        }
        catch(Exception e){
            System.out.println("Exception occurred : "+e.getMessage());
            e.printStackTrace();
        }
    }
}
