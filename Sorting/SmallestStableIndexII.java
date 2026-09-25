import java.util.Scanner;
import java.util.function.BiFunction;

public class SmallestStableIndexII {

    public int firstStableIndex(int[] nums, int k) {
        int minStableIndex = Integer.MAX_VALUE, maxElement = Integer.MIN_VALUE, minElement = Integer.MAX_VALUE;
        int[] maxPrefixArr = new int[nums.length], minSuffixArr = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int leftPointer = nums[i], rightPointer = nums[nums.length - i - 1];
            maxElement = Math.max(maxElement, leftPointer);
            minElement = Math.min(minElement, rightPointer);
            maxPrefixArr[i] = maxElement;
            minSuffixArr[nums.length - i - 1] = minElement;
        }
        for (int i = 0; i < nums.length; i++) {
            int difference = maxPrefixArr[i] - minSuffixArr[i];
            if (difference <= k)
                minStableIndex = Math.min(minStableIndex, i);
        }
        return minStableIndex == Integer.MAX_VALUE ? -1 : minStableIndex;
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
            System.out.println("Enter K value : ");
            int k = sc.nextInt();
            BiFunction<int[], Integer, Integer> biFunction = new SmallestStableIndexII()::firstStableIndex;
            System.out.println(biFunction.apply(nums, k));
            sc.close();
        } catch (Exception e) {
            System.out.println("Exception occurred : " + e.getMessage());
            e.printStackTrace();
        }
    }
}
