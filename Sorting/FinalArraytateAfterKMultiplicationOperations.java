import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class FinalArraytateAfterKMultiplicationOperations {
    PriorityQueue<List<Integer>> priorityQueue;

    public FinalArraytateAfterKMultiplicationOperations() {
        priorityQueue = new PriorityQueue<>(new Comparator<List<Integer>>() {
            @Override
            public int compare(List<Integer> o1, List<Integer> o2) {
                if (o1.get(0).equals(o2.get(0)))
                    return o1.get(1).compareTo(o2.get(1));
                return o1.get(0).compareTo(o2.get(0));
            }
        });
    }

    public int[] getFinalState(int[] nums, int k, int multiplier) {
        int count = 0;
        this.loadArrayIntoHeap(nums);
        while (count < k) {
            List<Integer> minHeap = priorityQueue.poll();
            int minValue = minHeap.get(0), minIndex = minHeap.get(1);
            nums[minIndex] = minValue * multiplier;
            priorityQueue.add(Arrays.asList((minValue * multiplier), minIndex));
            count++;
        }
        return nums;
    }

    public void loadArrayIntoHeap(int[] nums) {
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
            System.out.println("Enter K and Multiplier values : ");
            int k = sc.nextInt(), multiplier = sc.nextInt();
            System.out.println(new FinalArraytateAfterKMultiplicationOperations().getFinalState(nums, k, multiplier));
            sc.close();
        } catch (Exception e) {
            System.out.println("Exception occurred : " + e.getMessage());
            e.printStackTrace();
        }
    }
}
