import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;
import java.util.function.Function;

public class GreatestSumDivisiblebyThree {
    Map<Integer, Queue<Integer>> mapper;
    int totalSum = 0;

    public GreatestSumDivisiblebyThree() {
        mapper = new HashMap<>();
    }

    public int maxSumDivThree(int[] nums) {
        for (int num : nums) {
            totalSum += num;
            int reminder = (num % 3);
            Queue<Integer> pq = mapper.containsKey(reminder) ? mapper.get(reminder) : new PriorityQueue<>();
            pq.add(num);
            mapper.put(reminder, pq);
        }
        if (totalSum % 3 == 0)
            return totalSum;
        int reminderOneAcc = mapper.containsKey(1) ? this.findOutMinDeletionFromSum(totalSum, mapper.get(1))
                : Integer.MAX_VALUE;
        int reminderTwoAcc = mapper.containsKey(2) ? this.findOutMinDeletionFromSum(totalSum, mapper.get(2))
                : Integer.MAX_VALUE;
        if ((totalSum - reminderOneAcc) % 3 != 0)
            return totalSum - reminderTwoAcc;
        return totalSum - Math.min(reminderOneAcc, reminderTwoAcc);
    }

    private int findOutMinDeletionFromSum(int totalSum, Queue<Integer> queue) {
        int sumAccumulation = 0;
        while (!queue.isEmpty()) {
            totalSum = totalSum - queue.peek();
            sumAccumulation += queue.poll();
            if (totalSum % 3 == 0)
                return sumAccumulation;
        }
        return sumAccumulation;
    }

    public static void main(String[] args) {
        Scanner sc;
        try {
            int[] nums;
            sc = new Scanner(System.in);
            System.out.println("Enter length of nums array : ");
            int length = sc.nextInt();
            nums = new int[length];
            for (int i = 0; i < length; i++)
                nums[i] = sc.nextInt();
            Function<int[], Integer> function = (input) -> new GreatestSumDivisiblebyThree().maxSumDivThree(input);
            System.out.println(function.apply(nums));
            sc.close();
        } catch (Exception e) {
            System.out.println("Exception captured : " + e.getMessage());
            e.printStackTrace();
        }
    }
}
