import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CountSubarraysWithMajorityElementII {
    Map<Long, Integer> freqMapper;

    public CountSubarraysWithMajorityElementII() {
        freqMapper = new HashMap<>();
    }

    public long countMajoritySubarrays(int[] nums, int target) {
        long result = 0, validLeftPoints = 0, cumSum = 0;
        freqMapper.put(cumSum, 1);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                validLeftPoints += freqMapper.getOrDefault(cumSum, 0);
                cumSum++;
            } else {
                cumSum--;
                validLeftPoints -= freqMapper.getOrDefault(cumSum, 0);
            }
            result += validLeftPoints;
            freqMapper.merge(cumSum, 1, Integer::sum);
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc;
        int[] nums;
        try {
            sc = new Scanner(System.in);
            System.out.println("Enter length nums array : ");
            int length = sc.nextInt();
            nums = new int[length];
            for (int i = 0; i < length; i++)
                nums[i] = sc.nextInt();
            System.out.println("Enter target value : ");
            int target = sc.nextInt();
            java.util.function.BiFunction<int[], Integer, Long> biFunction = new CountSubarraysWithMajorityElementII()::countMajoritySubarrays;
            System.out.println(biFunction.apply(nums, target));
            sc.close();
        } catch (Exception e) {
            System.out.println("Exception occurred : " + e.getMessage());
            e.printStackTrace();
        }
    }
}
