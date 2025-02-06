import java.util.Scanner;
import java.util.function.Function;

public class NumberofWaystoSplitArray {
    int noOfWays = 0;

    public int waysToSplitArray(int[] nums) {
        long prefixSum = this.prefixSumOfNums(nums), currentSum = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            currentSum += nums[i];
            prefixSum -= nums[i];
            if (currentSum >= prefixSum)
                noOfWays++;
        }
        return noOfWays;
    }

    private long prefixSumOfNums(int[] nums) {
        long prefixSum = 0;
        for (int number : nums)
            prefixSum += number;
        return prefixSum;
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
            Function<int[], Integer> function = (input) -> new NumberofWaystoSplitArray().waysToSplitArray(input);
            System.out.println(function.apply(nums));
            sc.close();
        } catch (Exception e) {
            System.out.println("Exception occurred : " + e.getMessage());
            e.printStackTrace();
        }
    }
}
