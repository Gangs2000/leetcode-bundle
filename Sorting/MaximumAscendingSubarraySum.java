import java.util.Scanner;
import java.util.function.Function;

public class MaximumAscendingSubarraySum {

    public int maxAscendingSum(int[] nums) {
        int currentSum = nums[0], maxAscendingSum = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1])
                currentSum += nums[i];
            else {
                maxAscendingSum = Math.max(maxAscendingSum, currentSum);
                currentSum = nums[i];
            }
        }
        maxAscendingSum = Math.max(maxAscendingSum, currentSum);
        return maxAscendingSum;
    }

    public static void main(String[] args) {
        Scanner sc;
        int[] nums;
        try {
            sc = new Scanner(System.in);
            System.out.println("Enter length of nums array : ");
            int length = sc.nextInt();
            nums = new int[length];
            for (int i = 0; i < length; i++)
                nums[i] = sc.nextInt();
            Function<int[], Integer> function = (input) -> new MaximumAscendingSubarraySum().maxAscendingSum(input);
            System.out.println(function.apply(nums));
            sc.close();
        } catch (Exception e) {
            System.out.println("Exception occurred : " + e.getMessage());
            e.printStackTrace();
        }
    }
}
