import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;

public class SortArrayByParityII {
    int[] evenArr, oddArr;

    public int[] sortArrayByParityII(int[] nums) {
        Consumer<int[]> consumer = (input) -> this.splitElements(input);
        consumer.accept(nums);
        consumer = (input) -> this.generateResult(input);
        consumer.accept(nums);
        return nums;
    }

    private void generateResult(int[] nums) {
        int evenIdx = 0, oddIdx = 0;
        for (int i = 0; i < nums.length; i++)
            nums[i] = (i % 2 == 0) ? (evenArr[evenIdx++]) : (oddArr[oddIdx++]);
    }

    private void splitElements(int[] nums) {
        evenArr = new int[nums.length / 2];
        oddArr = new int[nums.length / 2];
        int evenIdx = 0, oddIdx = 0;
        for (int number : nums) {
            if (number % 2 == 0)
                evenArr[evenIdx++] = number;
            else
                oddArr[oddIdx++] = number;
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
            Function<int[], int[]> function = (inputArr) -> new SortArrayByParityII().sortArrayByParityII(inputArr);
            System.out.println(function.apply(nums));
            sc.close();
        } catch (Exception e) {
            System.out.println("Exception occurred : " + e.getMessage());
            e.printStackTrace();
        }
    }
}
