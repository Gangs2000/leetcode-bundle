import java.util.Scanner;
import java.util.function.Function;

public class MinimumMovestoEqualArrayElementsIII {
    public int minMoves(int[] nums) {
        int maxElement = Integer.MIN_VALUE, minMovesCount = 0;
        for (int number : nums)
            maxElement = Math.max(maxElement, number);
        for (int i = 0; i < nums.length; i++)
            minMovesCount += Math.abs(nums[i] - maxElement);
        return minMovesCount;
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
            Function<int[], Integer> function = new MinimumMovestoEqualArrayElementsIII()::minMoves;
            System.out.println(function.apply(nums));
            sc.close();
        } catch (Exception e) {
            System.out.println("Exception occurred : " + e.getMessage());
            e.printStackTrace();
        }
    }
}
