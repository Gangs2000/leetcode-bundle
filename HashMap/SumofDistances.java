import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Function;

public class SumofDistances {
    Map<Integer, List<Integer>> mapper;

    public SumofDistances() {
        mapper = new HashMap<>();
    }

    public long[] distance(int[] nums) {
        long[] result = new long[nums.length];
        // Map indicies
        this.mapIndiciesToElement(nums);
        for (Map.Entry<Integer, List<Integer>> entry : mapper.entrySet()) {
            List<Integer> list = entry.getValue();
            if (list.size() == 1) {
                result[list.get(0)] = 0;
                continue;
            }
            long totalSum = 0;
            for (int index : list)
                totalSum += index;
            long prefixSum = 0;
            for (int i = 0; i < list.size(); i++) {
                long leftSum = i == 0 ? 0 : (long) i * list.get(i) - prefixSum;
                prefixSum += list.get(i);
                long rightSum = i == list.size() - 1 ? 0
                        : (totalSum - prefixSum) - (long) list.get(i) * (list.size() - (1 + i));
                result[list.get(i)] = leftSum + rightSum;
            }
        }
        return result;
    }

    private void mapIndiciesToElement(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            List<Integer> list = mapper.containsKey(nums[i]) ? mapper.get(nums[i]) : new LinkedList<>();
            list.add(i);
            mapper.put(nums[i], list);
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
            Function<int[], long[]> function = new SumofDistances()::distance;
            System.out.println(function.apply(nums));
            sc.close();
        } catch (Exception e) {
            System.out.println("Exception occurred : " + e.getMessage());
            e.printStackTrace();
        }
    }
}
