package LeetcodeDailyStreaks;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class SumOfUnique {
    Map<Integer,Integer> mapper;
    public SumOfUnique(){
        mapper=new LinkedHashMap<>();
    }
    public int sumOfUnique(int[] nums) {
        int sumOfUnique=0;
        for(int i=0;i<nums.length;i++){
            if(!mapper.containsKey(nums[i]))
                mapper.put(nums[i],1);
            else
                mapper.put(nums[i],mapper.get(nums[i])+1);
        }     
        for(Map.Entry<Integer,Integer> entry : mapper.entrySet()){
            if(entry.getValue()==1)
                sumOfUnique+=entry.getKey();
        }        
        return sumOfUnique;
    }
    public static void main(String[] args){
        Scanner sc;
        int[] numArray;        
        try{
            sc=new Scanner(System.in);
            System.out.println("Enter length of an array : ");
            int length=sc.nextInt();
            numArray=new int[length];
            for(int i=0;i<length;i++)
                numArray[i]=sc.nextInt();
            System.out.println(new SumOfUnique().sumOfUnique(numArray));
        }
        catch(Exception e){
            System.out.println("Exception occured : "+e.getMessage());
            e.printStackTrace();
        }
    }
}
