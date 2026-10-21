import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.function.BiFunction;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FindTargetIndicesAfterSortingArray {
    public List<Integer> targetIndices(int[] nums, int target) {
        Map<Integer, Long> counterMap = Arrays.stream(nums).boxed()
                .collect(Collectors.groupingBy(num -> num, Collectors.counting()));
        Arrays.sort(nums);
        int low = 0, high = nums.length - 1, result = 0;
        while (low <= high) {
            int middle = low + (high - low) / 2;
            if (nums[middle] > target)
                high = middle - 1;
            else if (nums[middle] < target)
                low = middle + 1;
            else if (nums[middle] == target) {
                result = middle;
                high = middle - 1;
            }
        }
        long count = counterMap.getOrDefault(target, 0l);
        return IntStream.range(result, result + (int) count).boxed().toList();
    }

    public static void main(String[] args) {
        Scanner sc;
        int[] nums;
        try {
            sc = new Scanner(System.in);
            /*
             * System.out.println("Enter length of nums array : ");
             * int length = sc.nextInt();
             * nums = new int[length];
             * for (int i = 0; i < length; i++)
             * nums[i] = sc.nextInt();
             * System.out.println("Enter target value : ");
             * int target = sc.nextInt();
             */
            nums = new int[] { 1, 2, 5, 2, 3 };
            int target = 2;
            BiFunction<int[], Integer, List<Integer>> biFunction = new FindTargetIndicesAfterSortingArray()::targetIndices;
            System.out.println(biFunction.apply(nums, target));
            sc.close();
        } catch (Exception e) {
            System.out.println("Exception occurred : " + e.getMessage());
            e.printStackTrace();
        }
    }
}
