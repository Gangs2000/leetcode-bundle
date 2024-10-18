import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;

public class CountNumberofMaximumBitwiseORSubsets {

    public int countMaxOrSubsets(int[] nums) {
        int maxValue = this.findMaxORInArr(nums);
        return this.backTracking(maxValue, 0, nums, new LinkedList<>());
    }

    private int backTracking(int maxOR, int index, int[] nums, List<Integer> list) {
        if (index == nums.length) {
            if (!list.isEmpty()) {
                int currentOR = list.stream().reduce((a, b) -> (a | b)).get();
                return (currentOR == maxOR) ? (1) : (0);
            }
            return 0;
        }
        int take = 0, dontTake = 0;
        list.add(nums[index]);
        take += this.backTracking(maxOR, index + 1, nums, list);
        list.remove(list.size() - 1);
        dontTake += this.backTracking(maxOR, index + 1, nums, list);
        return take + dontTake;
    }

    private int findMaxORInArr(int[] nums) {
        int currentOR = 0, maxOR = Integer.MIN_VALUE;
        for (int number : nums) {
            currentOR |= number;
            maxOR = Math.max(maxOR, currentOR);
        }
        return maxOR;
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
            Function<int[], Integer> function = (input) -> new CountNumberofMaximumBitwiseORSubsets()
                    .countMaxOrSubsets(input);
            System.out.println(function.apply(nums));
            sc.close();

        } catch (Exception e) {
            System.out.println("Exception occurred : " + e.getMessage());
            e.printStackTrace();
        }
    }
}
