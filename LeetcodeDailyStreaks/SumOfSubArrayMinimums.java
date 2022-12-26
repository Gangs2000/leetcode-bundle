package LeetcodeDailyStreaks;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class SumOfSubArrayMinimums {
    int sumOfSubArraySums=0;
    public int sumSubarrayMins(int[] arr) {
        List<Integer> list=new LinkedList<>();
        this.findSubSequence(0, arr.length, arr, list);
        return sumOfSubArraySums;
    }
    public void findSubSequence(int index, int boundCondition, int[] arr, List<Integer> list){
        if(index==boundCondition){
            System.out.println(list);
            return;
        }
        list.add(arr[index]);
        this.findSubSequence(index+1, boundCondition, arr, list);
        list.remove(list.size()-1);
        this.findSubSequence(index+1, boundCondition, arr, list);
    }
    public static void main(String[] args){
        Scanner sc;
        int[] numbers;

        try{
            sc=new Scanner(System.in);
            System.out.println("Enter number of length for an array : ");
            int length=sc.nextInt();
            numbers=new int[length];
            for(int i=0;i<length;i++)
                numbers[i]=sc.nextInt();    
            System.out.println(new SumOfSubArrayMinimums().sumSubarrayMins(numbers));        
        }
        catch(Exception e){
            
        }
    }
}
