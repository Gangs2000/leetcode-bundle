package LeetcodeDailyStreaks;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class RotateArray {
    List<Integer> list;
    public RotateArray(){
        list=new LinkedList<>();
    }
    public void rotate(int[] nums, int k) {
        int index=0;
        //Mod operator to reduce the number of K times, iterating k times is same as iterating k%len(nums)
        k=k%nums.length;
        if(nums.length!=k){
            while(index<nums.length){
                list.add(nums[(index+k)%nums.length]);  
                if(index<k)                                      
                    nums[(index+k)%nums.length]=nums[index];
                else{                                        
                    nums[(index+k)%nums.length]=list.get(0);
                    list.remove(0);                    
                }                    
                index++;
            }
            list.clear();
        }
    }
    public static void main(String[] args){
        Scanner sc;
        int[] nums;
        try{
            sc=new Scanner(System.in);
            System.out.println("Enter length of nums array : ");
            int length=sc.nextInt();
            nums=new int[length];
            for(int i=0;i<length;i++)
                nums[i]=sc.nextInt();
            System.out.println("Enter K value : ");
            int k=sc.nextInt();
            new RotateArray().rotate(nums, k);
        }
        catch(Exception e){
            System.out.println("Exception occurred : "+e.getMessage());
            e.printStackTrace();
        }
    }
}
