import java.util.Scanner;
import java.util.function.Function;

public class CountPrefixandSuffixPairsI {
    int totalCount = 0;

    public int countPrefixSuffixPairs(String[] words) {
        for (int i = 0; i < words.length - 1; i++) {
            for (int j = i + 1; j < words.length; j++) {
                if (words[i].length() <= words[j].length()
                        && words[i].equals(words[j].substring(0, words[i].length()))
                        && words[i].equals(words[j].substring(words[j].length() - words[i].length())))
                    totalCount++;
            }
        }
        return totalCount;
    }

    public static void main(String[] args) {
        Scanner sc;
        String[] words;
        try {
            sc = new Scanner(System.in);
            System.out.println("Enter length of words array : ");
            int length = sc.nextInt();
            words = new String[length];
            for (int i = 0; i < length; i++)
                words[i] = sc.useDelimiter("\n").nextLine();
            Function<String[], Integer> function = (input) -> new CountPrefixandSuffixPairsI()
                    .countPrefixSuffixPairs(input);
            System.out.println(function.apply(words));
            sc.close();
        } catch (Exception e) {
            System.out.println("Exception occurred : " + e.getMessage());
            e.printStackTrace();
        }
    }
}
