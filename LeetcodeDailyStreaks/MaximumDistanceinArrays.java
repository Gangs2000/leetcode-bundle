import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;

public class MaximumDistanceinArrays {
    PriorityQueue<List<Integer>> minQueue, maxQueue;

    public MaximumDistanceinArrays() {
        minQueue = new PriorityQueue<>(new Comparator<List<Integer>>() {
            @Override
            public int compare(List<Integer> o1, List<Integer> o2) {
                return o1.get(1).compareTo(o2.get(1));
            }
        });

        maxQueue = new PriorityQueue<>(new Comparator<List<Integer>>() {
            @Override
            public int compare(List<Integer> o1, List<Integer> o2) {
                return o2.get(1).compareTo(o1.get(1));
            }
        });
    }

    public int maxDistance(List<List<Integer>> arrays) {
        Consumer<List<List<Integer>>> consumer = (input) -> this.findMinAndMaxElements(input);
        consumer.accept(arrays);
        BiFunction<PriorityQueue<List<Integer>>, PriorityQueue<List<Integer>>, Integer> biFunction = (min, max) -> this
                .findMinAndMaxDifference(min, max);
        return biFunction.apply(minQueue, maxQueue);
    }

    private int findMinAndMaxDifference(PriorityQueue<List<Integer>> minQueue, PriorityQueue<List<Integer>> maxQueue) {
        int maxDistance = Integer.MIN_VALUE;
        if (!minQueue.isEmpty() && !maxQueue.isEmpty() && minQueue.peek().get(0) != maxQueue.peek().get(0))
            return maxQueue.peek().get(1) - minQueue.peek().get(1);
        else {
            // Poll top 2 lists from min and max PQ's if size is greater than 2
            List<Integer> topMax = maxQueue.poll(), nextMax = maxQueue.poll(), topMin = minQueue.poll(),
                    nextMin = minQueue.poll();
            if (topMax.get(0) != nextMin.get(0))
                maxDistance = Math.max(maxDistance, topMax.get(1) - nextMin.get(1));
            if (nextMax.get(0) != topMin.get(0))
                maxDistance = Math.max(maxDistance, nextMax.get(1) - topMin.get(1));
        }
        return maxDistance;
    }

    private void findMinAndMaxElements(List<List<Integer>> arrays) {
        int currentIndex = 0;
        for (List<Integer> list : arrays) {
            // Add minimum value to queue
            minQueue.add(Arrays.asList(currentIndex, list.get(0)));
            int lastElement = list.get(list.size() - 1);
            // Add max value to queue
            maxQueue.add(Arrays.asList(currentIndex, lastElement));
            currentIndex++;
        }
    }

    public static void main(String[] args) {
        Scanner sc;
        List<List<Integer>> list;
        try {
            sc = new Scanner(System.in);
            list = new LinkedList<>();
            System.out.println("Enter length of list : ");
            int length = sc.nextInt();
            for (int i = 0; i < length; i++)
                // Hard-coded input values
                list.add(Arrays.asList(1, 2, 3));
            Function<List<List<Integer>>, Integer> function = (input) -> new MaximumDistanceinArrays()
                    .maxDistance(input);
            System.out.println(function.apply(list));
            sc.close();
        } catch (Exception e) {
            System.out.println("Exception occurred : " + e.getMessage());
            e.printStackTrace();
        }
    }
}
