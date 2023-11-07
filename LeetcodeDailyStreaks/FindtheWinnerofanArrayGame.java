package LeetcodeDailyStreaks;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class FindtheWinnerofanArrayGame {
    List<Integer> list;
    Map<Integer, Integer> mapper;
    public FindtheWinnerofanArrayGame(){
        list=new LinkedList<>();
        mapper=new HashMap<>();
    }
    public int getWinner(int[] arr, int k) {
        //Initialise array values to list
        for(int number : arr)
            list.add(number);
        if(k>=arr.length)
            return list.stream().max(Comparable::compareTo).get();
        while(!mapper.containsValue(k)){
            if(list.get(0)>list.get(1)){
                mapper.putIfAbsent(list.get(0), 0);
                mapper.put(list.get(0), mapper.get(list.get(0))+1);
                list.add(list.get(1)); list.remove(1);
            }
            else{
                mapper.putIfAbsent(list.get(1), 0);
                mapper.put(list.get(1), mapper.get(list.get(1))+1);
                list.add(list.get(0)); list.remove(0);
            }            
        }        
        return list.get(0);
    }
    public static void main(String[] args){
        Scanner sc;
        int[] arr;
        try{
            sc=new Scanner(System.in);
            System.out.println("Enter length of arr : ");
            int length=sc.nextInt();
            arr=new int[length];
            for(int i=0;i<length;i++)
                arr[i]=sc.nextInt();
            System.out.println("Enter K value : ");
            int k=sc.nextInt();
            System.out.println(new FindtheWinnerofanArrayGame().getWinner(arr, k));
        }
        catch(Exception e){
            System.out.println("Exception occurred : "+e.getMessage());
            e.printStackTrace();    
        }
    }
}
