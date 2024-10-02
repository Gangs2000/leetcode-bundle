import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.function.BiConsumer;
import java.util.function.Function;

public class SmallestValueoftheRearrangedNumber {
    PriorityQueue<Integer> priorityQueue;
    int count = 0;

    public long smallestNumber(long num) {
        priorityQueue = (num > 0) ? (new PriorityQueue<>()) : (new PriorityQueue<>(Collections.reverseOrder()));
        BiConsumer<Long, PriorityQueue<Integer>> biConsumer = (number, pq) -> this.performSorting(number, pq);
        biConsumer.accept(Math.abs(num), priorityQueue);
        return this.buildString(num, priorityQueue);
    }

    private long buildString(long num, PriorityQueue<Integer> pq) {
        String builder = "";
        while (!pq.isEmpty())
            builder += pq.poll();
        String strZeroes = this.modifyString(num, count);
        if (num > 0) {
            String remainingStr = builder.substring(1);
            builder = String.valueOf(builder.charAt(0)).concat(strZeroes).concat(remainingStr);
            return Long.valueOf(builder);
        } else {
            builder = builder.substring(0).concat(strZeroes);
            return (Long.valueOf(builder) * -1);
        }
    }

    private String modifyString(long num, int count) {
        char[] zeros = new char[count];
        Arrays.fill(zeros, '0');
        return String.valueOf(zeros);
    }

    private void performSorting(long num, PriorityQueue<Integer> priorityQueue) {
        while (num > 0) {
            if ((int) (num % 10) != 0)
                priorityQueue.add((int) (num % 10));
            else
                count++;
            num /= 10;
        }
    }

    public static void main(String[] args) {
        Scanner sc;
        try {
            sc = new Scanner(System.in);
            System.out.println("Enter a number : ");
            long number = sc.nextInt();
            Function<Long, Long> function = (num) -> new SmallestValueoftheRearrangedNumber().smallestNumber(num);
            System.out.println(function.apply(number));
            sc.close();
        } catch (Exception e) {
            System.out.println("Exception occurred : " + e.getMessage());
            e.printStackTrace();
        }
    }
}
