import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.BiFunction;
import java.util.function.Function;

public class MinimumEqualSumofTwoArraysAfterReplacingZeros {
    public long minSum(int[] nums1, int[] nums2) {
        Function<int[], List<Long>> function = (arr) -> this.getSumAndCountOfZeroes(arr);
        List<Long> num1Result = function.apply(nums1);
        List<Long> num2Result = function.apply(nums2);
        if (num1Result.get(0) == 0 && num2Result.get(0) == 0)
            return (num1Result.get(1) != num2Result.get(1)) ? (-1) : (num1Result.get(1));
        if (num1Result.get(0) > 0 && num2Result.get(0) > 0)
            return Math.max(this.findOutFirstPossibleResult(num1Result, num2Result),
                    this.findOutFirstPossibleResult(num2Result, num1Result));
        else
            return (num1Result.get(0) > 0) ? (this.findOutSecondPossibleResult(num1Result, num2Result))
                    : (this.findOutSecondPossibleResult(num2Result, num1Result));
    }

    private Long findOutFirstPossibleResult(List<Long> list1, List<Long> list2) {
        long totalSum = list1.get(1) + list1.get(0);
        long remaningSum = totalSum - list2.get(1);
        return (remaningSum >= list2.get(0)) ? (totalSum) : (-1);
    }

    private long findOutSecondPossibleResult(List<Long> list1, List<Long> list2) {
        return (list1.get(1) + list1.get(0) <= list2.get(1)) ? (list2.get(1)) : (-1);
    }

    private List<Long> getSumAndCountOfZeroes(int[] array) {
        long zeroCount = 0L, totalSum = 0L;
        for (int number : array) {
            if (number == 0)
                zeroCount++;
            totalSum += number;
        }
        return Arrays.asList(zeroCount, totalSum);
    }

    public static void main(String[] args) {
        Scanner sc;
        int[] nums1, nums2;
        try {
            sc = new Scanner(System.in);
            System.out.println("Enter length of nums1 and nums2 array : ");
            int num1Len = sc.nextInt();
            int num2Len = sc.nextInt();
            nums1 = new int[num1Len];
            for (int i = 0; i < num1Len; i++)
                nums1[i] = sc.nextInt();
            nums2 = new int[num2Len];
            for (int i = 0; i < num2Len; i++)
                nums2[i] = sc.nextInt();
            BiFunction<int[], int[], Long> biFunction = (arr1,
                    arr2) -> new MinimumEqualSumofTwoArraysAfterReplacingZeros().minSum(arr1, arr2);
            System.out.println(biFunction.apply(nums1, nums2));
            sc.close();
        } catch (Exception e) {
            System.out.println("Exception occurred : " + e.getMessage());
            e.printStackTrace();
        }
    }
}
