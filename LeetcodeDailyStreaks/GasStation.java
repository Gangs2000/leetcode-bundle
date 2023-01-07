package LeetcodeDailyStreaks;

import java.util.Scanner;

public class GasStation {
    int totalCumulator=0, currentCumulator=0, index=0;
    public int canCompleteCircuit(int[] gas, int[] cost) {
        for(int i=0;i<gas.length;i++){
            totalCumulator+=gas[i]-cost[i];
            currentCumulator+=gas[i]-cost[i];
            if(currentCumulator<0){
                currentCumulator=0;
                index=i+1;
            }            
        }
        return (totalCumulator<0)?(-1):(index);
    }
    public static void main(String[] args){
        Scanner sc;
        int[] gas, costs;
        try{
            sc=new Scanner(System.in);
            System.out.println("Enter length of gas and costs array : ");
            int length=sc.nextInt();
            gas=new int[length];
            costs=new int[length];
            for(int i=0;i<length;i++){
                gas[i]=sc.nextInt();
                costs[i]=sc.nextInt();
            }
            System.out.println(new GasStation().canCompleteCircuit(gas, costs));
        }
        catch(Exception e){
            System.out.println("Exception occurred : "+e.getMessage());
            e.printStackTrace();
        }
    }
}
