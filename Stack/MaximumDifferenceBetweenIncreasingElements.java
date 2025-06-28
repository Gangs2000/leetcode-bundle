import java.util.Scanner;
import java.util.function.Function;

public class MaximumDifferenceBetweenIncreasingElements {
    int maxDiffResult = Integer.MIN_VALUE, currentMinElement = Integer.MAX_VALUE;

    public int maximumDifference(int[] nums) {
        for (int number : nums) {
            currentMinElement = Math.min(currentMinElement, number);
            if (currentMinElement < number)
                maxDiffResult = Math.max(maxDiffResult, number - currentMinElement);
        }
        return maxDiffResult == Integer.MIN_VALUE ? -1 : maxDiffResult;
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
            Function<int[], Integer> function = (input) -> new MaximumDifferenceBetweenIncreasingElements()
                    .maximumDifference(input);
            System.out.println(function.apply(nums));
            sc.close();
        } catch (Exception e) {
            System.out.println("Exception occurred : " + e.getMessage());
            e.printStackTrace();
        }
    }
}
