import java.util.Arrays;
import java.util.Scanner;
import java.util.function.BiFunction;

public class PartitionArraySuchThatMaximumDifferenceIsK {
    public int partitionArray(int[] nums, int k) {
        int leftPointer = 0, rightPointer = 0, maxDiffCount = 1;
        Arrays.sort(nums); // Sort the array
        while (rightPointer < nums.length) {
            if (nums[rightPointer] - nums[leftPointer] > k) {
                leftPointer = rightPointer;
                maxDiffCount++;
            }
            rightPointer++;
        }
        return maxDiffCount;
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
            System.out.println("Enter K value : ");
            int k = sc.nextInt();
            BiFunction<int[], Integer, Integer> biFunction = (input1,
                    input2) -> new PartitionArraySuchThatMaximumDifferenceIsK().partitionArray(input1, input2);
            System.out.println(biFunction.apply(nums, k));
            sc.close();
        } catch (Exception e) {
            System.out.println("Exception occurred : " + e.getMessage());
            e.printStackTrace();
        }
    }
}
