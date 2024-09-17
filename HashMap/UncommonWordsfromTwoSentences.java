import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class UncommonWordsfromTwoSentences {
    Map<String, Integer> mapper;

    public UncommonWordsfromTwoSentences() {
        mapper = new HashMap<>();
    }

    public String[] uncommonFromSentences(String s1, String s2) {
        this.mapFrequencyOfWords(s1);
        this.mapFrequencyOfWords(s2);
        return this.getSingleFrequencyWords(mapper).stream().toArray(String[]::new);
    }

    private void mapFrequencyOfWords(String sentence) {
        String[] words = sentence.split(" ");
        for (String word : words) {
            mapper.putIfAbsent(word, 0);
            mapper.put(word, mapper.get(word) + 1);
        }
    }

    private List<String> getSingleFrequencyWords(Map<String, Integer> mapper) {
        return mapper.entrySet().stream().filter(entry -> entry.getValue() == 1).map(entry -> entry.getKey())
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        Scanner sc;
        try {
            sc = new Scanner(System.in);
            System.out.println("Enter s1 word : ");
            String s1 = sc.useDelimiter("\n").nextLine();
            System.out.println("Enter S2 word : ");
            String s2 = sc.useDelimiter("\n").nextLine();
            System.out.println(new UncommonWordsfromTwoSentences().uncommonFromSentences(s1, s2));
            sc.close();
        } catch (Exception e) {
            System.out.println("Exception occurred : " + e.getMessage());
            e.printStackTrace();
        }
    }
}
