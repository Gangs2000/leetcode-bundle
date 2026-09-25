import java.util.Scanner;
import java.util.function.Function;

class RemovingMinimumandMaximumFromArray {
    public int minimumDeletions(int[] nums) {
        int minElement = Integer.MAX_VALUE, maxElement = Integer.MIN_VALUE, minIndex = 0, maxIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            if (minElement > nums[i]) {
                minElement = nums[i];
                minIndex = i;
            }
            if (maxElement < nums[i]) {
                maxElement = nums[i];
                maxIndex = i;
            }
        }
        // Consider all four strategies
        int bothFromFront = Math.max(minIndex, maxIndex) + 1;
        int bothFromBack = nums.length - Math.min(minIndex, maxIndex);
        int minFromFrontMaxFromBack = (minIndex + 1) + (nums.length - maxIndex);
        int minFromBackMaxFromFront = (nums.length - minIndex) + (maxIndex + 1);

        return Math.min(Math.min(bothFromFront, bothFromBack),
                Math.min(minFromFrontMaxFromBack, minFromBackMaxFromFront));
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
            Function<int[], Integer> function = new RemovingMinimumandMaximumFromArray()::minimumDeletions;
            System.out.println(function.apply(nums));
            sc.close();
        } catch (Exception e) {
            System.out.println("Exception occurred : " + e.getMessage());
            e.printStackTrace();
        }
    }
}