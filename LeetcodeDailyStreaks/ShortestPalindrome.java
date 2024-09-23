import java.util.Scanner;
import java.util.function.Function;

public class ShortestPalindrome {
    boolean flag = true;
    String tempStrToBeRemoved = "";

    public String shortestPalindrome(String s) {
        StringBuilder builder = new StringBuilder(s);
        if (this.isPalindrome(builder))
            return s;

        for (int i = 0; i < s.length(); i++) {
            builder.reverse();
            if (flag && i > 0) {
                if (tempStrToBeRemoved.charAt(tempStrToBeRemoved.length() - 1) != s.charAt(i))
                    flag = false;
            }
            if (flag)
                tempStrToBeRemoved += String.valueOf(s.charAt(i));
            String appendedStr = String.valueOf(s.charAt(i)).concat(builder.toString());
            builder.delete(0, builder.length());
            builder.append(appendedStr);
            if (this.isPalindrome(builder))
                return this.getResult(builder);
        }
        return this.getResult(builder);
    }

    private boolean isPalindrome(StringBuilder string) {
        String originalStr = string.toString();
        return originalStr.equals(string.reverse().toString());
    }

    private String getResult(StringBuilder builder) {
        if (builder.length() % 2 == 1)
            return builder.toString();
        int halfLength = builder.length() / 2;
        return builder.delete(halfLength, halfLength + tempStrToBeRemoved.length()).toString();
    }

    public static void main(String[] args) {
        Scanner sc;
        try {
            sc = new Scanner(System.in);
            System.out.println("Enter S value : ");
            String s = sc.nextLine();
            Function<String, String> function = (input) -> new ShortestPalindrome().shortestPalindrome(input);
            System.out.println(function.apply(s));
            sc.close();
        } catch (Exception e) {
            System.out.println("Exception occurred : " + e.getMessage());
            e.printStackTrace();
        }
    }
}
