import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.function.Function;

public class MaximumNumberofBalloons {
    Map<Character, Integer> freqMapper;
    Set<Character> chars;

    public MaximumNumberofBalloons() {
        freqMapper = new HashMap<>();
        chars = Set.of('b', 'a', 'l', 'o', 'n');
    }

    public int maxNumberOfBalloons(String text) {
        for (char c : text.toCharArray()) {
            if (chars.contains(c)) {
                freqMapper.putIfAbsent(c, 0);
                freqMapper.put(c, freqMapper.get(c) + 1);
            }
        }
        if (chars.equals(freqMapper.keySet())) {
            freqMapper.put('l', freqMapper.get('l') / 2);
            freqMapper.put('o', freqMapper.get('o') / 2);
            return freqMapper.values().stream().min(Integer::compareTo).get();
        }
        return 0;
    }

    public static void main(String[] args) {
        Scanner sc;
        try {
            sc = new Scanner(System.in);
            System.out.println("Enter text value : ");
            String text = sc.next();
            Function<String, Integer> function = new MaximumNumberofBalloons()::maxNumberOfBalloons;
            System.out.println(function.apply(text));
            sc.close();
        } catch (Exception e) {
            System.out.println("Exception occurred : " + e.getMessage());
            e.printStackTrace();
        }
    }
}
