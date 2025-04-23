import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.IntStream;

public class CountLargestGroup {
    Map<Integer, List<Integer>> mapper;
    int maxLengthSeenSoFar = 1, maxCount = 9, result = 0;

    public CountLargestGroup() {
        mapper = new HashMap<>();
        // Load initial values into Map
        for (int i = 1; i <= 9; i++) {
            List<Integer> list = new LinkedList<>();
            list.add(i);
            mapper.put(i, list);
        }
    }

    public int countLargestGroup(int n) {
        if (n <= 9)
            return n;
        IntStream.range(10, n + 1).forEach((num) -> {
            Consumer<Integer> consumer = (input) -> this.sumOfDigits(input);
            consumer.accept(num);
        });
        return result;
    }

    private void sumOfDigits(int number) {
        int sum = 0, value = number;
        while (number > 0) {
            sum = sum + (number % 10);
            number /= 10;
        }
        // Update mapper..
        List<Integer> list = (mapper.containsKey(sum)) ? mapper.get(sum) : new LinkedList<>();
        list.add(value);
        mapper.put(sum, list);

        if (list.size() > maxLengthSeenSoFar) {
            maxLengthSeenSoFar = list.size();
            maxCount = 0;
        }

        if (maxLengthSeenSoFar == list.size()) {
            maxCount++;
            result = maxCount;
        }
    }

    public static void main(String[] args) {
        Scanner sc;
        try {
            sc = new Scanner(System.in);
            System.out.println("Enter N value : ");
            int n = sc.nextInt();
            Function<Integer, Integer> function = (input) -> new CountLargestGroup().countLargestGroup(input);
            System.out.println(function.apply(n));
            sc.close();
        } catch (Exception e) {
            System.out.println("Exception occurred : " + e.getMessage());
            e.printStackTrace();
        }
    }
}
