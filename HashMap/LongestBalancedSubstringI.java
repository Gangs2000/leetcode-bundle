import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Function;

public class LongestBalancedSubstringI {
    int[] freqArr;
    int longestBalanced = Integer.MIN_VALUE;

    public LongestBalancedSubstringI() {
        freqArr = new int[26];
    }

    public int longestBalanced(String s) {
        for (int i = 0; i < s.length(); i++) {
            // Reset arr every time
            Arrays.fill(freqArr, 0);
            for (int j = i; j < s.length(); j++) {
                int count = s.charAt(j) - 'a';
                freqArr[count]++;
                if (this.isValid(freqArr, freqArr[count]))
                    longestBalanced = Math.max(longestBalanced, j - i + 1);
            }
        }
        return longestBalanced;
    }

    private boolean isValid(int[] freqArr, int currentCount) {
        for (int count : freqArr) {
            if (count > 0 && count != currentCount)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc;
        try {
            sc = new Scanner(System.in);
            System.out.println("Enter String value : ");
            String string = sc.nextLine();
            Function<String, Integer> function = (input) -> new LongestBalancedSubstringI().longestBalanced(input);
            System.out.println(function.apply(string));
            sc.close();
        } catch (Exception e) {
            System.out.println("Exception occurred : " + e.getMessage());
            e.printStackTrace();
        }
    }
}
