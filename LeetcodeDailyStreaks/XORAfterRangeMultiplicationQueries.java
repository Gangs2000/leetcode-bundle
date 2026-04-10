package LeetcodeDailyStreaks;

import java.util.Scanner;
import java.util.function.BiFunction;

public class XORAfterRangeMultiplicationQueries {
    public int xorAfterQueries(int[] nums, int[][] queries) {
        for (int i = 0; i < queries.length; i++) {
            int leftPointer = queries[i][0], rightPointer = queries[i][1], incrementer = queries[i][2],
                    multiplier = queries[i][3];
            this.multiplyArray(leftPointer, rightPointer, incrementer, multiplier, nums);
        }
        return (int) this.xorOfNumsArray(nums);
    }

    private void multiplyArray(int leftPointer, int rightPointer, int incrementer, int multiplier, int[] nums) {
        final int MOD_VALUE = (int) (Math.pow(10, 9) + 7);
        while (leftPointer <= rightPointer) {
            nums[leftPointer] = (int) (((long) nums[leftPointer] * multiplier) % MOD_VALUE);
            leftPointer = leftPointer + incrementer;
        }
    }

    private int xorOfNumsArray(int[] nums) {
        int xor = 0;
        for (int i = 0; i < nums.length; i++)
            xor = xor ^ nums[i];
        return xor;
    }

    public static void main(String[] args) {
        Scanner sc;
        int[] nums;
        int[][] queries;
        try {
            sc = new Scanner(System.in);
            System.out.println("Enter length of nums and queries array : ");
            int numLength = sc.nextInt(), queryLength = sc.nextInt();
            nums = new int[numLength];
            for (int i = 0; i < numLength; i++)
                nums[i] = sc.nextInt();
            queries = new int[queryLength][4];
            for (int i = 0; i < queryLength; i++) {
                queries[i][0] = sc.nextInt();
                queries[i][1] = sc.nextInt();
                queries[i][2] = sc.nextInt();
                queries[i][3] = sc.nextInt();
            }
            BiFunction<int[], int[][], Integer> biFunction = new XORAfterRangeMultiplicationQueries()::xorAfterQueries;
            System.out.println(biFunction.apply(nums, queries));
            sc.close();
        } catch (Exception e) {
            System.out.println("Exception occurred : " + e.getMessage());
            e.printStackTrace();
        }
    }
}
