import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.function.Function;

public class MaximumUniqueSubarraySumAfterDeletion {
    Set<Integer> uniqueNums;
    int maxElement = Integer.MIN_VALUE, totalSum = 0;

    public MaximumUniqueSubarraySumAfterDeletion() {
        uniqueNums = new HashSet<>();
    }

    public int maxSum(int[] nums) {
        for (int number : nums) {
            maxElement = Math.max(maxElement, number);
            if (number > 0 && !uniqueNums.contains(number)) {
                uniqueNums.add(number);
                totalSum += number;
            }
        }
        return (uniqueNums.isEmpty()) ? maxElement : totalSum;
    }

    public static void main(String[] args) {
        Scanner sc;
        int[] nums;
        try {
            sc = new Scanner(System.in);
            System.out.println("Enter length of an array : ");
            int length = sc.nextInt();
            nums = new int[length];
            for (int i = 0; i < length; i++)
                nums[i] = sc.nextInt();
            Function<int[], Integer> uniqueSum = (input) -> new MaximumUniqueSubarraySumAfterDeletion()
                    .maxSum(input);
            System.out.println(uniqueSum.apply(nums));
            sc.close();
        } catch (Exception e) {
            System.out.println("Exception occurred : " + e.getMessage());
            e.printStackTrace();
        }
    }
}
