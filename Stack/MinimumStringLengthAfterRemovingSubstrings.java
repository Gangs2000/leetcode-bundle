import java.util.Scanner;
import java.util.Stack;
import java.util.function.Function;

public class MinimumStringLengthAfterRemovingSubstrings {
    Stack<Character> stack;

    public MinimumStringLengthAfterRemovingSubstrings() {
        stack = new Stack<>();
    }

    public int minLength(String s) {
        for (int i = 0; i < s.length(); i++) {
            if (!stack.isEmpty()) {
                if ((s.charAt(i) == 'B' && stack.peek() == 'A') || (s.charAt(i) == 'D' && stack.peek() == 'C'))
                    stack.pop();
                else
                    stack.push(s.charAt(i));
            }
            else
                stack.push(s.charAt(i));
        }
        return stack.size();
    }

    public static void main(String[] args) {
        Scanner sc;
        try {
            sc = new Scanner(System.in);
            System.out.println("Enter a String : ");
            String string = sc.next();
            Function<String, Integer> function = (input) -> new MinimumStringLengthAfterRemovingSubstrings()
                    .minLength(input);
            System.out.println(function.apply(string));
            sc.close();
        } catch (Exception e) {
            System.out.println("Exception occurred : " + e.getMessage());
            e.printStackTrace();
        }
    }
}
