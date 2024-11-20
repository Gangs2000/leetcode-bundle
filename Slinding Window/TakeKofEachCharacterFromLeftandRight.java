import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.function.BiFunction;

public class TakeKofEachCharacterFromLeftandRight {
    Map<Character, Integer> charMapper;
    int minimumDeletion = Integer.MAX_VALUE;

    public TakeKofEachCharacterFromLeftandRight() {
        charMapper = new HashMap<>();
    }

    public int takeCharacters(String s, int k) {
        if (k == 0)
            return 0;
        // Initial characters mapping
        // Special case
        if (this.specialCase(s, k))
            return s.length();
        this.initialMappingOfEachChars(s);
        int leftPointer = 0, rightPointer = 0;
        // Move window one by one
        while (leftPointer < s.length()) {
            while (rightPointer < s.length()) {
                char currentChar = s.charAt(rightPointer);
                if (charMapper.containsKey(currentChar))
                    charMapper.put(currentChar, charMapper.get(currentChar) - 1);
                rightPointer++;
                if (!this.calculateWindow(k))
                    break;
            }
            charMapper.putIfAbsent(s.charAt(leftPointer), 0);
            charMapper.put(s.charAt(leftPointer), charMapper.get(s.charAt(leftPointer)) + 1);
            leftPointer++;
        }
        return minimumDeletion == Integer.MAX_VALUE ? -1 : minimumDeletion;
    }

    private boolean calculateWindow(int k) {
        if (charMapper.containsKey('a') && charMapper.containsKey('b') && charMapper.containsKey('c')) {
            int countOfA = charMapper.get('a'), countOfB = charMapper.get('b'), countOfC = charMapper.get('c');
            if (countOfA >= k && countOfB >= k && countOfC >= k)
                minimumDeletion = Math.min(minimumDeletion, countOfA + countOfB + countOfC);
            else
                return false;
        } else
            return false;
        return true;
    }

    private void initialMappingOfEachChars(String s) {
        for (int i = 0; i < s.length(); i++) {
            charMapper.putIfAbsent(s.charAt(i), 0);
            charMapper.put(s.charAt(i), charMapper.get(s.charAt(i)) + 1);
        }
    }

    private boolean specialCase(String s, int k) {
        boolean flag = false;
        if (charMapper.containsKey('a') && charMapper.containsKey('b') && charMapper.containsKey('c')) {
            int countOfA = charMapper.get('a'), countOfB = charMapper.get('b'), countOfC = charMapper.get('c');
            if (countOfA == k && countOfB == k && countOfC == k)
                flag = true;
        }
        return flag;
    }

    public static void main(String[] args) {
        Scanner sc;
        try {
            sc = new Scanner(System.in);
            System.out.println("Enter a String : ");
            String s = sc.next();
            System.out.println("Enter K value : ");
            int k = sc.nextInt();
            BiFunction<String, Integer, Integer> biFunction = (input1,
                    input2) -> new TakeKofEachCharacterFromLeftandRight().takeCharacters(input1, input2);
            System.out.println(biFunction.apply(s, k));
            sc.close();
        } catch (Exception e) {
            System.out.println("Exception occurred : " + e.getMessage());
            e.printStackTrace();
        }
    }
}
