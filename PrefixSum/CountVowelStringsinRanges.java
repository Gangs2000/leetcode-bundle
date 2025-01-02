import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.BiFunction;
import java.util.stream.IntStream;

class CountVowelStringsinRanges {

    public int[] vowelStrings(String[] words, int[][] queries) {
        int[] cummulativeSum = new int[words.length];
        this.findCummulativeSum(words, cummulativeSum);
        BiFunction<int[][], int[], int[]> function = (input1, input2) -> this.quereingTheRanges(input1, input2);
        return function.apply(queries, cummulativeSum);
    }

    private void findCummulativeSum(String[] words, int[] cummulativeSum) {
        List<Character> vowels = Arrays.asList('a', 'e', 'i', 'o', 'u');
        int index = 0, currentSum = 0;
        for (String word : words) {
            if (vowels.contains(word.charAt(0)) && vowels.contains(word.charAt(word.length() - 1)))
                currentSum++;
            cummulativeSum[index++] = currentSum;
        }
    }

    private int[] quereingTheRanges(int[][] queries, int[] cummulativeSum) {
        int[] resultArr = new int[queries.length];
        for (int i = 0; i < queries.length; i++)
            resultArr[i] = (queries[i][0] == 0) ? (cummulativeSum[queries[i][1]])
                    : (cummulativeSum[queries[i][1]] - cummulativeSum[queries[i][0] - 1]);
        return resultArr;
    }

    public static void main(String[] args) {
        Scanner sc;
        String[] words;
        int[][] queries;
        try {
            sc = new Scanner(System.in);
            System.out.println("Enter length of words array : ");
            int wordLength = sc.nextInt();
            words = new String[wordLength];
            IntStream.range(0, wordLength).forEach((index) -> {
                words[index] = sc.useDelimiter("\n").nextLine();
            });
            System.out.println("Enter length of queries array : ");
            int queryLength = sc.nextInt();
            queries = new int[queryLength][2];
            IntStream.range(0, queryLength).forEach((index) -> {
                queries[index][0] = sc.nextInt();
                queries[index][1] = sc.nextInt();
            });
            BiFunction<String[], int[][], int[]> biFunction = (input1, input2) -> new CountVowelStringsinRanges()
                    .vowelStrings(input1, input2);
            System.out.println(biFunction.apply(words, queries));
            sc.close();
        } catch (Exception e) {
            System.out.println("Exception occurred : " + e.getMessage());
            e.printStackTrace();
        }
    }
}