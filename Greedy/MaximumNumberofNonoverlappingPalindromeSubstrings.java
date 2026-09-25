import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.function.BiFunction;

public class MaximumNumberofNonoverlappingPalindromeSubstrings {
    public int maxPalindromes(String s, int k) {
        int pointer = 0, nonOverlappingPalindromeCount = 0;
        Map<String, Boolean> palindromeMap = new HashMap<>();
        while (pointer < s.length()) {
            if ((pointer + k <= s.length()) && (palindromeMap.getOrDefault(s.substring(pointer, pointer + k), false)
                    || this.palindromeHelper(s.substring(pointer, pointer + k), palindromeMap))) {
                pointer = pointer + k;
                nonOverlappingPalindromeCount++;
                continue;
            }
            if ((pointer + k + 1 <= s.length())
                    && (palindromeMap.getOrDefault(s.substring(pointer, pointer + k + 1), false)
                            || this.palindromeHelper(s.substring(pointer, pointer + k + 1), palindromeMap))) {
                pointer = pointer + k + 1;
                nonOverlappingPalindromeCount++;
                continue;
            }
            pointer++;
        }
        return nonOverlappingPalindromeCount;
    }

    private boolean palindromeHelper(String s, Map<String, Boolean> palindromeMap) {
        for (int i = 0; i < s.length() / 2; i++) {
            if (s.charAt(i) != s.charAt(s.length() - i - 1)) {
                palindromeMap.putIfAbsent(s, false);
                return false;
            }
        }
        palindromeMap.putIfAbsent(s, true);
        return true;
    }

    public static void main(String[] args) {
        Scanner sc;
        try {
            sc = new Scanner(System.in);
            System.out.println("Enter S and K values : ");
            String s = sc.nextLine();
            int k = sc.nextInt();
            BiFunction<String, Integer, Integer> biFunction = new MaximumNumberofNonoverlappingPalindromeSubstrings()::maxPalindromes;
            System.out.println(biFunction.apply(s, k));
            sc.close();
        } catch (Exception e) {
            System.out.println("Exception occurred : " + e.getMessage());
            e.printStackTrace();
        }
    }
}
