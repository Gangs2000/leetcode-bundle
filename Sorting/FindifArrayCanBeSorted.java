import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Function;

public class FindifArrayCanBeSorted {
    Map<Integer, Integer> binaryMap;

    public FindifArrayCanBeSorted() {
        binaryMap = new HashMap<>();
    }

    public boolean canSortArray(int[] nums) {
        this.mapBinary1BitCount(nums);
        return this.sortElements(nums);
    }

    private void mapBinary1BitCount(int[] nums) {
        for (int decimal : nums) {
            int bitOneCount = 0, copy = decimal;
            while (decimal > 0) {
                int reminder = decimal % 2;
                if (reminder == 1)
                    bitOneCount++;
                decimal /= 2;
            }
            binaryMap.putIfAbsent(copy, bitOneCount);
        }
    }

    private boolean sortElements(int[] nums) {
        boolean swappedAtLeastOnces = false, isArraySorted = true;
        while (!swappedAtLeastOnces) {
            for (int i = 1; i < nums.length; i++) {
                if (nums[i - 1] != nums[i]) {
                    if (nums[i - 1] > nums[i]) {
                        if (binaryMap.get(nums[i - 1]) == binaryMap.get(nums[i])) {
                            swappedAtLeastOnces = true;
                            isArraySorted = false;
                            // Swap adjacent elements
                            nums[i - 1] = nums[i - 1] + nums[i];
                            nums[i] = nums[i - 1] - nums[i];
                            nums[i - 1] = nums[i - 1] - nums[i];
                        } else
                            isArraySorted = false;
                    }
                }
            }
            // Check if array is sorted
            if (isArraySorted)
                return true;
            // SwappedAtLeastOnces indicates no swap happened
            if (!swappedAtLeastOnces)
                return false;
            swappedAtLeastOnces = false;
            isArraySorted = true;
        }
        return true;
    }

    public static void main(String[] args) {
        int[] nums;
        Scanner sc;
        try {
            sc = new Scanner(System.in);
            System.out.println("Enter length of nums array : ");
            int length = sc.nextInt();
            nums = new int[length];
            for (int i = 0; i < length; i++)
                nums[i] = sc.nextInt();
            Function<int[], Boolean> function = (input) -> new FindifArrayCanBeSorted().canSortArray(input);
            System.out.println(function.apply(nums));
            sc.close();
        } catch (Exception e) {
            System.out.println("Exception occurred : " + e.getMessage());
            e.printStackTrace();
        }
    }
}
