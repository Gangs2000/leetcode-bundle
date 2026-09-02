import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class ConstructUniformParityArray {
    public boolean uniformArray(int[] nums1) {
        Map<Boolean, java.util.List<Integer>> parityMap = Arrays.stream(nums1).boxed()
                .collect(Collectors.partitioningBy(x -> x % 2 == 0));
        return !parityMap.isEmpty();
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
            Function<int[], Boolean> function = new ConstructUniformParityArray()::uniformArray;
            System.out.println(function.apply(nums));
            sc.close();
        } catch (Exception e) {
            System.out.println("Exception occurred : " + e.getMessage());
            e.printStackTrace();
        }
    }
}
