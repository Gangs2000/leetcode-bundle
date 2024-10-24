import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.function.Function;

public class SplitaStringIntotheMaxNumberofUniqueSubstrings {
    public int maxUniqueSplit(String s) {
        return this.backTracking(0, new HashSet<>(), s);
    }

    private int backTracking(int start, Set<String> set, String s) {
        if (start == s.length())
            return 0;
        int maxCount = 0;
        for (int end = start + 1; end <= s.length(); end++) {
            String subString = s.substring(start, end);
            if (!set.contains(subString)) {
                set.add(subString);
                maxCount = Math.max(maxCount, (1 + this.backTracking(end, set, s)));
                set.remove(subString);
            }
        }
        return maxCount;
    }

    public static void main(String[] args) {
        Scanner sc;
        try {
            sc = new Scanner(System.in);
            System.out.println("Enter a String : ");
            String s = sc.nextLine();
            Function<String, Integer> function = (input) -> new SplitaStringIntotheMaxNumberofUniqueSubstrings()
                    .maxUniqueSplit(input);
            System.out.println(function.apply(s));
            sc.close();
        } catch (Exception e) {
            System.out.println("Exception occurred : " + e.getMessage());
            e.printStackTrace();
        }
    }
}
