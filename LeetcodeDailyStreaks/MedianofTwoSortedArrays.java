package LeetcodeDailyStreaks;

import java.util.Formatter;
import java.util.Scanner;

public class MedianofTwoSortedArrays {
    int[] mergedArray;
    int i=0, j=0, index=0;
    Formatter decimalFormat;
    public MedianofTwoSortedArrays(){
        decimalFormat=new Formatter();
    }
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        mergedArray=new int[nums1.length+nums2.length];
        while(i<nums1.length && j<nums2.length){
            if(nums1[i]<nums2[j])
                mergedArray[index++]=nums1[i++];
            else if(nums1[i]>nums2[j])
                mergedArray[index++]=nums2[j++];                
            else if(nums1[i]==nums2[j]){
                mergedArray[index++]=nums1[i++];                
                mergedArray[index++]=nums2[j++];                
            }
        }
        if(i<nums1.length)
            addRemainingElements(i, nums1);
        else if(j<nums2.length)
            addRemainingElements(j, nums2);
        double medianSumValue=(mergedArray.length%2==1)?(mergedArray[mergedArray.length/2]):(mergedArray[mergedArray.length/2]+mergedArray[(mergedArray.length/2)-1]);
        return (mergedArray.length%2==1)?(Double.valueOf(decimalFormat.format("%.5f", medianSumValue).toString())):(Double.valueOf(decimalFormat.format("%.5f", medianSumValue/2).toString()));
    }
    public void addRemainingElements(int currentArrIndex, int[] array){
        while(currentArrIndex<array.length)
            mergedArray[index++]=array[currentArrIndex++];        
    }
    public static void main(String[] args){
        Scanner sc;
        int[] nums1, nums2;
        try{
            sc=new Scanner(System.in);
            System.out.println("Enter length of nums1 and nums2 array : ");
            int num1Length=sc.nextInt();
            int num2Length=sc.nextInt();
            nums1=new int[num1Length];
            for(int i=0;i<num1Length;i++)
                nums1[i]=sc.nextInt();
            nums2=new int[num2Length];
            for(int i=0;i<num2Length;i++)
                nums2[i]=sc.nextInt();
            System.out.println(new MedianofTwoSortedArrays().findMedianSortedArrays(nums1, nums2));
        }
        catch(Exception e){
            System.out.println("Exception occurred : "+e.getMessage());
            e.printStackTrace();
        }
    }    
}
