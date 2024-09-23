import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.function.BiConsumer;
import java.util.function.Function;

public class SmallestValueoftheRearrangedNumber {
    PriorityQueue<Integer> priorityQueue;

    public long smallestNumber(long num) {
        priorityQueue = (num > 0) ? (new PriorityQueue<>()) : (new PriorityQueue<>(Collections.reverseOrder()));
        BiConsumer<Long, PriorityQueue<Integer>> biConsumer = (number, pq) -> this.performSorting(number, pq);
        biConsumer.accept(Math.abs(num), priorityQueue);
        while (!priorityQueue.isEmpty())
            System.out.print(priorityQueue.poll());
        return 1L;
    }

    private void performSorting(long num, PriorityQueue<Integer> priorityQueue) {
        while (num > 0) {
            priorityQueue.add((int) (num % 10));
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
