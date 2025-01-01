import java.util.Scanner;
import java.util.function.BiFunction;

public class TargetSum {

    public int findTargetSumWays(int[] nums, int target) {
        return this.backTracking(0, target, 0, nums);
    }

    // Recursion call, travel left till index reaches end of nums length, then
    // travel right
    private int backTracking(int index, int targetSum, int currentSum, int[] nums) {
        if (index == nums.length) {
            if (currentSum == targetSum)
                return 1;
            return 0;
        }
        return this.backTracking(index + 1, targetSum, currentSum - nums[index], nums) +
                this.backTracking(index + 1, targetSum, currentSum + nums[index], nums);
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
            System.out.println("Enter target value : ");
            int target = sc.nextInt();
            BiFunction<int[], Integer, Integer> biFunction = (input1, input2) -> new TargetSum()
                    .findTargetSumWays(input1, input2);
            System.out.println(biFunction.apply(nums, target));
            sc.close();
        } catch (Exception e) {
            System.out.println("Exception occurred : " + e.getMessage());
            e.printStackTrace();
        }
    }
}
