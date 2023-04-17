package LeetcodeDailyStreaks;

import java.util.Scanner;

public class RearrangeArrayElementsbySign {
    int[] posNums, negNums;
    int posIndex=0, negIndex=0, index=0;
    public int[] rearrangeArray(int[] nums) {
        posNums=new int[nums.length/2];
        negNums=new int[nums.length/2];
        for(int i=0;i<nums.length;i++){
            if(nums[i]>0){
                posNums[posIndex]=nums[i];
                posIndex++;
            }
            else if(nums[i]<0){
                negNums[negIndex]=nums[i];
                negIndex++;
            }
        }
        for(int i=0;i<(nums.length/2);i++){
            nums[index]=posNums[i];
            index++;
            nums[index]=negNums[i];
            index++;
        }
        return nums;
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
            System.out.println(new RearrangeArrayElementsbySign().rearrangeArray(nums));
        }
        catch(Exception e){
            System.out.println("Exception occurred : "+e.getMessage());
            e.printStackTrace();
        }
    }
}
