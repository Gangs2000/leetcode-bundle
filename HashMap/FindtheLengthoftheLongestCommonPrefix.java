import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class FindtheLengthoftheLongestCommonPrefix {
    Set<Integer> allPossibles;
    int maxLength = Integer.MIN_VALUE;

    public FindtheLengthoftheLongestCommonPrefix() {
        allPossibles = new HashSet<>();
    }

    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        for (int number : arr1)
            this.findAllDigits(number);
        for (int number : arr2) {
            this.findAllDigits(number, true);
        }
        return maxLength == Integer.MIN_VALUE ? 0 : maxLength;
    }

    private void findAllDigits(int digit, boolean... flag) {
        while (digit > 0) {
            if (flag != null && flag.length > 0) {
                if (allPossibles.contains(digit)) {
                    int currentLength = String.valueOf(digit).length();
                    maxLength = Math.max(currentLength, maxLength);
                }
            }
            if (flag.length == 0)
                allPossibles.add(digit);
            digit /= 10;
        }
    }

    public static void main(String[] args) {
        Scanner sc;
        int[] arr1, arr2;
        try {
            sc = new Scanner(System.in);
            System.out.println("Enter length of num1 and num2 arrays : ");
            int arr1Length = sc.nextInt(), arr2Length = sc.nextInt();
            arr1 = new int[arr1Length];
            arr2 = new int[arr2Length];
            for (int i = 0; i < arr1Length; i++)
                arr1[i] = sc.nextInt();
            for (int i = 0; i < arr2Length; i++)
                arr2[i] = sc.nextInt();
            java.util.function.BiFunction<int[], int[], Integer> biFunction = new FindtheLengthoftheLongestCommonPrefix()::longestCommonPrefix;
            System.out.println(biFunction.apply(arr1, arr2));
            sc.close();
        } catch (Exception e) {
            System.out.println("Exception occurred : " + e.getMessage());
            e.printStackTrace();
        }
    }
}
