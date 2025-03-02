import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;
import java.util.function.BiFunction;

public class MinimumOperationstoExceedThresholdValueII {
    Queue<Long> heapQueue;
    int minOperation = 0;

    public MinimumOperationstoExceedThresholdValueII() {
        heapQueue = new PriorityQueue<>();
    }

    public int minOperations(int[] nums, int k) {
        // Load num values to Head Queue
        this.loadNumsIntoQueue(nums);
        while (!heapQueue.isEmpty() && heapQueue.peek() < k) {
            long leastValue = heapQueue.poll();
            if (!heapQueue.isEmpty()) {
                long nextLeadValue = heapQueue.poll();
                heapQueue.add((Math.min(leastValue, nextLeadValue) * 2) + (Math.max(leastValue, nextLeadValue)));
                minOperation++;
            }
        }
        return minOperation;
    }

    private void loadNumsIntoQueue(int[] nums) {
        for (long number : nums)
            heapQueue.add(number);
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
            System.out.println("Enter K value : ");
            int k = sc.nextInt();
            BiFunction<int[], Integer, Integer> biFunction = (input1,
                    input2) -> new MinimumOperationstoExceedThresholdValueII().minOperations(input1, input2);
            System.out.println(biFunction.apply(nums, k));
            sc.close();
        } catch (Exception e) {
            System.out.println("Exception occurred : " + e.getMessage());
            e.printStackTrace();
        }
    }
}
