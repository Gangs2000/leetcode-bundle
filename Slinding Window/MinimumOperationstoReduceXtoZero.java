import java.util.Arrays;
import java.util.Scanner;
import java.util.function.BiFunction;

public class MinimumOperationstoReduceXtoZero {
    public int minOperations(int[] nums, int x) {
        int totalSum = Arrays.stream(nums).boxed().reduce(0, (a, b) -> a + b).intValue();
        int targetSubArrValue = totalSum - x, maxSubArrLength = Integer.MIN_VALUE, leftPointer = 0, rightPointer = 0,
                currentSum = 0;
        if (targetSubArrValue == 0)
            return nums.length;
        if (targetSubArrValue < 0)
            return -1;
        while (rightPointer < nums.length) {
            currentSum += nums[rightPointer++];
            while (currentSum > targetSubArrValue && leftPointer <= rightPointer) {
                currentSum -= nums[leftPointer++];
            }
            if (targetSubArrValue == currentSum)
                maxSubArrLength = Math.max(maxSubArrLength, rightPointer - leftPointer);
        }
        return maxSubArrLength == Integer.MIN_VALUE ? -1 : nums.length - maxSubArrLength;
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
            System.out.println("Enter X value : ");
            int x = sc.nextInt();
            BiFunction<int[], Integer, Integer> bFunction = new MinimumOperationstoReduceXtoZero()::minOperations;
            System.out.println(bFunction.apply(nums, x));
            sc.close();
        } catch (Exception e) {
            System.out.println("Exception occurred : " + e.getMessage());
            e.printStackTrace();
        }
    }
}
