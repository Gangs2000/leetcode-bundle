import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Function;

public class NumberofEquivalentDominoPairs {
    Map<List<Integer>, Integer> frequencyMapper;
    int result = 0;

    public NumberofEquivalentDominoPairs() {
        frequencyMapper = new HashMap<>();
    }

    public int numEquivDominoPairs(int[][] dominoes) {
        // Find frequency for each pair
        this.findFrequencyOfEachPair(dominoes);
        for (Map.Entry<List<Integer>, Integer> entry : frequencyMapper.entrySet()) {
            int n = entry.getValue();
            result += (n * (n - 1)) / 2;
        }
        return result;
    }

    private void findFrequencyOfEachPair(int[][] dominoes) {
        for (int i = 0; i < dominoes.length; i++) {
            List<Integer> keyPair = (dominoes[i][0] < dominoes[i][1]) ? Arrays.asList(dominoes[i][0], dominoes[i][1])
                    : Arrays.asList(dominoes[i][1], dominoes[i][0]);
            frequencyMapper.putIfAbsent(keyPair, 0);
            frequencyMapper.put(keyPair, frequencyMapper.get(keyPair) + 1);
        }
    }

    public static void main(String[] args) {
        Scanner sc;
        int[][] dominoes;
        try {
            sc = new Scanner(System.in);
            System.out.println("Enter length of Dominoes array length : ");
            int length = sc.nextInt();
            dominoes = new int[length][2];
            for (int i = 0; i < length; i++) {
                dominoes[i][0] = sc.nextInt();
                dominoes[i][1] = sc.nextInt();
            }
            Function<int[][], Integer> function = (input) -> new NumberofEquivalentDominoPairs()
                    .numEquivDominoPairs(input);
            System.out.println(function.apply(dominoes));
            sc.close();
        } catch (Exception e) {
            System.out.println("Exception occurred : " + e.getMessage());
            e.printStackTrace();
        }
    }
}
