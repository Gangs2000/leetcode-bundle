import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;
import java.util.function.Function;

public class RemoveCoveredIntervals {
    Queue<List<Integer>> pq;

    public RemoveCoveredIntervals() {
        Comparator<List<Integer>> comparator = new Comparator<List<Integer>>() {
            @Override
            public int compare(List<Integer> o1, List<Integer> o2) {
                if (o1.get(0).intValue() == o2.get(0).intValue())
                    return o2.get(1) - o1.get(1);
                return o1.get(0) - o2.get(0);
            }
        };
        pq = new PriorityQueue<>(comparator);
    }

    public int removeCoveredIntervals(int[][] intervals) {
        for (int i = 0; i < intervals.length; i++)
            pq.add(Arrays.asList(intervals[i][0], intervals[i][1]));

        return intervals.length - findCoveredIntervals(pq);
    }

    private int findCoveredIntervals(Queue<List<Integer>> pq) {
        int removedCount = 0;
        boolean isRemoved = false;
        while (!pq.isEmpty()) {
            isRemoved = false;
            List<Integer> list1 = pq.poll();
            if (!pq.isEmpty()) {
                List<Integer> list2 = pq.poll();
                int a = list1.get(0), b = list1.get(1), c = list2.get(0), d = list2.get(1);
                // 2,9 and 2,8
                if (c >= a && b >= d) {
                    isRemoved = true;
                    pq.add(list1);
                }
                if (!isRemoved)
                    pq.add(list2);
            }
            removedCount = (isRemoved) ? removedCount + 1 : removedCount;
        }
        return removedCount;
    }

    public static void main(String[] args) {
        Scanner sc;
        int[][] intervals;
        try {
            sc = new Scanner(System.in);
            System.out.println("Enter length of intervals array : ");
            int length = sc.nextInt();
            intervals = new int[length][2];
            for (int i = 0; i < length; i++) {
                intervals[i][0] = sc.nextInt();
                intervals[i][1] = sc.nextInt();
            }
            Function<int[][], Integer> function = new RemoveCoveredIntervals()::removeCoveredIntervals;
            System.out.println(function.apply(intervals));
            sc.close();
        } catch (Exception e) {
            System.out.println("Exception occurred : " + e.getMessage());
            e.printStackTrace();
        }
    }
}
