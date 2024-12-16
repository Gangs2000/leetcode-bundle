import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.function.Function;

public class FindScoreofanArrayAfterMarkingAllElements {
    PriorityQueue<List<Integer>> priorityQueue;
    long score = 0L;

    public FindScoreofanArrayAfterMarkingAllElements() {
        priorityQueue = new PriorityQueue<>(new Comparator<List<Integer>>() {
            @Override
            public int compare(List<Integer> o1, List<Integer> o2) {
                if (o1.get(0).equals(o2.get(0)))
                    return o1.get(1).compareTo(o2.get(1));
                return o1.get(0).compareTo(o2.get(0));
            }
        });
    }

    public long findScore(int[] nums) {
        this.loadArrayIntoHead(nums);
        while (!priorityQueue.isEmpty()) {
            List<Integer> minHeap = priorityQueue.poll();
            int minIndex = minHeap.get(1);
            score += minHeap.get(0);
            if (minIndex == 0)
                priorityQueue.remove(Arrays.asList(nums[minIndex + 1], minIndex + 1));
            else if (minIndex == nums.length - 1)
                priorityQueue.remove(Arrays.asList(nums[minIndex - 1], minIndex - 1));
            else {
                priorityQueue.remove(Arrays.asList(nums[minIndex + 1], minIndex + 1));
                priorityQueue.remove(Arrays.asList(nums[minIndex - 1], minIndex - 1));
            }
        }
        return score;
    }

    private void loadArrayIntoHead(int[] nums) {
        for (int i = 0; i < nums.length; i++)
            priorityQueue.add(Arrays.asList(nums[i], i));
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
            Function<int[], Long> function = (input) -> new FindScoreofanArrayAfterMarkingAllElements()
                    .findScore(input);
            System.out.println(function.apply(nums));
            sc.close();
        } catch (Exception e) {
            System.out.println("Exception occurred : " + e.getMessage());
            e.printStackTrace();
        }
    }
}
