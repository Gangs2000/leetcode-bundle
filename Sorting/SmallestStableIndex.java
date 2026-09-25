import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;
import java.util.function.BiFunction;

public class SmallestStableIndex {
    Queue<Integer> minQueue, maxQueue;

    public SmallestStableIndex() {
        minQueue = new PriorityQueue<>();
        maxQueue = new PriorityQueue<>((o1, o2) -> o2.compareTo(o1));
    }

    public int firstStableIndex(int[] nums, int k) {
        int minStableIndex = Integer.MAX_VALUE;
        maxQueue.add(nums[0]);
        for (int i = 0; i < nums.length; i++)
            minQueue.add(nums[i]);
        for (int i = 0; i < nums.length; i++) {
            if (i != 0)
                maxQueue.add(nums[i]);
            int stableIndex = maxQueue.peek() - minQueue.peek();
            minQueue.remove(Integer.valueOf(nums[i]));
            if (stableIndex <= k)
                minStableIndex = Math.min(minStableIndex, i);
        }
        return minStableIndex == Integer.MAX_VALUE ? -1 : minStableIndex;
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
            BiFunction<int[], Integer, Integer> biFunction = new SmallestStableIndex()::firstStableIndex;
            System.out.println(biFunction.apply(nums, k));
            sc.close();
        } catch (Exception e) {
            System.out.println("Exception occurred : " + e.getMessage());
            e.printStackTrace();
        }
    }
}
