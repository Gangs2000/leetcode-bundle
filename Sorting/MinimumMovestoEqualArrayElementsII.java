import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Function;

public class MinimumMovestoEqualArrayElementsII {
    public int minMoves2(int[] nums) {
        int totalMinMoves = 0, middleIndex = 0 + (nums.length - 0) / 2;
        int middleElement = nums[middleIndex], index = 0;
        Arrays.sort(nums);
        while (index < middleIndex) {
            totalMinMoves += middleElement - nums[index];
            totalMinMoves += (nums[nums.length - 1 - index] - middleElement);
            index++;
        }
        return totalMinMoves;
    }

    public static void main(String[] args) {
        Scanner sc;
        int[] nums;
        try {
            sc = new Scanner(System.in);
            System.out.println("Enter length of nums array :");
            int length = sc.nextInt();
            nums = new int[length];
            for (int i = 0; i < length; i++)
                nums[i] = sc.nextInt();
            Function<int[], Integer> function = new MinimumMovestoEqualArrayElementsII()::minMoves2;
            System.out.println(function.apply(nums));
            sc.close();
        } catch (Exception e) {
            System.out.println("Exception occurred : " + e.getMessage());
            e.printStackTrace();
        }
    }
}
