import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;

public class RankTransformofanArray {
    PriorityQueue<Integer> pq;
    Map<Integer, Integer> mapper;
    int rank = 1;

    public RankTransformofanArray() {
        pq = new PriorityQueue<>();
        mapper = new HashMap<>();
    }

    public int[] arrayRankTransform(int[] arr) {
        Consumer<int[]> sort = (input) -> this.sortAnArray(input);
        sort.accept(arr);
        Consumer<PriorityQueue<Integer>> map = (input) -> this.mapValuesByRank(input);
        map.accept(pq);
        Function<int[], int[]> function = (input) -> this.generateResult(input);
        return function.apply(arr);
    }

    private void sortAnArray(int[] arr) {
        for (int number : arr)
            pq.add(number);
    }

    private void mapValuesByRank(PriorityQueue<Integer> pq) {
        while (!pq.isEmpty()) {
            int currentValue = pq.poll();
            if (!mapper.containsKey(currentValue)) {
                mapper.put(currentValue, rank);
                rank++;
            }
        }
    }

    private int[] generateResult(int[] array) {
        for (int i = 0; i < array.length; i++)
            array[i] = mapper.get(array[i]);
        return array;
    }

    public static void main(String[] args) {
        Scanner sc;
        int[] arr;
        try {
            sc = new Scanner(System.in);
            System.out.println("Enter length of an array : ");
            int length = sc.nextInt();
            arr = new int[length];
            for (int i = 0; i < length; i++)
                arr[i] = sc.nextInt();
            Function<int[], int[]> function = (inputArr) -> new RankTransformofanArray().arrayRankTransform(inputArr);
            System.out.println(function.apply(arr));
            sc.close();
        } catch (Exception e) {
            System.out.println("Exception occurred : " + e.getMessage());
            e.printStackTrace();
        }
    }
}
