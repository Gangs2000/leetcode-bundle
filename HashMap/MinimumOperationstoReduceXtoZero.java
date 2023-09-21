import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MinimumOperationstoReduceXtoZero {
    int minSubArrLength=Integer.MIN_VALUE;
    Map<Integer, Integer> sumMap;
    public MinimumOperationstoReduceXtoZero(){
        sumMap=new HashMap<>();
        sumMap.put(0, -1);
    }
    public int minOperations(int[] nums, int x) {
        int sum=0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            sumMap.put(sum, i);
        }
        int remainingSum=sum-x;
        if(sum<x)
            return -1;
        sum=0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            int currentSum=sum-remainingSum;
            if(sumMap.containsKey(currentSum))
                minSubArrLength=Math.max(minSubArrLength, i-sumMap.get(currentSum));
        }
        return (minSubArrLength==Integer.MIN_VALUE)?(-1):(nums.length-minSubArrLength);
    }
    public static void main(String[] args){
        Scanner sc;
        int[] nums;
        try{
            sc=new Scanner(System.in);
            System.out.println("Enter length of nums array :");            
            int length=sc.nextInt();
            nums=new int[length];
            for(int i=0;i<length;i++)
                nums[i]=sc.nextInt();
            System.out.println("Enter X value : ");
            int x=sc.nextInt();
            System.out.println(new MinimumOperationstoReduceXtoZero().minOperations(nums, x));
        }
        catch(Exception e){
            System.out.println("Exception occurred : "+e.getMessage());
            e.printStackTrace();
        }
    }
}