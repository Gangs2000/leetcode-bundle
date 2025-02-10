import java.util.Scanner;
import java.util.function.Function;

public class LongestStrictlyIncreasingorStrictlyDecreasingSubarray {
    int increasingCount = 1, decreasingCount = 1, longestLength = 1;

    public int longestMonotonicSubarray(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            // Check for strictly increasing nums
            if (nums[i] < nums[i + 1]) {
                increasingCount++;
                longestLength = Math.max(increasingCount, longestLength);
            } else
                increasingCount = 1;
            // Check for strictly decreasing nums
            if (nums[i] > nums[i + 1]) {
                decreasingCount++;
                longestLength = Math.max(decreasingCount, longestLength);
            } else
                decreasingCount = 1;
        }
        return longestLength;
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
            Function<int[], Integer> function = (input) -> new LongestStrictlyIncreasingorStrictlyDecreasingSubarray()
                    .longestMonotonicSubarray(input);
            System.out.println(function.apply(nums));
            sc.close();
        } catch (Exception e) {
            System.out.println("Exception occurred : " + e.getMessage());
            e.printStackTrace();
        }
    }
}
