package LeetcodeDailyStreaks;

import java.util.Scanner;

public class DuplicateZeroes {
    int[] result; 
    int resultIndex=0;
    public void duplicateZeros(int[] arr) {
        result=new int[arr.length];
        int start=0, end=arr.length;
        while(start<end){
            result[resultIndex]=arr[start];
            if(arr[start]==0){
                resultIndex++;        
                if(resultIndex!=arr.length)        
                    result[resultIndex]=0;
                end--;       
            }
            start++; resultIndex++;
        }
        for(int i=0;i<arr.length;i++)
            arr[i]=result[i];
    }
    public static void main(String[] args){
        Scanner sc;
        int[] arr;
        try{
            sc=new Scanner(System.in);
            System.out.println("Enter length nums array : ");
            int length=sc.nextInt();
            arr=new int[length];
            for(int i=0;i<length;i++)
                arr[i]=sc.nextInt();
            new DuplicateZeroes().duplicateZeros(arr);
        }
        catch(Exception e){
            System.out.println("Exception occurred : "+e.getMessage());
            e.printStackTrace();
        }
    }
}
