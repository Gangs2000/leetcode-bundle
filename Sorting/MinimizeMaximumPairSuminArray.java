import java.util.Arrays;
import java.util.Scanner;

public class MinimizeMaximumPairSuminArray {
    int minMaxPairSum=Integer.MIN_VALUE;
    public int minPairSum(int[] nums) {
        //Sort the array
        Arrays.sort(nums);
        int leftPointer=0, rightPointer=nums.length-1;
        while(leftPointer<(nums.length/2)){
            minMaxPairSum=Math.max(minMaxPairSum, (nums[leftPointer]+nums[rightPointer]));
            leftPointer++;
            rightPointer--;
        }
        return minMaxPairSum;
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
            System.out.println(new MinimizeMaximumPairSuminArray().minPairSum(nums));
        }
        catch(Exception e){
            System.out.println("Exception occurred : "+e.getMessage());
            e.printStackTrace();
        }
    }    
}
