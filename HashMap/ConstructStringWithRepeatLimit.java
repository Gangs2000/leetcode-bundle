import java.util.Collections;
import java.util.Comparator;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.Map.Entry;
import java.util.function.BiFunction;

public class ConstructStringWithRepeatLimit {
    TreeMap<Character, Integer> mapper;
    String resultStr = "";
    Entry<Character, Integer> tempEntry = null;

    public ConstructStringWithRepeatLimit() {
        mapper = new TreeMap<>(new Comparator<Character>() {
            @Override
            public int compare(Character o1, Character o2) {
                return o2.compareTo(o1);
            }
        });
    }

    public String repeatLimitedString(String s, int repeatLimit) {
        // Find frequency of all chars
        this.getFrequencyOfAllChars(s);
        while (!mapper.isEmpty()) {
            Entry<Character, Integer> entry = mapper.pollFirstEntry();
            // If temp entry is not empty
            if (tempEntry != null) {
                resultStr = resultStr + String.valueOf(entry.getKey());
                if (tempEntry.getValue() > 0)
                    mapper.put(tempEntry.getKey(), tempEntry.getValue());
                if (entry.getValue() - 1 > 0)
                    mapper.put(entry.getKey(), entry.getValue() - 1);
                tempEntry = null;
                continue;
            }
            int noOfTimes = (entry.getValue() > repeatLimit) ? (repeatLimit) : (entry.getValue());
            resultStr = resultStr
                    + String.join("", Collections.nCopies(noOfTimes, String.valueOf(entry.getKey())));
            if (entry.getValue() > repeatLimit)
                tempEntry = Map.entry(entry.getKey(), entry.getValue() - repeatLimit);
        }
        return resultStr;
    }

    public void getFrequencyOfAllChars(String s) {
        for (int i = 0; i < s.length(); i++) {
            mapper.putIfAbsent(s.charAt(i), 0);
            mapper.put(s.charAt(i), mapper.get(s.charAt(i)) + 1);
        }
    }

    public static void main(String[] args) {
        Scanner sc;
        try {
            sc = new Scanner(System.in);
            System.out.println("Enter String and RepeatedLimit values : ");
            String string = sc.nextLine();
            int repeatedLimit = sc.nextInt();
            BiFunction<String, Integer, String> biFunction = (input1, input2) -> new ConstructStringWithRepeatLimit()
                    .repeatLimitedString(input1, input2);
            System.out.println(biFunction.apply(string, repeatedLimit));
            sc.close();
        } catch (Exception e) {
            System.out.println("Exception occurred : " + e.getMessage());
            e.printStackTrace();
        }
    }
}
