package LongestArithSequence;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class LongestArithmeticSequence {
    private static int longestSequence(int[] array){
        Map<Integer,Map<Integer,Integer>> outerMap=new HashMap<>();
        int answer=2;
        for(int i=0;i<array.length;i++){
            for(int j=i+1;j<array.length;j++){
                Map<Integer,Integer> innerMap=new HashMap<>();
                if(outerMap.containsKey(array[j]-array[i])){
                    innerMap=outerMap.get(array[j]-array[i]);
                    if(innerMap.containsKey(i))
                        innerMap.put(j, innerMap.get(i)+1);
                }
                innerMap.putIfAbsent(j, 2);
                outerMap.put(array[j]-array[i], innerMap);
                answer=Math.max(answer, innerMap.get(j));
            }
        }
        return answer;
    }
    public static void main(String[] args){
        Scanner sc;
        int[] array;
        try{
            sc=new Scanner(System.in);
            System.out.println("Enter the length of an arraylist : ");
            int length=sc.nextInt();
            array=new int[length];
            for(int i=0;i<length;i++)
                array[i]=sc.nextInt();
            System.out.println(LongestArithmeticSequence.longestSequence(array));
        }
        catch(Exception e){
            System.out.println("Exception occured : "+e.getMessage());
            e.printStackTrace();
        }
    }
}

