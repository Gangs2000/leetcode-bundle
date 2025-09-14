import java.util.Scanner;
import java.util.function.Function;

public class LongestSubarrayof1AfterDeletingOneElement {
    int longestSubOfOne = 0, ones = 0, zeroes = 0, leftPointer = 0, rightPointer = 0;

    public int longestSubarray(int[] nums) {
        while (rightPointer < nums.length) {
            if (nums[rightPointer] == 0)
                zeroes++;
            else if (nums[rightPointer] == 1)
                ones++;
            while (leftPointer < nums.length && zeroes > 1) {
                if (nums[leftPointer] == 0)
                    zeroes--;
                else if (nums[leftPointer] == 1)
                    ones--;
                leftPointer++;
            }
            longestSubOfOne = Math.max(longestSubOfOne, ones);
            rightPointer++;
        }
        return (nums.length == longestSubOfOne) ? longestSubOfOne - 1 : longestSubOfOne;
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
            Function<int[], Integer> function = (input) -> new LongestSubarrayof1AfterDeletingOneElement()
                    .longestSubarray(input);
            System.out.println(function.apply(nums));
            sc.close();
        } catch (Exception e) {
            System.out.println("Exception occurred : " + e.getMessage());
            e.printStackTrace();
        }
    }
}
