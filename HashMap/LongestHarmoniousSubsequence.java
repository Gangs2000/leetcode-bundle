import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Function;

public class LongestHarmoniousSubsequence {
    Map<Integer, Integer> freqMapper;
    int longestSubSeqLength = Integer.MIN_VALUE;

    public LongestHarmoniousSubsequence() {
        freqMapper = new HashMap<>();
    }

    public int findLHS(int[] nums) {
        for (int number : nums) {
            freqMapper.putIfAbsent(number, 0);
            freqMapper.put(number, freqMapper.get(number) + 1);
        }
        for (Map.Entry<Integer, Integer> entry : freqMapper.entrySet()) {
            int key = entry.getKey();
            if (freqMapper.containsKey(key + 1))
                longestSubSeqLength = Math.max(longestSubSeqLength, entry.getValue() + freqMapper.get(key + 1));
        }
        return longestSubSeqLength == Integer.MIN_VALUE ? 0 : longestSubSeqLength;
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
            Function<int[], Integer> function = (input) -> new LongestHarmoniousSubsequence().findLHS(input);
            System.out.println(function.apply(nums));
            sc.close();
        } catch (Exception e) {
            System.out.println("Exception occurred : " + e.getMessage());
            e.printStackTrace();
        }
    }
}
