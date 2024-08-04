import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.function.Consumer;

public class RangeSumofSortedSubarraySums {
    private static final int MOD = 1000000007;
    PriorityQueue<Integer> priorityQueue;
    int rangeSum = 0;

    public RangeSumofSortedSubarraySums() {
        priorityQueue = new PriorityQueue<>();
    }

    public int rangeSum(int[] nums, int n, int left, int right) {
        Consumer<int[]> consumer = (numArr) -> this.addSumToPriorityQueue(nums);
        consumer.accept(nums);
        return this.rangeSumCalculation(priorityQueue, left, right) % MOD;
    }

    private int rangeSumCalculation(PriorityQueue<Integer> priorityQueue, int left, int right) {
        int rangeSum = 0, index = 1;
        while (!priorityQueue.isEmpty()) {
            int currentElement = priorityQueue.poll();
            if (index < left) {
                index++;
                continue;
            }
            if (index >= left && index <= right)
                rangeSum = (rangeSum + currentElement) % MOD;
            if (index > right)
                break;
            index++;
        }
        return rangeSum;
    }

    private void addSumToPriorityQueue(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int currentSum = 0;
            for (int j = i; j < nums.length; j++) {
                currentSum += nums[j];
                priorityQueue.add(currentSum);
            }
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
            System.out.println("Enter length of N, Left and Right values : ");
            int n = sc.nextInt();
            int left = sc.nextInt();
            int right = sc.nextInt();
            System.out.println(new RangeSumofSortedSubarraySums().rangeSum(nums, n, left, right));
            sc.close();
        } catch (Exception e) {
            System.out.println("Exception occurred : " + e.getMessage());
            e.printStackTrace();
        }
    }
}
