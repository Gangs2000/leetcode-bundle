import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Function;

public class FindLongestSpecialSubstringThatOccursThrice {
    int maximumLength = Integer.MIN_VALUE;
    Map<String, Integer> wordMapper;

    public FindLongestSpecialSubstringThatOccursThrice() {
        wordMapper = new HashMap<>();
    }

    public int maximumLength(String s) {
        int windowSize = 1;
        while (windowSize < s.length()) {
            int pointer = 0;
            // Get current window size
            while (pointer < s.length() - (windowSize - 1)) {
                String currentString = s.substring(pointer, pointer + windowSize);
                if (this.areAllCharactersSame(currentString)) {
                    wordMapper.putIfAbsent(currentString, 0);
                    wordMapper.put(currentString, wordMapper.get(currentString) + 1);
                    // Get Max String len from map
                    if (wordMapper.get(currentString) >= 3)
                        maximumLength = Math.max(maximumLength, currentString.length());
                }
                pointer++;
            }
            windowSize++;
            wordMapper.clear();
        }
        return maximumLength == Integer.MIN_VALUE ? -1 : maximumLength;
    }

    private boolean areAllCharactersSame(String string) {
        char firstChar = string.charAt(0);
        int pointer = 0;
        while (pointer <= string.length() / 2) {
            if (string.charAt(pointer) != firstChar || string.charAt(string.length() - pointer - 1) != firstChar)
                return false;
            pointer++;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc;
        try {
            sc = new Scanner(System.in);
            System.out.println("Enter S value : ");
            String s = sc.nextLine();
            Function<String, Integer> function = (input) -> new FindLongestSpecialSubstringThatOccursThrice()
                    .maximumLength(input);
            System.out.println(function.apply(s));
            sc.close();
        } catch (Exception e) {
            System.out.println("Exception occurred : " + e.getMessage());
            e.printStackTrace();
        }
    }
}
