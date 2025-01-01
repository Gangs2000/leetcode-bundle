import java.util.Scanner;
import java.util.function.Function;

public class MaximumScoreAfterSplittingaString {
    long countOfZeros = 0, countOfOnes = 0;
    int maxScore = Integer.MIN_VALUE;

    public int maxScore(String s) {
        this.normalApproach(s);
        this.optimalApproach(s);
        return maxScore;
    }

    private void normalApproach(String s) {
        char[] chars = s.toCharArray();
        for (char character : chars) {
            if (character == '1')
                countOfOnes++;
        }
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == '1')
                countOfOnes--;
            if (s.charAt(i) == '0')
                countOfZeros++;
            maxScore = Math.max(maxScore, (int) (countOfZeros + countOfOnes));
        }
    }

    private void optimalApproach(String s) {
        maxScore = Integer.MIN_VALUE;
        for (int i = 0; i < s.length() - 1; i++) {
            String prefix = s.substring(0, i + 1).replaceAll("1", "");
            String suffix = s.substring(i + 1, s.length()).replaceAll("0", "");
            maxScore = Math.max(maxScore, (prefix.length() + suffix.length()));
        }
    }

    public static void main(String[] args) {
        Scanner sc;
        try {
            sc = new Scanner(System.in);
            System.out.println("Enter a String : ");
            String s = sc.nextLine();
            Function<String, Integer> function = (input) -> new MaximumScoreAfterSplittingaString().maxScore(input);
            System.out.println(function.apply(s));
            sc.close();
        } catch (Exception e) {
            System.out.println("Exception occurred : " + e.getMessage());
            e.printStackTrace();
        }
    }
}
