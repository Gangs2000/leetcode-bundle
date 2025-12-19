import java.util.Scanner;
import java.util.TreeSet;
import java.util.function.BiFunction;

public class CountPartitionsWithMaxMinDifferenceatMostK {
    TreeSet<Integer> queue;
    int countPartitions = 0;

    public CountPartitionsWithMaxMinDifferenceatMostK() {
        queue = new TreeSet<>();
    }

    public int countPartitions(int[] nums, int k) {
        int leftPointer = 0, rightPointer = 0;
        while (rightPointer < nums.length) {
            queue.add(nums[rightPointer++]);
            while (queue.last() - queue.first() <= k) {
                queue.add(nums[rightPointer++]);
                while (!queue.isEmpty() && queue.last() - queue.first() > k)
                    queue.remove(nums[leftPointer++]);
            }
        }
        return countPartitions;
    }

    public static void main(String[] args) {
        Scanner sc;
        int[] nums;
        try {
            sc = new Scanner(System.in);
            System.out.println("Enter length of an array : ");
            int length = sc.nextInt();
            nums = new int[length];
            for (int i = 0; i < length; i++)
                nums[i] = sc.nextInt();
            System.out.println("Enter K value : ");
            int k = sc.nextInt();
            BiFunction<int[], Integer, Integer> bFunction = (input1,
                    input2) -> new CountPartitionsWithMaxMinDifferenceatMostK().countPartitions(input1, input2);
            System.out.println(bFunction.apply(nums, k));
            sc.close();
        } catch (Exception e) {
            System.out.println("Exception occurred : " + e.getMessage());
            e.printStackTrace();
        }
    }
}
