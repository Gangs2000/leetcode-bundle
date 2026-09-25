import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Function;

public class MaximumProductofThreeNumbers {
    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        int negative = Integer.MIN_VALUE, positive = Integer.MIN_VALUE;
        if (nums[0] < 0 && nums[1] < 0 && nums[nums.length - 1] > 0)
            negative = nums[0] * nums[1] * nums[nums.length - 1];
        positive = nums[nums.length - 1] * nums[nums.length - 2] * nums[nums.length - 3];
        return Math.max(negative, positive);
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
            Function<int[], Integer> function = new MaximumProductofThreeNumbers()::maximumProduct;
            System.out.println(function.apply(nums));
            sc.close();
        } catch (Exception e) {
            System.out.println("Exception occurred : " + e.getMessage());
            e.printStackTrace();
        }
    }
}
