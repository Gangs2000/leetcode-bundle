import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Finding3DigitEvenNumbers {
    Map<Character, Long> digitMapper, tempMapper;
    List<Integer> resultList;

    public Finding3DigitEvenNumbers() {
        digitMapper = new HashMap<>();
        tempMapper = new HashMap<>();
        resultList = new LinkedList<>();
    }

    public int[] findEvenNumbers(int[] digits) {
        List<Character> charsList = new LinkedList<>();
        for (int number : digits)
            charsList.add((char) (number + '0'));
        digitMapper = charsList.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        IntStream.range(100, 1000).boxed().filter((value) -> value % 2 == 0).forEach((value) -> {
            Function<String, Boolean> function = (input) -> this.isValidEvenNumber(input);
            boolean isValidNumber = function.apply(String.valueOf(value));
            if (isValidNumber)
                resultList.add(value);
            tempMapper.clear();
        });
        return resultList.stream().mapToInt(Integer::intValue).toArray();
    }

    private boolean isValidEvenNumber(String numberStr) {
        List<Character> list = Arrays.asList(numberStr.charAt(0), numberStr.charAt(1), numberStr.charAt(2));
        tempMapper = list.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        for (Map.Entry<Character, Long> entry : tempMapper.entrySet()) {
            char key = entry.getKey();
            if (!digitMapper.containsKey(key) || digitMapper.get(key) < (long) entry.getValue())
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc;
        int[] digits;
        try {
            sc = new Scanner(System.in);
            System.out.println("Enter length of digits array : ");
            int length = sc.nextInt();
            digits = new int[length];
            for (int i = 0; i < length; i++)
                digits[i] = sc.nextInt();
            Function<int[], int[]> function = (input) -> new Finding3DigitEvenNumbers().findEvenNumbers(input);
            System.out.println(function.apply(digits));
            sc.close();
        } catch (Exception e) {
            System.out.println("Exception occurred : " + e.getMessage());
            e.printStackTrace();
        }
    }
}
