import java.util.Scanner;
import java.util.Stack;
import java.util.function.Function;

public class ClearDigits {
    Stack<Character> stack;

    public ClearDigits() {
        stack = new Stack<>();
    }

    public String clearDigits(String s) {
        for (int i = 0; i < s.length(); i++) {
            if (Character.isDigit(s.charAt(i)))
                stack.pop();
            else
                stack.push(s.charAt(i));
        }
        if(stack.isEmpty())
            return "";
        return stack.stream().map(c -> String.valueOf(c)).reduce((a, b) -> a.concat(b)).get();
    }

    public static void main(String[] args) {
        Scanner sc;
        try {
            sc = new Scanner(System.in);
            System.out.println("Enter S value : ");
            String s = sc.next();
            Function<String, String> function = (input) -> new ClearDigits().clearDigits(input);
            System.out.println(function.apply(s));
            sc.close();
        } catch (Exception e) {
            System.out.println("Exception occurred : " + e.getMessage());
            e.printStackTrace();
        }
    }
}
