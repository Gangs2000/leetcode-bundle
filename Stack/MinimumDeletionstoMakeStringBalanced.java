import java.util.Scanner;
import java.util.Stack;
import java.util.function.Function;

public class MinimumDeletionstoMakeStringBalanced {
    int minDeletionCount = 0;
    Stack<Character> stack;

    public MinimumDeletionstoMakeStringBalanced() {
        stack = new Stack<>();
    }

    public int minimumDeletions(String s) {
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'b')
                stack.push(s.charAt(i));
            else if (s.charAt(i) == 'a' && !stack.isEmpty()) {
                stack.pop();
                minDeletionCount++;
            }
        }
        return minDeletionCount;
    }

    public static void main(String[] args) {
        Scanner sc;
        try {
            sc = new Scanner(System.in);
            System.out.println("Enter S value : ");
            String s = sc.nextLine();
            Function<String, Integer> function = (input) -> new MinimumDeletionstoMakeStringBalanced()
                    .minimumDeletions(input);
            System.out.println(function.apply(s));
            sc.close();
        } catch (Exception e) {
            System.out.println("Exception occurred : " + e.getMessage());
            e.printStackTrace();
        }
    }
}
