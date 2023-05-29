package LeetcodeDailyStreaks;

import java.util.Scanner;

public class KRadiusSubarrayAverages {
    int[] result;
    boolean flag=true;
    long total=0;
    public int[] getAverages(int[] nums, int k) {
        result=new int[nums.length];
        for(int i=0;i<nums.length;i++){            
            if(i>=k && i<=nums.length-1-k){
                if(flag){
                    flag=false;
                    result[i]=(int) (this.getSum(i-k, i+k, nums)/((k*2)+1));                         
                }
                else {
                    total+=nums[i+k];
                    result[i]=(int) (total/((k*2)+1));
                }
                total-=nums[i-k];                
            }
            else
                result[i]=-1;
        }
        return result;
    }
    public long getSum(int start, int end, int[] nums){
        for(int i=start;i<=end;i++)
            total+=nums[i];
        return total;
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
            System.out.println(new KRadiusSubarrayAverages().getAverages(nums, k));
        }
        catch(Exception e){
            System.out.println("Exception occurred : "+e.getMessage());
            e.printStackTrace();
        }
    }
}

