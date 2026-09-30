import java.util.Scanner;
import java.util.function.Function;

public class MaximumNestingDepthofTwoValidParenthesesStrings {
    public int[] maxDepthAfterSplit(String seq) {
        int[] result = new int[seq.length()];
        int nestingDepth = 0;
        for (int i = 0; i < seq.length(); i++) {
            if (seq.charAt(i) == '(') {
                ++nestingDepth;
                result[i] = nestingDepth % 2;
            } else {
                result[i] = nestingDepth % 2;
                --nestingDepth;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc;
        try {
            sc = new Scanner(System.in);
            System.out.println("Enter sequence of String : ");
            String seq = sc.nextLine();
            Function<String, int[]> function = new MaximumNestingDepthofTwoValidParenthesesStrings()::maxDepthAfterSplit;
            System.out.println(function.apply(seq));
            sc.close();
        } catch (Exception e) {
            System.out.println("Exception occurred : " + e.getMessage());
            e.printStackTrace();
        }
    }
}
