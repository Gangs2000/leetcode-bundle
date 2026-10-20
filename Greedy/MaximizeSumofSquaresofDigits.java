import java.util.Scanner;
import java.util.function.BiFunction;

public class MaximizeSumofSquaresofDigits {
    public String maxSumOfSquares(int num, int sum) {
        StringBuilder result = new StringBuilder();
        int lengthTillNow = 0;
        while (lengthTillNow < num && sum >= 0) {
            int minValue = Math.min(9, sum);
            sum -= minValue;
            result.append(minValue);
            lengthTillNow++;
        }
        return sum > 0 ? "" : result.toString();
    }

    public static void main(String[] args) {
        Scanner sc;
        try {
            sc = new Scanner(System.in);
            System.out.println("Enter num and sum values : ");
            int num = sc.nextInt(), sum = sc.nextInt();
            BiFunction<Integer, Integer, String> biFunction = new MaximizeSumofSquaresofDigits()::maxSumOfSquares;
            System.out.println(biFunction.apply(num, sum));
            sc.close();
        } catch (Exception e) {
            System.out.println("Exception occurred : " + e.getMessage());
            e.printStackTrace();
        }
    }
}
