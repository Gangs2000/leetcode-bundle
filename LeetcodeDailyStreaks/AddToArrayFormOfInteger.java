package LeetcodeDailyStreaks;

import java.util.Scanner;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class AddToArrayFormOfInteger {
    List<Integer> result;    
    public AddToArrayFormOfInteger(){
        result=new LinkedList<>();
    }
    public List<Integer> addToArrayForm(int[] num, int k) {
        int index=num.length-1;
        while(index>=0 || k>0){
            if(index>=0){
                result.add((num[index]+k)%10);
                k=(num[index]+k)/10;
            }
            else{
                result.add(k%10);
                k/=10;
            }
            index--;
        }
        Collections.reverse(result);        
        return result;
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
            System.out.println(new AddToArrayFormOfInteger().addToArrayForm(nums, k));
        }
        catch(Exception e){
            System.out.println("Exception occurred : "+e.getMessage());
            e.printStackTrace();
        }
    }
}
