import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;
import java.util.function.Function;

public class MinimumInsertionstoBalanceaParenthesesString {
    public int minInsertions(String s) {
        int index = 0;
        StringBuilder str = new StringBuilder();
        while (index < s.length()) {
            if (s.charAt(index) == ')')
                str.append(s.charAt(index));
            else {
                if (index < s.length() - 2 && s.charAt(index) == '(' && s.charAt(index + 1) == ')'
                        && s.charAt(index + 2) == ')')
                    index += 2;
                else
                    str.append(s.charAt(index));
            }
            index++;
        }
        return this.paranthesisInsertion(str.toString());
    }

    private int paranthesisInsertion(String str) {
        int insertCount = 0;
        Map<String, Integer> considerMatches = new HashMap<>();
        considerMatches.put("()", 1);
        considerMatches.put("))", 1);
        considerMatches.put("(", 2);
        considerMatches.put(")", 2);
        int index = 0;
        System.out.println(str.toString());
        while (index < str.length()) {
            if (index < str.length() - 1 && considerMatches.containsKey(str.subSequence(index, index + 2))) {
                insertCount += considerMatches.get(str.substring(index, index + 2));
                index += 2;
            } else {
                insertCount += considerMatches.get(String.valueOf(str.charAt(index)));
                index++;
            }
        }
        return insertCount;
    }

    public static void main(String[] args) {
        Scanner sc;
        try {
            sc = new Scanner(System.in);
            // System.out.println("Enter String value : ");
            String s = "(()))()))";
            Function<String, Integer> function = new MinimumInsertionstoBalanceaParenthesesString()::minInsertions;
            System.out.println(function.apply(s));
            sc.close();
        } catch (Exception e) {
            System.out.println("Exception occurred : " + e.getMessage());
            e.printStackTrace();
        }
    }
}
