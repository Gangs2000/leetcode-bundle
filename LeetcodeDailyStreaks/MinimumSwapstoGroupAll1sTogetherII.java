import java.util.Scanner;
import java.util.function.BiConsumer;
import java.util.function.Function;

public class MinimumSwapstoGroupAll1sTogetherII {
    int totalOnes = 0;

    public int minSwaps(int[] nums) {
        int[] rotatedArr = new int[nums.length + nums.length];
        BiConsumer<int[], int[]> consumer = (numArr, rotArr) -> this.createRotatedArray(numArr, rotArr);
        consumer.accept(nums, rotatedArr);
        Function<int[], Integer> function = (rotArr) -> this.findMinSwap(rotArr);
        return function.apply(rotatedArr);
    }

    private void createRotatedArray(int[] nums, int[] rotatedArr) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1)
                totalOnes++;
            rotatedArr[i] = nums[i];
            rotatedArr[i + nums.length] = nums[i];
        }
    }

    private int findMinSwap(int[] array) {
        int maxOnes = 0, currentOnes = 0;
        for (int i = 0; i < totalOnes; i++) {
            if (array[i] == 1) {
                maxOnes++;
                currentOnes++;
            }
        }
        for (int i = totalOnes; i < array.length; i++) {
            if (array[i] == 1)
                currentOnes++;
            if (array[i - totalOnes] == 1)
                currentOnes--;
            maxOnes = Math.max(maxOnes, currentOnes);
        }
        return totalOnes - maxOnes;
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
            Function<int[], Integer> function = (numArr) -> new MinimumSwapstoGroupAll1sTogetherII().minSwaps(numArr);
            System.out.println(function.apply(nums));
            sc.close();
        } catch (Exception e) {
            System.out.println("Exception occurred : " + e.getMessage());
            e.printStackTrace();
        }
    }
}
