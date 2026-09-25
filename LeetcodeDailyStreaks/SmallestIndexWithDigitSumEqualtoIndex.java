import java.util.Scanner;
import java.util.function.Function;

public class SmallestIndexWithDigitSumEqualtoIndex {
    public int smallestIndex(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if ((nums[i] <= 9 && nums[i] == i) || (nums[i] > 9 && sumOfDigit(nums[i]) == i))
                return i;
        }
        return -1;
    }

    private int sumOfDigit(int number) {
        int sum = 0;
        while (number > 0) {
            sum = sum + (number % 10);
            number /= 10;
        }
        return sum;
    }

    public static void main(String[] args) {
        Scanner sc;
        int[] nums;
        try {
            sc = new Scanner(System.in);
            /*
             * System.out.println("Enter nums array length : ");
             * 
             * int length = sc.nextInt();
             * nums = new int[length];
             * for (int i = 0; i < length; i++)
             * nums[i] = sc.nextInt();
             */
            nums = new int[] { 256, 234, 957, 777, 430, 907, 63, 105, 162, 271, 10 };
            Function<int[], Integer> function = new SmallestIndexWithDigitSumEqualtoIndex()::smallestIndex;
            System.out.println(function.apply(nums));
            sc.close();
        } catch (Exception e) {
            System.out.println("Exception occurred : " + e.getMessage());
            e.printStackTrace();
        }
    }
}
