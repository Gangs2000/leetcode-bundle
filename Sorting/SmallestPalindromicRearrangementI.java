import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.function.UnaryOperator;

public class SmallestPalindromicRearrangementI {
    Map<Character, Integer> freqMap;

    public SmallestPalindromicRearrangementI() {
        freqMap = new TreeMap<>();
    }

    public String smallestPalindrome(String s) {
        int length = s.length();
        if (length == 1)
            return s;
        for (int i = 0; i < length / 2; i++) {
            freqMap.putIfAbsent(s.charAt(i), 0);
            freqMap.put(s.charAt(i), freqMap.get(s.charAt(i)) + 1);
        }

        return this.prepareSmallestPalindrome(freqMap, s);
    }

    private String prepareSmallestPalindrome(Map<Character, Integer> freqMap, String s) {
        StringBuilder result = new StringBuilder();
        for (Map.Entry<Character, Integer> entry : freqMap.entrySet()) {
            int counts = entry.getValue();
            result.append(String.valueOf(entry.getKey()).repeat(counts));
        }
        StringBuilder builder = new StringBuilder(result);
        if (s.length() % 2 == 1) {
            String midChar = String.valueOf(s.charAt(s.length() / 2));
            return result.append(midChar).append(builder.reverse()).toString();
        }
        return result.append(builder.reverse()).toString();
    }

    public static void main(String[] args) {
        Scanner sc;
        try {
            sc = new Scanner(System.in);
            System.out.println("Enter S value : ");
            String s = sc.nextLine();
            UnaryOperator<String> unaryOperator = new SmallestPalindromicRearrangementI()::smallestPalindrome;
            System.out.println(unaryOperator.apply(s));
            sc.close();
        } catch (Exception e) {
            System.out.println("Exception occurred : " + e.getMessage());
            e.printStackTrace();
        }
    }
}
