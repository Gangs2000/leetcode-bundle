import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.IntStream;

public class SumofSortableIntegers {
    public int sortableIntegers(int[] nums) {
        List<Integer> divisors = IntStream.rangeClosed(1, nums.length).filter((i) -> nums.length % i == 0).boxed()
                .toList();
        int result = 0;
        for (int index : divisors) {
            int prevMax = -1;
            boolean isValid = true;
            for (int i = 0; i < nums.length; i = i + index) {
                List<Integer> subArr = this.checkCyclicAndMinAndMax(i, i + index - 1, nums);
                if (subArr.get(2) > 1 || subArr.get(0) < prevMax) {
                    isValid = false;
                    break;
                }
                prevMax = subArr.get(1);
            }
            if (isValid)
                result += index;
        }
        return result;
    }

    private List<Integer> checkCyclicAndMinAndMax(int start, int end, int[] nums) {
        int minValue = Integer.MAX_VALUE, maxValue = Integer.MIN_VALUE, violationCount = 0;
        for (int i = start; i <= end; i++) {
            minValue = Math.min(minValue, nums[i]);
            maxValue = Math.max(maxValue, nums[i]);
            if ((i == end && nums[end] > nums[start]) || (i != end && nums[i] > nums[i + 1]))
                violationCount++;
        }
        return Arrays.asList(minValue, maxValue, violationCount);
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
            Function<int[], Integer> function = new SumofSortableIntegers()::sortableIntegers;
            System.out.println(function.apply(nums));
            sc.close();
        } catch (Exception e) {
            System.out.println("Exception occurred : " + e.getMessage());
            e.printStackTrace();
        }
    }
}
