package LeetcodeDailyStreaks;

import java.util.Arrays;
import java.util.Scanner;

public class MinimiseMaxOfArray {
    int minMaxElement=0;
    public int minimizeArrayValue(int[] nums) {
        int lowerBound=1;
        int upperBound=Arrays.stream(nums).max().getAsInt();
        while(lowerBound<=upperBound){
            int middle=lowerBound+(upperBound-lowerBound)/2;            
            if(binarySearch(nums, middle)){
                minMaxElement=middle;
                upperBound=middle-1;
            }
            else
                lowerBound=middle+1;
        }
        return minMaxElement;        
    }
    public boolean binarySearch(int[] nums, int maxElement){
        long[] array=Arrays.stream(nums).mapToLong(element->element).toArray();
        for(int i=0;i<array.length-1;i++){
            if(array[i]>maxElement)
                return false;
            long buffer=maxElement-array[i];
            array[i+1]=array[i+1]-buffer;
        }
        return array[array.length-1]<=maxElement;
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
            System.out.println(new MinimiseMaxOfArray().minimizeArrayValue(nums));       
        }   
        catch(Exception e){
            System.out.println("Exception occurred : "+e.getMessage());
            e.printStackTrace();    
        }
    }
}
