package ZOHOQuestions;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class MergeSortedArray {
    List<Integer> list=new LinkedList<>();
    public List<Integer> mergeSortedArray(int[] arr1, int[] arr2){
        int arr1Pointer=0, arr2Pointer=0;
        while(arr1Pointer<arr1.length && arr2Pointer<arr2.length){
            if(arr1[arr1Pointer]==arr2[arr2Pointer]){
                list.add(arr1[arr1Pointer]);
                arr1Pointer++; arr2Pointer++;
            }
            else{
                if(arr1[arr1Pointer]<arr2[arr2Pointer]){
                    list.add(arr1[arr1Pointer]);
                    arr1Pointer++;                    
                }
                else{
                    list.add(arr2[arr2Pointer]);
                    arr2Pointer++;
                }
            }
        }        
        if(arr1Pointer!=arr1.length)
            template(arr1Pointer, arr1.length, arr1);
        else
            template(arr2Pointer, arr2.length, arr2);
        return list;
    }
    public void template(int start, int end, int[] arr){
        for(int i=start;i<end;i++)
            list.add(arr[i]);
    }
    public static void main(String[] args){
        Scanner sc;
        int[] arr1, arr2;
        try{
            sc=new Scanner(System.in);
            System.out.println("Enter length of array-1 : ");
            int arr1Length=sc.nextInt();
            arr1=new int[arr1Length];
            for(int i=0;i<arr1Length;i++)
                arr1[i]=sc.nextInt();
            System.out.println("Enter length of array-2 : ");
            int arr2Length=sc.nextInt();
            arr2=new int[arr2Length];
            for(int i=0;i<arr2Length;i++)
                arr2[i]=sc.nextInt();
            System.out.println(new MergeSortedArray().mergeSortedArray(arr1, arr2));
        }
        catch(Exception e){
            System.out.println("Exception occurred : "+e.getMessage());
            e.printStackTrace();
        }
    }
}
