import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Function;

public class UniqueLength3PalindromicSubsequences {
    Map<Character, List<Integer>> mapper;
    int totalPalindromeCount = 0;

    public UniqueLength3PalindromicSubsequences() {
        mapper = new HashMap<>();
    }

    public int countPalindromicSubsequence(String s) {
        this.findFirstAndLastIndexOfEachChar(s);
        if (!mapper.isEmpty()) {
            for (Map.Entry<Character, List<Integer>> entry : mapper.entrySet()) {
                List<Integer> list = entry.getValue();
                if (list.size() > 1) {
                    int beginIndex = list.get(0), endIndex = list.get(1);
                    this.countAllPalindrome(s.substring(beginIndex + 1, endIndex));
                }
            }
        }
        return totalPalindromeCount;
    }

    private void findFirstAndLastIndexOfEachChar(String s) {
        for (int i = 0; i < s.length(); i++) {
            List<Integer> list = mapper.containsKey(s.charAt(i)) ? mapper.get(s.charAt(i)) : new LinkedList<>();
            if (list.isEmpty() || list.size() == 1)
                list.add(i);
            else
                list.set(1, i);
            mapper.put(s.charAt(i), list);
        }
    }

    private void countAllPalindrome(String currentStr) {
        for (char i = 'a'; i <= 'z'; i++) {
            if (currentStr.indexOf(String.valueOf(i)) != -1)
                totalPalindromeCount++;
        }
    }

    public static void main(String[] args) {
        Scanner sc;
        try {
            sc = new Scanner(System.in);
            System.out.println("Enter a String : ");
            String s = sc.nextLine();
            Function<String, Integer> function = (input) -> new UniqueLength3PalindromicSubsequences()
                    .countPalindromicSubsequence(input);
            System.out.println(function.apply(s));
            sc.close();
        } catch (Exception e) {
            System.out.println("Exception occurred : " + e.getMessage());
            e.printStackTrace();
        }
    }
}
