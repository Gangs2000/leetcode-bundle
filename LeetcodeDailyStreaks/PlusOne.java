import java.util.Arrays;
import java.util.Scanner;
import java.util.function.UnaryOperator;

public class PlusOne {

    public int[] plusOne(int[] digits) {
        if (digits[digits.length - 1] != 9) {
            digits[digits.length - 1] = digits[digits.length - 1] + 1;
            return digits;
        }
        boolean isAllNines = true;
        for (int number : digits) {
            if (number != 9) {
                isAllNines = false;
                break;
            }
        }
        if (isAllNines) {
            int[] resultArr = new int[digits.length + 1];
            Arrays.fill(resultArr, 0);
            resultArr[0] = 1;
            return resultArr;
        } else {
            for (int i = digits.length - 1; i >= 0; i--) {
                int originalValue = digits[i];
                digits[i] = (originalValue == 9) ? 0 : originalValue + 1;
                if (originalValue != 9)
                    break;
            }
            return digits;
        }
    }

    public static void main(String[] args) {
        Scanner sc;
        int[] digits;
        try {
            sc = new Scanner(System.in);
            System.out.println("Enter length of digits array : ");
            int length = sc.nextInt();
            digits = new int[length];
            for (int i = 0; i < length; i++)
                digits[i] = sc.nextInt();
            UnaryOperator<int[]> unaryOperator = (input) -> new PlusOne().plusOne(input);
            int[] result = unaryOperator.apply(digits);
            for (int number : result)
                System.out.print(number + " ");
            sc.close();
        } catch (Exception e) {
            System.out.println("Exception occurred : " + e.getMessage());
            e.printStackTrace();
        }
    }
}
