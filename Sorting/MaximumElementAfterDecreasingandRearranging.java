import java.util.Arrays;
import java.util.Scanner;

public class MaximumElementAfterDecreasingandRearranging {
    int maxElement=Integer.MIN_VALUE;
    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        //Sort the array first
        Arrays.sort(arr);
        if(arr[0]!=1)
            arr[0]=1;
        maxElement=Math.max(maxElement, arr[0]);
        for(int i=1;i<arr.length;i++){
            if(!(arr[i]-arr[i-1]<=1))
                arr[i]=arr[i-1]+1;
            maxElement=Math.max(maxElement, arr[i]);
        }
        return maxElement;
    }
    public static void main(String[] args){
        Scanner sc;
        int[] nums;
        try{
            sc=new Scanner(System.in);
            System.out.println("Enter length of nums array : ");
            int length=sc.nextInt();
            nums=new int[length];
            for(int i=0;i<length;i++)
                nums[i]=sc.nextInt();
            System.out.println(new MaximumElementAfterDecreasingandRearranging().maximumElementAfterDecrementingAndRearranging(nums));
        }
        catch(Exception e){
            System.out.println("Exception occurred : "+e.getMessage());
            e.printStackTrace();
        }
    }
}
