package LeetcodeDailyStreaks;

import java.util.Scanner;

public class ShuffleTheArray {
    int[] shuffledArray;    
    public int[] shuffle(int[] nums, int n) {
        shuffledArray=new int[n*2];
        int beginPointer=0, middlePointer=n;
        for(int i=0;i<n*2;i=i+2){
            shuffledArray[i]=nums[beginPointer];            
            shuffledArray[i+1]=nums[middlePointer];
            beginPointer++; middlePointer++;
        }
        return shuffledArray;        
    }    
    public static void main(String[] args){
        Scanner sc;
        int[] nums;
        try{            
            sc=new Scanner(System.in);
            System.out.println("Enter value of N : ");
            int n=sc.nextInt();
            nums=new int[n*2];
            for(int i=0;i<n*2;i++)
                nums[i]=sc.nextInt();
            System.out.println(new ShuffleTheArray().shuffle(nums, n));
        }
        catch(Exception e){
            System.out.println("Exception occurred : "+e.getMessage());
            e.printStackTrace();
        }
    }
}
