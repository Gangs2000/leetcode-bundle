import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class LargestCombinationWithBitwiseANDGreaterThanZero {
    int largestCombination = Integer.MIN_VALUE, largestBinaryLength = Integer.MIN_VALUE;
    Map<Integer, Integer> counterMap;

    public LargestCombinationWithBitwiseANDGreaterThanZero() {
        counterMap = new HashMap<>();
    }

    public int largestCombination(int[] candidates) {
        List<String> binaries = Arrays.stream(candidates).boxed()
                .map(decimal -> this.convertedDecimalToBinaryFormat(decimal)).collect(Collectors.toList());
        binaries.forEach(binary -> this.findCommonBits(binary));
        return largestCombination;
    }

    private String convertedDecimalToBinaryFormat(int decimal) {
        String binary = "";
        while (decimal > 0) {
            binary += decimal & 1;
            decimal >>= 1;
        }
        largestBinaryLength = Math.max(largestBinaryLength, binary.length());
        return binary;
    }

    private void findCommonBits(String binary) {
        for (int i = 0; i < binary.length(); i++) {
            if (binary.charAt(i) == '1') {
                counterMap.putIfAbsent(i, 0);
                counterMap.put(i, counterMap.get(i) + 1);
                largestCombination = Math.max(largestCombination, counterMap.get(i));
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc;
        int[] candidates;
        try {
            sc = new Scanner(System.in);
            System.out.println("Enter length of candidates array : ");
            int length = sc.nextInt();
            candidates = new int[length];
            for (int i = 0; i < length; i++)
                candidates[i] = sc.nextInt();
            Function<int[], Integer> function = (input) -> new LargestCombinationWithBitwiseANDGreaterThanZero()
                    .largestCombination(input);
            System.out.println(function.apply(candidates));
            sc.close();
        } catch (Exception e) {
            System.out.println("Exception occurred : " + e.getMessage());
            e.printStackTrace();
        }
    }
}
