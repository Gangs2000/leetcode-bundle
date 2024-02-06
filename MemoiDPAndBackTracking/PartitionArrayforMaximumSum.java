import java.util.Arrays;
import java.util.Scanner;

public class PartitionArrayforMaximumSum {
    int[] cache;
    public int maxSumAfterPartitioning(int[] arr, int k) {
        cache=new int[arr.length];
        Arrays.fill(cache, -1);
        return this.getMaxFromSubArray(0, arr, cache, k);
    }
    public int getMaxFromSubArray(int index, int[] arr, int[] cache, int k){
        if(index>=arr.length)
            return 0;
        if(cache[index]!=-1)
            return cache[index];
        int result=0, currentMax=Integer.MIN_VALUE;
        for(int i=index;i<arr.length && i-index+1<=k;i++){
            currentMax=Math.max(currentMax, arr[i]);
            result=Math.max(result, ((i-index+1)*currentMax)+getMaxFromSubArray(i+1, arr, cache, k));
        }
        return cache[index]=result;
    }
    public static void main(String[] args) {
        Scanner sc;
        int[] nums;
        try {
            sc=new Scanner(System.in);
            System.out.println("Enter length of nums array : ");
            int length=sc.nextInt();
            nums=new int[length];
            for(int i=0;i<length;i++)
                nums[i]=sc.nextInt();
            sc.close();
        } 
        catch (Exception e) {
            System.out.println("Exception occurred : "+e.getMessage());
            e.printStackTrace();
        }
    }
}