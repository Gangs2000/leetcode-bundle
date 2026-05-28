
import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Function;

public class CounttheNumberofSpecialCharactersII {

    public int numberOfSpecialChars(String word) {
        int numOfSpecialChars = 0;
        int[] lowerCase = new int[26], upperCase = new int[26];
        Arrays.fill(lowerCase, -1);
        Arrays.fill(upperCase, -1);
        for (int i = 0; i < word.length(); i++) {
            char character = word.charAt(i);
            if (Character.isLowerCase(word.charAt(i)))
                lowerCase[character - 'a'] = i;
            else if (Character.isUpperCase(word.charAt(i)) && upperCase[character - 'A'] == -1)
                upperCase[character - 'A'] = i;
        }

        for (int i = 0; i < lowerCase.length; i++) {
            if (lowerCase[i] != -1 && upperCase[i] != -1 && lowerCase[i] < upperCase[i])
                numOfSpecialChars++;
        }
        return numOfSpecialChars;
    }

    public static void main(String[] args) {
        Scanner sc;
        try {
            sc = new Scanner(System.in);
            System.out.println("Enter a Word : ");
            String word = sc.next();
            Function<String, Integer> function = new CounttheNumberofSpecialCharactersII()::numberOfSpecialChars;
            System.out.println(function.apply(word));
            sc.close();
        } catch (Exception e) {
            System.out.println("Exception occurred : " + e.getMessage());
            e.printStackTrace();
        }
    }
}
