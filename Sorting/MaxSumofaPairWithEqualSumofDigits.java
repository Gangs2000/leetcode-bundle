import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;
import java.util.function.Function;

public class MaxSumofaPairWithEqualSumofDigits {
    Map<Integer, Queue<Integer>> mapper;
    int maxSumOfPair = -1;

    public MaxSumofaPairWithEqualSumofDigits() {
        mapper = new HashMap<>();
    }

    public int maximumSum(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int sumOfCurrentNum = this.sumOfDigit(nums[i]);
            Queue<Integer> queue = (mapper.containsKey(sumOfCurrentNum)) ? mapper.get(sumOfCurrentNum)
                    : new PriorityQueue<>();
            queue.add(nums[i]);
            if (queue.size() == 2) {
                int topElement = queue.poll();
                maxSumOfPair = Math.max(maxSumOfPair, (topElement + queue.peek()));
            }
            mapper.putIfAbsent(sumOfCurrentNum, queue);
        }
        return maxSumOfPair;
    }

    private int sumOfDigit(int num) {
        int sum = 0;
        while (num > 0) {
            sum += (num % 10);
            num /= 10;
        }
        return sum;
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
            Function<int[], Integer> function = (input) -> new MaxSumofaPairWithEqualSumofDigits().maximumSum(input);
            System.out.println(function.apply(nums));
            sc.close();
        } catch (Exception e) {
            System.out.println("Exception occurred : " + e.getMessage());
            e.printStackTrace();
        }
    }
}
