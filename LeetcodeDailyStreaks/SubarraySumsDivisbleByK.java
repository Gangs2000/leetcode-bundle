package LeetcodeDailyStreaks;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SubarraySumsDivisbleByK {
    Map<Integer, Integer> map;
    int sum=0, count=0;
    public SubarraySumsDivisbleByK(){
        map=new HashMap<>();
    }
    public int subarraysDivByK(int[] nums, int k) {
        map.put(0, 1);                                  //Adding initial reminder count to map..
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];  
            int reminder=sum%k;    
            if(reminder<0)
                reminder=reminder+k;  
            if(map.containsKey(reminder)){
                count+=map.get(reminder);
                map.put(reminder, map.get(reminder)+1);                                                        
            }
            else
                map.put(reminder, 1);
        }
        return count;
    }
    public static void main(String[] args){
        Scanner sc;
        try{
            sc=new Scanner(System.in);
            System.out.println("Enter length of nums array : ");
            int length=sc.nextInt();
            int[] nums=new int[length];
            for(int i=0;i<length;i++)
                nums[i]=sc.nextInt();
            System.out.println("Enter K value : ");
            int k=sc.nextInt();
            System.out.println(new SubarraySumsDivisbleByK().subarraysDivByK(nums, k));
        }
        catch(Exception e){
            System.out.println("Exception occurred : "+e.getMessage());
            e.printStackTrace();
        }
    }
}
