import java.util.Scanner;
import java.util.function.Function;

public class MinimumOperationstoSortaString {
    public int minOperations(String s) {
        char minChar = Character.MAX_VALUE;
        char maxChar = Character.MIN_VALUE;
        char minInteriorChar = Character.MAX_VALUE;
        char maxInteriorChar = Character.MIN_VALUE;
        boolean isSorted = true;
        int length = s.length();

        for (int i = 0; i < length; i++) {
            char current = s.charAt(i);
            minChar = (char) Math.min(minChar, current);
            maxChar = (char) Math.max(maxChar, current);

            if (i > 0 && s.charAt(i - 1) > current)
                isSorted = false;

            if (i > 0 && i < length - 1) {
                minInteriorChar = (char) Math.min(minInteriorChar, current);
                maxInteriorChar = (char) Math.max(maxInteriorChar, current);
            }
        }

        if (isSorted) {
            return 0;
        }
        if (length == 2) {
            return -1;
        }
        if (s.charAt(0) == minChar || s.charAt(length - 1) == maxChar) {
            return 1;
        }
        return minInteriorChar == minChar || maxInteriorChar == maxChar ? 2 : 3;
    }

    public static void main(String[] args) {
        Scanner sc;
        try {
            sc = new Scanner(System.in);
            System.out.println("Enter String value : ");
            String s = sc.nextLine();
            Function<String, Integer> function = new MinimumOperationstoSortaString()::minOperations;
            System.out.println(function.apply(s));
            sc.close();
        } catch (Exception e) {
            System.out.println("Exception occurred : " + e.getMessage());
            e.printStackTrace();
        }
    }
}
