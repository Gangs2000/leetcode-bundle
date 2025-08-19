import java.util.Scanner;
import java.util.function.Function;

public class NumberofZeroFilledSubarrays {
    long numOfZeroesFilled = 0, count = 1;

    public long zeroFilledSubarray(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == 0 && nums[i + 1] == 0)
                count++;
            else if (nums[i] == 0 && count == 1)
                numOfZeroesFilled++;
            else if (count > 1) {
                numOfZeroesFilled = numOfZeroesFilled + ((count * (count + 1)) / 2);
                count = 1;
            }
        }
        if (count > 1)
            numOfZeroesFilled = numOfZeroesFilled + ((count * (count + 1)) / 2);
        else if (nums[nums.length - 1] == 0 && count == 1)
            numOfZeroesFilled++;
        return numOfZeroesFilled;
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
            Function<int[], Long> function = (input) -> new NumberofZeroFilledSubarrays().zeroFilledSubarray(input);
            System.out.println(function.apply(nums));
            sc.close();
        } catch (Exception e) {
            System.out.println("Exception occurred " + e.getMessage());
            e.printStackTrace();
        }
    }
}
