package LeetcodeDailyStreaks;

import java.util.Scanner;
import java.util.Arrays;

public class CanMakeArithmeticProgressionFromSequence {
    public boolean canMakeArithmeticProgression(int[] arr) {
        int difference=Integer.MIN_VALUE;
        //Sort the array..
        Arrays.sort(arr);
        for(int i=0;i<arr.length-1;i++){
            if(difference==Integer.MIN_VALUE)
                difference=arr[i+1]-arr[i];
            else if(difference!=arr[i+1]-arr[i])
                return false;
        }
        return true;
    }
    public static void main(String[] args){
        Scanner sc;
        int[] array;
        try{
            sc=new Scanner(System.in);
            System.out.println("Enter length of an array : ");
            int length=sc.nextInt();
            array=new int[length];
            for(int i=0;i<length;i++)
                array[i]=sc.nextInt();
            System.out.println(new CanMakeArithmeticProgressionFromSequence().canMakeArithmeticProgression(array));
        }
        catch(Exception e){
            System.out.println("Exception occurred : "+e.getMessage());
            e.printStackTrace();
        }
    }
}
