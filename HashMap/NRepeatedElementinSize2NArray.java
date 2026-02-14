import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Function;

public class NRepeatedElementinSize2NArray {
    Map<Integer, Integer> countMapper;

    public NRepeatedElementinSize2NArray() {
        countMapper = new HashMap<>();
    }

    public int repeatedNTimes(int[] nums) {
        for (int number : nums) {
            countMapper.putIfAbsent(number, 0);
            countMapper.put(number, countMapper.get(number) + 1);
            if (countMapper.get(number) == (nums.length / 2))
                return number;
        }
        return 1;
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
            Function<int[], Integer> function = (input) -> new NRepeatedElementinSize2NArray().repeatedNTimes(input);
            System.out.println(function.apply(nums));
            sc.close();
        } catch (Exception e) {
            System.out.println("Exception occurred : " + e.getMessage());
            e.printStackTrace();
        }
    }
}
