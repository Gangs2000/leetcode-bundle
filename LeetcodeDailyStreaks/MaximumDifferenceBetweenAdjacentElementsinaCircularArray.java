import java.util.Scanner;
import java.util.function.Function;

public class MaximumDifferenceBetweenAdjacentElementsinaCircularArray {
    int maxDiffOfAdjacent = Integer.MIN_VALUE;

    public int maxAdjacentDistance(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++)
            maxDiffOfAdjacent = Math.max(maxDiffOfAdjacent, Math.abs(nums[i] - nums[i + 1]));
        maxDiffOfAdjacent = Math.max(maxDiffOfAdjacent, Math.abs(nums[0] - nums[nums.length - 1]));
        return maxDiffOfAdjacent;
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
            Function<int[], Integer> function = (
                    input) -> new MaximumDifferenceBetweenAdjacentElementsinaCircularArray()
                            .maxAdjacentDistance(input);
            System.out.println(function.apply(nums));
            sc.close();
        } catch (Exception e) {
            System.out.println("Exception occurred : " + e.getMessage());
            e.printStackTrace();
        }
    }
}
