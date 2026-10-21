import java.util.Scanner;
import java.util.Stack;
import java.util.function.Function;

public class ScoreofParentheses {
    Stack<Integer> stack;

    public ScoreofParentheses() {
        stack = new Stack<>();
    }

    public int scoreOfParentheses(String s) {
        int score = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(score);
                score = 0;
            } else {
                if (s.charAt(i - 1) == '(')
                    score = stack.peek() + 1;
                else
                    score = stack.peek() + 2 * score;
                stack.pop();
            }
        }
        return score;
    }

    public static void main(String[] args) {
        Scanner sc;
        try {
            sc = new Scanner(System.in);
            System.out.println("Enter String value : ");
            String s = sc.next();
            Function<String, Integer> function = new ScoreofParentheses()::scoreOfParentheses;
            System.out.println(function.apply(s));
            sc.close();
        } catch (Exception e) {
            System.out.println("Exception occurred : " + e.getMessage());
            e.printStackTrace();
        }
    }
}
