package LeetcodeDailyStreaks;

import java.util.Scanner;

interface TrinaryOperator<T> {
    T operation(T t1, T t2);
}

public class TotalWavinessofNumbersinRange {
    int totalWaves = 0;

    public int totalWaviness(int num1, int num2) {
        for (int i = num1; i <= num2; i++) {
            if (i < 100)
                continue;
            String strToInt = String.valueOf(i);
            for (int c = 1; c < strToInt.length() - 1; c++) {
                if ((strToInt.charAt(c) - '0' > strToInt.charAt(c - 1) - '0'
                        && strToInt.charAt(c) - '0' > strToInt.charAt(c + 1) - '0') ||
                        (strToInt.charAt(c) - '0' < strToInt.charAt(c - 1) - '0'
                                && strToInt.charAt(c) - '0' < strToInt.charAt(c + 1) - '0'))
                    totalWaves++;
            }
        }
        return totalWaves;
    }

    public static void main(String[] args) {
        Scanner sc;
        try {
            sc = new Scanner(System.in);
            System.out.println("Enter num1 and num2 values : ");
            int num1 = sc.nextInt(), num2 = sc.nextInt();
            TrinaryOperator<Integer> trinaryOperator = new TotalWavinessofNumbersinRange()::totalWaviness;
            System.out.println(trinaryOperator.operation(num1, num2));
            sc.close();
        } catch (Exception e) {
            System.out.println("Exception occurred : " + e.getMessage());
            e.printStackTrace();
        }
    }
}
