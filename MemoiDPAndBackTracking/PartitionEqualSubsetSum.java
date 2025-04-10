import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Function;

public class PartitionEqualSubsetSum {
    public boolean canPartition(int[] nums) {
        int totalSum = Arrays.stream(nums).boxed().reduce((a, b) -> (a + b)).get();
        if (totalSum % 2 != 0)
            return false;
        Boolean[][] memo = new Boolean[nums.length + 1][20001];
        return this.classicDynamicProgramming(0, totalSum / 2, 0, nums, memo);
    }

    private boolean classicDynamicProgramming(int currentSum, int remainingSum, int index, int[] nums,
            Boolean[][] memo) {
        if (index == nums.length - 1) {
            if (currentSum == remainingSum)
                return true;
            return false;
        }
        if (memo[index][currentSum] != null)
            return memo[index][currentSum];
        boolean take = false, dontTake = false;
        take = this.classicDynamicProgramming(nums[index] + currentSum, remainingSum,
                index + 1,
                nums, memo);
        dontTake = this.classicDynamicProgramming(currentSum, remainingSum,
                index + 1,
                nums, memo);
        return memo[index][currentSum] = (take || dontTake);
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
            Function<int[], Boolean> function = (input) -> new PartitionEqualSubsetSum().canPartition(input);
            System.out.println(function.apply(nums));
            sc.close();
        } catch (Exception e) {
            System.out.println("Exception occurred : " + e.getMessage());
            e.printStackTrace();
        }
    }
}
