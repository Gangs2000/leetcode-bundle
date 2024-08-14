import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;

public class MinimumNumberofPushestoTypeWordII {
    Map<Character, Integer> freqMapper;
    PriorityQueue<List<Object>> priorityQueue;

    public MinimumNumberofPushestoTypeWordII() {
        freqMapper = new HashMap<>();
        priorityQueue = new PriorityQueue<>(new Comparator<List<Object>>() {
            @Override
            public int compare(List<Object> o1, List<Object> o2) {
                return Integer.valueOf((int) o2.get(1)).compareTo(Integer.valueOf((int) o1.get(1)));
            }
        });
    }

    public int minimumPushes(String word) {
        Consumer<String> consumer = (input) -> this.mapEachCharacters(input);
        consumer.accept(word);
        return this.mapNoOfCountToBePushed(priorityQueue);
    }

    private void mapEachCharacters(String word) {
        for (int i = 0; i < word.length(); i++) {
            freqMapper.putIfAbsent(word.charAt(i), 0);
            int currentValue = freqMapper.get(word.charAt(i));
            freqMapper.put(word.charAt(i), freqMapper.get(word.charAt(i)) + 1);
            priorityQueue.remove(Arrays.asList(word.charAt(i), currentValue));
            priorityQueue.add(Arrays.asList(word.charAt(i), currentValue + 1));
        }
    }

    private int mapNoOfCountToBePushed(PriorityQueue<List<Object>> priorityQueue) {
        freqMapper.clear();
        int noOfPress = 1, count = 0, totalSum = 0;
        while (!priorityQueue.isEmpty()) {
            int frequency = (int) priorityQueue.poll().get(1);
            totalSum += (frequency * noOfPress);
            count++;
            if (count == 8) {
                count = 0;
                noOfPress++;
            }
        }
        return totalSum;
    }

    public static void main(String[] args) {
        Scanner sc;
        try {
            sc = new Scanner(System.in);
            System.out.println("Enter a word : ");
            String word = sc.nextLine();
            Function<String, Integer> function = (input) -> new MinimumNumberofPushestoTypeWordII()
                    .minimumPushes(input);
            System.out.println(function.apply(word));
            sc.close();
        } catch (Exception e) {
            System.out.println("Exception occurred : " + e.getMessage());
            e.printStackTrace();
        }
    }
}
