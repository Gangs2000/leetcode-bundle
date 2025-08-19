import java.util.Scanner;
import java.util.function.Function;

public class DeleteCharacterstoMakeFancyString {
    StringBuilder resultString = new StringBuilder();

    public String makeFancyString(String s) {
        if (s.length() < 3)
            return s;
        int leftPointer = 0;
        while (leftPointer <= s.length() - 3) {
            char firstPosition = s.charAt(leftPointer), secondPosition = s.charAt(leftPointer + 1),
                    thirdPosition = s.charAt(leftPointer + 2);
            if (!(firstPosition == secondPosition && secondPosition == thirdPosition && firstPosition == thirdPosition))
                resultString.append(s.charAt(leftPointer));
            leftPointer++;
        }
        if (resultString.isEmpty())
            return s.substring(0, 2);
        char lastAppendedChar = resultString.toString().charAt(resultString.length() - 1);
        if (lastAppendedChar != s.charAt(leftPointer) || lastAppendedChar != s.charAt(leftPointer + 1))
            resultString.append(s.substring(leftPointer));

        return resultString.toString();
    }

    public static void main(String[] args) {
        Scanner sc;
        try {
            sc = new Scanner(System.in);
            System.out.println("Enter S value : ");
            String s = sc.next();
            Function<String, String> function = (input) -> new DeleteCharacterstoMakeFancyString()
                    .makeFancyString(input);
            System.out.println(function.apply(s));
            sc.close();
        } catch (Exception e) {
            System.out.println("Exception occurred : " + e.getMessage());
            e.printStackTrace();
        }
    }
}
