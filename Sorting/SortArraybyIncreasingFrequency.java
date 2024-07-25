import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;

public class SortArraybyIncreasingFrequency {
    PriorityQueue<List<Integer>> pq;
    Map<Integer, Integer> mapper;

    public SortArraybyIncreasingFrequency() {
        pq = new PriorityQueue<>(new Comparator<List<Integer>>() {
            @Override
            public int compare(List<Integer> o1, List<Integer> o2) {
                if (o1.get(1) == o2.get(1))
                    return o2.get(0).compareTo(o1.get(0));
                return o1.get(1).compareTo(o2.get(1));
            }
        });
        mapper = new HashMap<>();
    }

    public int[] frequencySort(int[] nums) {
        int index = 0;
        Consumer<int[]> consumer = (arr) -> this.mapValuesAndHeapifySorting(arr);
        consumer.accept(nums);
        while (!pq.isEmpty()) {
            List<Integer> list = pq.poll();
            this.buildArr(list.get(0), index, index + list.get(1), nums);
            index += list.get(1);
        }
        return nums;
    }

    private void buildArr(int element, int start, int end, int[] nums) {
        for (int i = start; i < end; i++)
            nums[i] = element;
    }

    private void mapValuesAndHeapifySorting(int[] nums) {
        for (int number : nums) {
            mapper.putIfAbsent(number, 0);
            pq.remove(Arrays.asList(number, mapper.get(number)));
            mapper.put(number, mapper.get(number) + 1);
            pq.add(Arrays.asList(number, mapper.get(number)));
        }
    }

    public static void main(String[] args) {
        Scanner sc;
        int[] nums;
        try {
            sc = new Scanner(System.in);
            System.out.println("Enter length of nums array : ");
            int length = sc.nextInt();
            nums = new int[length];
            for (int i = 0; i < length; i++)
                nums[i] = sc.nextInt();
            Function<int[], int[]> function = (arr) -> new SortArraybyIncreasingFrequency().frequencySort(arr);
            System.out.println(function.apply(nums));
            sc.close();
        } catch (Exception e) {
            System.out.println("Exception occurred : " + e.getMessage());
            e.printStackTrace();
        }
    }
}
