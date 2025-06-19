import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.function.BiFunction;

public class MinimizetheMaximumDifferenceofPairs {
    PriorityQueue<Integer> priorityQueue;
    int maxDiffElement = Integer.MIN_VALUE;

    public MinimizetheMaximumDifferenceofPairs() {
        priorityQueue = new PriorityQueue<>();
    }

    public int minimizeMax(int[] nums, int p) {
        // Load elements into priority queue
        for (int number : nums)
            priorityQueue.add(number);
        for (int i = 0; i < p; i++) {
            int peekElement = priorityQueue.poll();
            int nextPeekElement = priorityQueue.poll();
            maxDiffElement = Math.max(maxDiffElement, Math.abs(peekElement - nextPeekElement));
        }
        return maxDiffElement;
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
            System.out.println("Enter pair value : ");
            int pairs = sc.nextInt();
            BiFunction<int[], Integer, Integer> biFunction = (input1,
                    input2) -> new MinimizetheMaximumDifferenceofPairs().minimizeMax(input1, input2);
            System.out.println(biFunction.apply(nums, pairs));
            sc.close();
        } catch (Exception e) {
            System.out.println("Exception occurred : " + e.getMessage());
            e.printStackTrace();
        }
    }
}
