package LeetcodeDailyStreaks;

import java.util.Arrays;
import java.util.Scanner;

public class LongestSubSequenceWithLimitedSum {    
    public int[] answerQueries(int[] nums, int[] queries) {        
        Arrays.sort(nums);                                          //Sort an array..
        for(int i=0;i<queries.length;i++){
            int sum=0;
            for(int j=0;j<nums.length;j++){
                sum+=nums[j];
                if(sum<=queries[i]){
                    queries[i]=j;
                    break;
                }
                if(j==nums.length-1 && sum<=queries[i])
                    queries[i]=j+1;
            }
        }
        return queries;            
    }
    
    public static void main(String[] args){
        Scanner sc;
        int[] nums, queries;
        try{
            sc=new Scanner(System.in);
            System.out.println("Enter the length of nums array : ");
            int numLength=sc.nextInt();
            nums=new int[numLength];
            for(int i=0;i<numLength;i++)
                nums[i]=sc.nextInt();
            System.out.println("Enter the length of queries array : ");
            int queryLength=sc.nextInt();
            queries=new int[queryLength];
            for(int i=0;i<queryLength;i++)
                queries[i]=sc.nextInt();
            System.out.println(new LongestSubSequenceWithLimitedSum().answerQueries(nums, queries));
        }   
        catch(Exception e){
            System.out.println("Exception occured : "+e.getMessage());
            e.printStackTrace();
        }
    }
}
