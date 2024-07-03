import java.util.Arrays;
import java.util.Scanner;

public class MinimumDifferenceBetweenLargestandSmallestValueinThreeMoves {
    int minDifferenceResult=Integer.MAX_VALUE;
    public int minDifference(int[] nums) {
        if(nums.length<=4)
            return 0;
        int decIndex=4, incIndex=0;
        Arrays.sort(nums);
        while(decIndex>0){
            minDifferenceResult=Math.min(minDifferenceResult, nums[nums.length-decIndex]-nums[incIndex]);
            decIndex--; incIndex++;
        }
        return minDifferenceResult;
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
            System.out.println(new MinimumDifferenceBetweenLargestandSmallestValueinThreeMoves().minDifference(nums));
            sc.close();
        } 
        catch (Exception e) {
            System.out.println("Exception occurred : "+e.getMessage());
            e.printStackTrace();
        }
    }
}
