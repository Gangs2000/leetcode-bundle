import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.function.BiFunction;

public class MaximumSumofDistinctSubarraysWithLengthK {
    Map<Integer, Integer> frequencyMapper;
    long currentWindowSum = 0, maximumSum = Long.MIN_VALUE;

    public MaximumSumofDistinctSubarraysWithLengthK() {
        frequencyMapper = new HashMap<>();
    }

    public long maximumSubarraySum(int[] nums, int k) {
        // Initial window calculation
        this.initialWindowSum(nums, k);
        if (nums.length != k) {
            for (int i = 1; i <= nums.length - k; i++) {
                int valueToBeSubtracted = nums[i - 1];
                int valueToBeAdded = nums[i + k - 1];
                currentWindowSum -= valueToBeSubtracted;
                frequencyMapper.put(valueToBeSubtracted, frequencyMapper.get(valueToBeSubtracted) - 1);
                if (frequencyMapper.get(valueToBeSubtracted) == 0)
                    frequencyMapper.remove(valueToBeSubtracted);
                currentWindowSum += valueToBeAdded;
                frequencyMapper.putIfAbsent(valueToBeAdded, 0);
                frequencyMapper.put(valueToBeAdded, frequencyMapper.get(valueToBeAdded) + 1);
                if (frequencyMapper.size() == k)
                    maximumSum = Math.max(maximumSum, currentWindowSum);
            }
        }
        return (maximumSum == Long.MIN_VALUE) ? (0) : (maximumSum);
    }

    private void initialWindowSum(int[] nums, int k) {
        // Initial window calculation
        for (int i = 0; i < k; i++) {
            currentWindowSum += nums[i];
            frequencyMapper.putIfAbsent(nums[i], 0);
            frequencyMapper.put(nums[i], frequencyMapper.get(nums[i]) + 1);
        }
        if (frequencyMapper.size() == k)
            maximumSum = Math.max(maximumSum, currentWindowSum);
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
            BiFunction<int[], Integer, Long> biFunction = (input1,
                    input2) -> new MaximumSumofDistinctSubarraysWithLengthK().maximumSubarraySum(input1, input2);
            System.out.println(biFunction.apply(nums, k));
            sc.close();
        } catch (Exception e) {
            System.out.println("Exception occurred : " + e.getMessage());
            e.printStackTrace();
        }
    }
}
