import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Function;

public class MaximumAlternatingSumofSquares {
    public long maxAlternatingSum(int[] nums) {
        long totalAlterSum = 0l;
        for (int i = 0; i < nums.length; i++)
            nums[i] = nums[i] * nums[i];
        Arrays.sort(nums);
        for (int i = 0; i < nums.length / 2; i++)
            totalAlterSum -= nums[i];
        for (int i = nums.length / 2; i < nums.length; i++)
            totalAlterSum += nums[i];
        return totalAlterSum;
    }

    public static void main(String[] args) {
        Scanner sc;
        int[] nums;
        try {
            sc = new Scanner(System.in);
            /*
             * System.out.println("Enter length of nums array : ");
             * int length = sc.nextInt();
             * nums = new int[length];
             * for (int i = 0; i < length; i++)
             * nums[i] = sc.nextInt();
             */
            nums = new int[] { 12, -4 };
            Function<int[], Long> function = new MaximumAlternatingSumofSquares()::maxAlternatingSum;
            System.out.println(function.apply(nums));
            sc.close();
        } catch (Exception e) {
            System.out.println("Exception occurred : " + e.getMessage());
            e.printStackTrace();
        }
    }
}
