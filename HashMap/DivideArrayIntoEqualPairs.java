import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Function;

public class DivideArrayIntoEqualPairs {
    Map<Integer, Integer> countMapper;

    public DivideArrayIntoEqualPairs() {
        countMapper = new HashMap<>();
    }

    public boolean divideArray(int[] nums) {
        for (int number : nums) {
            countMapper.putIfAbsent(number, 0);
            countMapper.put(number, countMapper.get(number) + 1);
            if (countMapper.get(number) == 2)
                countMapper.remove(number);
        }
        return countMapper.isEmpty();
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
            Function<int[], Boolean> function = (input) -> new DivideArrayIntoEqualPairs().divideArray(input);
            System.out.println(function.apply(nums));
            sc.close();
        } catch (Exception e) {
            System.out.println("Exception occurred : " + e.getMessage());
            e.printStackTrace();
        }
    }
}
