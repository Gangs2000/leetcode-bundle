import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.function.BiFunction;

public class MinimumOperationstoMakeArrayValuesEqualtoK {
    Set<Integer> uniqueNum;

    public MinimumOperationstoMakeArrayValuesEqualtoK() {
        uniqueNum = new HashSet<>();
    }

    public int minOperations(int[] nums, int k) {
        for (int number : nums) {
            if (number < k)
                return -1;
            if (number > k)
                uniqueNum.add(number);
        }
        return uniqueNum.size();
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
            BiFunction<int[], Integer, Integer> biFunction = (input1,
                    input2) -> new MinimumOperationstoMakeArrayValuesEqualtoK().minOperations(input1, input2);
            System.out.println(biFunction.apply(nums, k));
            sc.close();
        } catch (Exception e) {
            System.out.println("Exception occurred : " + e.getMessage());
            e.printStackTrace();
        }
    }
}
