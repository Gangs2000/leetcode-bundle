import java.util.Scanner;
import java.util.function.BiFunction;

public class RemoveAllOccurrencesofaSubstring {
    public String removeOccurrences(String s, String part) {
        StringBuilder builder = new StringBuilder(s);
        if (s.length() < part.length())
            return s;
        boolean matchFound = false;
        while (builder.length() >= part.length() && !matchFound) {
            for (int i = 0; i <= builder.length() - part.length(); i++) {
                String currentStr = builder.substring(i, i + part.length());
                if (currentStr.equals(part)) {
                    builder.delete(i, i + part.length());
                    matchFound = true;
                    break;
                }
            }
            matchFound = !matchFound;
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        Scanner sc;
        try {
            sc = new Scanner(System.in);
            System.out.println("Enter a String and Part values : ");
            String string = sc.next(), part = sc.next();
            BiFunction<String, String, String> biFunction = (input1, input2) -> new RemoveAllOccurrencesofaSubstring()
                    .removeOccurrences(input1, input2);
            System.out.println(biFunction.apply(string, part));
            sc.close();
        } catch (Exception e) {
            System.out.println("Exception occurred : " + e.getMessage());
            e.printStackTrace();
        }
    }
}
