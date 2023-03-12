package LeetcodeDailyStreaks;

import java.util.Scanner;

public class KMissingPositiveIntegers {    
    public int findKthPositive(int[] arr, int k) {
        //Begin, end will keep updating interval between missing elements and Prev and Current miss keep updating missing counts current + prev iteration
        int begin=0, end=0, prevMiss=0, currentMiss=0;       
        //If confition to check if none of element is missing in array ( arr[length-1]-1 -( index of last element )) 
        if((arr[arr.length-1]+1)-(arr.length-1)==0)
            return this.findMissingElement(arr[arr.length-1]+1, 1000+k, arr, k);
        else{            
            for(int i=0;i<arr.length;i++){
                int missingCount=(arr[i]-1)-i;
                if(missingCount!=0){
                    //Updating intervals..
                    begin=i-1; end=i;
                }       
                //Updating missing counts      
                prevMiss=currentMiss;
                currentMiss=missingCount;
                if(missingCount>=k){
                    //Updating intervals and breaking loop since missing count has been reached K limit
                    begin=i-1; end=i;
                    break;
                }
            }                                
        }
        //If begin -1 which means some elements are missing between 1 to arr[0]-1
        if(begin==-1)
            return this.findMissingElement(1, arr[0]-1, arr, k); 
        //If end is not equal to and current miss is greater than K, then missing value occurred between begin and end intervals..
        if(end!=0 && currentMiss>=k)
            return this.findMissingElement(arr[begin]+1, arr[end]-1, arr, k-prevMiss);
        //Else missing value occurred outside of the array..
        else
            return this.findMissingElement(arr[arr.length-1]+1, 1000+k, arr, k-currentMiss);        
    }
    public int findMissingElement(int begin, int end, int[] arr, int limit){
        int count=0;              
        for(int i=begin;i<=end;i++){            
            count++;
            if(limit==count)
                return i;            
        }
        return 0;
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
            System.out.println(new KMissingPositiveIntegers().findKthPositive(nums, k));
        }
        catch(Exception e){
            System.out.println("Exception occurred : "+e.getMessage());
            e.printStackTrace();
        }
    }
}
