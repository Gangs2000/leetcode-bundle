package LeetcodeDailyStreaks;

import java.util.Arrays;
import java.util.Scanner;

public class SumOfEvenNumbersAfterQueries {
    int[] output;
    int totalSum=0, index=0;
    public int[] sumEvenAfterQueries(int[] nums, int[][] queries) {
        output=new int[nums.length];
        if(nums.length>1)
            totalSum=Arrays.stream(nums).boxed().filter(element->(element%2==0)).reduce((a,b)->(a+b)).orElse(0);
        else
            totalSum+=(nums[0]%2==0)?(nums[0]):(0);
        for(int i=0;i<queries.length;i++){
            int currentElement=nums[queries[i][1]];
            int currentSum=queries[i][0]+currentElement;
            if(Math.abs(currentElement%2)==1 && Math.abs(currentSum%2)==0)
                totalSum+=currentSum;                
            else if(Math.abs(currentElement%2)==0 && Math.abs(currentSum%2)==1)
                totalSum-=nums[queries[i][1]];                
            else if(Math.abs(currentElement%2)==0 && Math.abs(currentSum%2)==0)
                totalSum+=currentSum-nums[queries[i][1]];                
            output[index]=totalSum;
            index++;
            nums[queries[i][1]]=currentSum;       
        }        
        return output;
    }
    public static void main(String[] args){
        Scanner sc;
        int[] nums;
        int[][] queries;
        try{
            sc=new Scanner(System.in);
            System.out.println("Enter length of nums array : ");
            int length=sc.nextInt();
            nums=new int[length];
            for(int i=0;i<length;i++)
                nums[i]=sc.nextInt();
            System.out.println("Enter length of queries array : ");
            int queryLength=sc.nextInt();            
            queries=new int[queryLength][2];
            for(int i=0;i<queryLength;i++){
                queries[i][0]=sc.nextInt();
                queries[i][1]=sc.nextInt();
            }
            System.out.println(new SumOfEvenNumbersAfterQueries().sumEvenAfterQueries(nums, queries));
        }
        catch(Exception e){
            System.out.println("Exception occurred : "+e.getMessage());
            e.printStackTrace();
        }
    }
}
