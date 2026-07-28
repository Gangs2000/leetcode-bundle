package LeetcodeDailyStreaks;

import java.util.Scanner;
import java.util.function.Function;

public class ConcatenateNonZeroDigitsandMultiplybySumI {
    public long sumAndMultiply(int n) {
        StringBuilder nonZeroes = new StringBuilder();
        int sum = 0;
        while (n > 0) {
            int remaining = n % 10;
            if (remaining != 0) {
                nonZeroes.append(remaining);
                sum += remaining;
            }
            n /= 10;
        }
        nonZeroes.reverse();
        if (nonZeroes.length() == 0)
            return 0l;
        return Long.valueOf(nonZeroes.toString()) * sum;
    }

    public static void main(String[] args) {
        Scanner sc;
        try {
            sc = new Scanner(System.in);
            System.out.println("Enter value of N : ");
            int n = sc.nextInt();
            Function<Integer, Long> function = new ConcatenateNonZeroDigitsandMultiplybySumI()::sumAndMultiply;
            System.out.println(function.apply(n));
            sc.close();
        } catch (Exception e) {
            System.out.println("Exception occurred : " + e.getMessage());
            e.printStackTrace();
        }
    }
}
