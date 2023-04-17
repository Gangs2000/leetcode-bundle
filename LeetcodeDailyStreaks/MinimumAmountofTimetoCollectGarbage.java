package LeetcodeDailyStreaks;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MinimumAmountofTimetoCollectGarbage {
    Map<Integer, Integer> sumAccumulator;
    int glassIndex=0, metalIndex=0, paperIndex=0, totalMins=0;
    public MinimumAmountofTimetoCollectGarbage(){
        sumAccumulator=new HashMap<>();
    }
    public int garbageCollection(String[] garbage, int[] travel) {
        for(int i=0;i<garbage.length;i++){
            this.returnCountOfItems(garbage[i], 'G', i);
            this.returnCountOfItems(garbage[i], 'P', i);
            this.returnCountOfItems(garbage[i], 'M', i);
            if(i==0)
                sumAccumulator.put(i, 0);
            else
                sumAccumulator.put(i, sumAccumulator.get(i-1)+travel[i-1]);
        }
        return (sumAccumulator.get(glassIndex))+(sumAccumulator.get(paperIndex))+(sumAccumulator.get(metalIndex))+totalMins;        
    }
    public void returnCountOfItems(String garbage,Character item, int index){
        long count=garbage.chars().filter(character->character==item).count();        
        switch(item){
            case 'G' : if(count!=0){ totalMins+=count; glassIndex=index;} break;
            case 'P' : if(count!=0){ totalMins+=count; paperIndex=index;} break;
            case 'M' : if(count!=0){ totalMins+=count; metalIndex=index;} break;
        }
    }
    public static void main(String[] args){
        Scanner sc;
        String[] garbage;
        int[] travel;
        try{
            sc=new Scanner(System.in);
            System.out.println("Enter length of garbage array : ");
            int length=sc.nextInt();
            garbage=new String[length];
            travel=new int[length-1];
            System.out.println("Enter garbage array values : ");
            for(int i=0;i<length;i++)
                garbage[i]=sc.useDelimiter("\n").next();
            System.out.println("Enter travel array values : ");
            for(int i=0;i<length-1;i++)
                travel[i]=sc.nextInt();
            System.out.println(new MinimumAmountofTimetoCollectGarbage().garbageCollection(garbage, travel));
        }
        catch(Exception e){
            System.out.println("Exception occurred : "+e.getMessage());
            e.printStackTrace();
        }
    }
}
