package LeetcodeDailyStreaks;

import java.util.Scanner;

public class CheckIfAllOnesAtLeastKPlacesAway {    
    public boolean kLengthApart(int[] nums, int k) {
        int index=0;
        while(index<nums.length){
            if(nums[index]==1){
                int leftPointer=index;
                int nextIndex=index+1;
                while(nextIndex<nums.length){
                    if(nums[nextIndex]==1){
                        int rightPointer=nextIndex;                        
                        if((rightPointer-leftPointer)-1<k)
                            return false;
                        else {
                            index=nextIndex-1;
                            break;
                        }
                    }
                    nextIndex++;
                }
            }
            index++;
        }
        return true;
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
            System.out.println(new CheckIfAllOnesAtLeastKPlacesAway().kLengthApart(nums, k));
        }
        catch(Exception e){
            System.out.println("Exception occurred : "+e.getMessage());
            e.printStackTrace();
        }   
    }
}
