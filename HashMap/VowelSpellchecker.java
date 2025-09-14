import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.function.BiFunction;
import java.util.stream.IntStream;

public class VowelSpellchecker {
    Map<String, String> caseMapper, vowelErrorMapper;
    List<String> exactWordList;

    public VowelSpellchecker() {
        caseMapper = new HashMap<>();
        vowelErrorMapper = new HashMap<>();
        exactWordList = new LinkedList<>();
    }

    public String[] spellchecker(String[] wordlist, String[] queries) {
        String[] result = new String[queries.length];
        this.caseMapper(wordlist);
        this.vowelErrorMapper(wordlist);
        for (int i = 0; i < queries.length; i++) {
            // Case 1 - Exact match
            if (exactWordList.contains(queries[i]))
                result[i] = queries[i];
            // Case 2 - Case Match
            else if (caseMapper.containsKey(queries[i].toLowerCase()))
                result[i] = caseMapper.get(queries[i].toLowerCase());
            // Case 3 - Mask vowel with *
            else {
                String maskedWord = this.replaceVowelWithRegex(queries[i]);
                if (vowelErrorMapper.containsKey(maskedWord))
                    result[i] = vowelErrorMapper.get(maskedWord);
                else
                    result[i] = "";
            }
        }
        return result;
    }

    // Case Mapper
    private void caseMapper(String[] wordsList) {
        for (String word : wordsList) {
            exactWordList.add(word);
            if (!caseMapper.containsKey(word.toLowerCase()))
                caseMapper.put(word.toLowerCase(), word);
        }
    }

    // VowelError Mapper
    private void vowelErrorMapper(String[] wordsList) {
        for (String word : wordsList) {
            String modifiedWord = this.replaceVowelWithRegex(word);
            if (!vowelErrorMapper.containsKey(modifiedWord.toString()))
                vowelErrorMapper.put(modifiedWord.toString(), word);
        }
    }

    // Mask Vowel with *
    private String replaceVowelWithRegex(String word) {
        StringBuilder modifiedWord = new StringBuilder(word.toLowerCase());
        for (int i = 0; i < modifiedWord.length(); i++) {
            if (Arrays.asList('a', 'e', 'i', 'o', 'u').contains(modifiedWord.charAt(i)))
                modifiedWord.setCharAt(i, '*');
        }
        return modifiedWord.toString();
    }

    public static void main(String[] args) {
        Scanner sc;
        String[] wordsList, queries;
        try {
            sc = new Scanner(System.in);
            System.out.println("Enter length of wordList and queries array : ");
            int wordListLength = sc.nextInt(), queriesLength = sc.nextInt();
            wordsList = new String[wordListLength];
            queries = new String[queriesLength];
            IntStream.range(0, wordListLength).forEach(i -> {
                wordsList[i] = sc.useDelimiter("\n").next();
            });
            IntStream.range(0, queriesLength).forEach(i -> {
                queries[i] = sc.useDelimiter("\n").next();
            });
            BiFunction<String[], String[], String[]> biFunction = (input1, input2) -> new VowelSpellchecker()
                    .spellchecker(input1, input2);
            System.out.println(biFunction.apply(wordsList, queries));
            sc.close();
        } catch (Exception e) {
            System.out.println("Exception occurred : " + e.getMessage());
            e.printStackTrace();
        }
    }
}
