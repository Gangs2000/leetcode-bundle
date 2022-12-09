package LeetcodeDailyStreaks;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SumOfSubArrayMinimums {
    List<Integer> listOfNumbers;
    int sum;
    public SumOfSubArrayMinimums(){
        sum=0;
        listOfNumbers=new LinkedList<>();
    }
    public int sumSubarrayMins(int[] arr) {
        //Calling this method to convert an array to List
        this.convertNumArrayToList(arr);
        for(int i=0;i<listOfNumbers.size();i++){
            for(int j=i;j<listOfNumbers.size();j++){                
                sum+=listOfNumbers.subList(i, j+1).stream().min(Integer::compareTo).get();
            }
        }                                
        return sum;
    }
    public void convertNumArrayToList(int[] arr){
        listOfNumbers=IntStream.of(arr).boxed().collect(Collectors.toList());
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
